package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.ComentDTO;

import java.util.List;

public interface ComentService {
    public ComentDTO createComent(long publicationId, ComentDTO comentDTO);

    public List<ComentDTO> listAllComentsByPublicationId(long publicationId);

    public ComentDTO listComentById(Long publicationId,Long comentId);

    public ComentDTO updateComent(Long publicationId,Long comentId, ComentDTO comentRequest);

    public void deleteComent(Long publicationId, Long comentId );

}
