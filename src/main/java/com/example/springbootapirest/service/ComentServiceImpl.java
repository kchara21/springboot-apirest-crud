package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.ComentDTO;
import com.example.springbootapirest.entities.Coment;
import com.example.springbootapirest.entities.Publication;
import com.example.springbootapirest.exceptions.BlogAppException;
import com.example.springbootapirest.exceptions.ResourceNotFoundException;
import com.example.springbootapirest.repository.ComentRepository;
import com.example.springbootapirest.repository.PublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentServiceImpl implements ComentService{

    // Inyeccion del repositorio comentRepository
    @Autowired
    private ComentRepository comentRepository;

    // Inyeccion del repositorio publicationRepository
    @Autowired
    private PublicationRepository publicationRepository;

    // Inyeccion de ModelMapper para la el mapeo de las entidades/dto
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public ComentDTO createComent(long publicationId, ComentDTO comentDTO) {
        Coment coment = mappingEntity(comentDTO);

        Publication publication = publicationRepository
                .findById(publicationId).orElseThrow(()-> new ResourceNotFoundException("Publication","id",publicationId));

        coment.setPublication(publication);
        Coment newComent = comentRepository.save(coment);
        return mappingDTO(newComent);
    }

    @Override
    public List<ComentDTO> listAllComentsByPublicationId(long publicationId) {
        List<Coment> coments = comentRepository.findByPublicationId(publicationId);
        return coments.stream().map(coment -> mappingDTO(coment)).collect(Collectors.toList());

    }

    @Override
    public ComentDTO listComentById(Long publicationId, Long comentId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(()-> new ResourceNotFoundException("Publication","id",publicationId));

        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(()-> new ResourceNotFoundException("Coment","id",comentId));

        if(!coment.getPublication().getId().equals(publication.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"The comment does not belong to the publication");
        }
        return mappingDTO(coment);
    }

    @Override
    public ComentDTO updateComent(Long publicationId, Long comentId, ComentDTO comentRequest) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(()-> new ResourceNotFoundException("Publication","id",publicationId));

        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(()-> new ResourceNotFoundException("Coment","id",comentId));

        if(!coment.getPublication().getId().equals(publication.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"The comment does not belong to the publication");
        }

        coment.setName(comentRequest.getName());
        coment.setEmail(comentRequest.getEmail());
        coment.setBody(comentRequest.getBody());

        Coment comentUpdated = comentRepository.save(coment);

        return mappingDTO(comentUpdated);

    }

    @Override
    public void deleteComent(Long publicationId, Long comentId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(()-> new ResourceNotFoundException("Publication","id",publicationId));

        Coment coment = comentRepository.findById(comentId)
                .orElseThrow(()-> new ResourceNotFoundException("Coment","id",comentId));

        if(!coment.getPublication().getId().equals(publication.getId())){
            throw new BlogAppException(HttpStatus.BAD_REQUEST,"The comment does not belong to the publication");
        }

        comentRepository.delete(coment);
    }

    // Convert Entity to DTO
    private ComentDTO mappingDTO(Coment coment){
        ComentDTO comentDTO = modelMapper.map(coment,ComentDTO.class);
        return comentDTO;
    }

    private Coment mappingEntity(ComentDTO comentDTO){
        Coment coment = modelMapper.map(comentDTO,Coment.class);
        return coment;
    }
}
