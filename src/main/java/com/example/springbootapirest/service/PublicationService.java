package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.PublicationDTO;
import com.example.springbootapirest.dto.PublicationResponse;

public interface PublicationService {
    public PublicationDTO createPublication(PublicationDTO publicationDTO);

    public PublicationResponse listAllPublications(int pageNumber, int pageSize, String sortBy, String sortDir);

    public PublicationDTO listOnePublicationById(long id);

    public PublicationDTO updatePublication(PublicationDTO publicationDTO,long id);

    public void deletePublication(long id);
}
