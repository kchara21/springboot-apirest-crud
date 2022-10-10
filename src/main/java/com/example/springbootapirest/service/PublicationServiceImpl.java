package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.PublicationDTO;
import com.example.springbootapirest.dto.PublicationResponse;
import com.example.springbootapirest.entities.Publication;
import com.example.springbootapirest.exceptions.ResourceNotFoundException;
import com.example.springbootapirest.repository.PublicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService{

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PublicationDTO createPublication(PublicationDTO publicationDTO) {
        //Convertimos de DTO a entidad
        Publication publication = mappingEntity(publicationDTO);

        Publication newPublication = publicationRepository.save(publication);

        PublicationDTO publicationResponse = mappingDTO(newPublication);

        return publicationResponse;
    }

    @Override
    public PublicationResponse listAllPublications(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable  =  PageRequest.of(pageNumber,pageSize,sort);

        Page<Publication> publications = publicationRepository.findAll(pageable);

        List<Publication> listPublications = publications.getContent();
        List <PublicationDTO> content = listPublications.stream().map(publication -> mappingDTO(publication)).collect(Collectors.toList());

        PublicationResponse publicationResponse = new PublicationResponse();
        publicationResponse.setContent(content);
        publicationResponse.setPageNumber(publications.getNumber());
        publicationResponse.setPageSize(publications.getSize());
        publicationResponse.setTotalElements(publications.getTotalElements());
        publicationResponse.setTotalPages(publications.getTotalPages());
        publicationResponse.setLast(publications.isLast());

        return publicationResponse;
    }

    @Override
    public PublicationDTO listOnePublicationById(long id) {
        Publication publication = publicationRepository
                .findById(id).orElseThrow(()-> new ResourceNotFoundException("Publication","id",id));
        return mappingDTO(publication);
    }

    @Override
    public PublicationDTO updatePublication(PublicationDTO publicationDTO, long id) {
        Publication publication = publicationRepository
                .findById(id).orElseThrow(()-> new ResourceNotFoundException("Publication","id",id));

        publication.setTitle(publicationDTO.getTitle());
        publication.setDescription(publicationDTO.getDescription());
        publication.setContent(publicationDTO.getContent());

        Publication publicationUpdated = publicationRepository.save(publication);
        return mappingDTO(publicationUpdated);


    }

    @Override
    public void deletePublication(long id) {
        Publication publication = publicationRepository
                .findById(id).orElseThrow(()-> new ResourceNotFoundException("Publication","id",id));
        publicationRepository.delete(publication);
    }

    //Convierte entidad a DTO
    private PublicationDTO mappingDTO(Publication publication){
        PublicationDTO publicationDTO = modelMapper.map(publication,PublicationDTO.class);
        return publicationDTO;
    }

    //Convierte de DTO a Entidad
    private Publication mappingEntity(PublicationDTO publicationDTO){
        Publication publication = modelMapper.map(publicationDTO,Publication.class);
        return publication;
    }



}
