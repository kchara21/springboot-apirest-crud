package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.PublicationDTO;
import com.example.springbootapirest.dto.PublicationResponse;

public interface PublicationService {

    // Creacion de una publicacion, recibe como parametro las propiedades de la entidad "publicacion"
    public PublicationDTO createPublication(PublicationDTO publicationDTO);

    // Lista todas las publicaciones segun la paginacion recibida como parametros
    // Recibe como parametros el numero de de pagina, el tamanio, el tipo de filtro y si requiere ascendente o descendente.
    public PublicationResponse listAllPublications(int pageNumber, int pageSize, String sortBy, String sortDir);

    // Lista una publicacion por id
    public PublicationDTO listOnePublicationById(long id);

    // Actualiza una publicacion, recibe el id y el cuerpo de la entidad como parametros.
    public PublicationDTO updatePublication(PublicationDTO publicationDTO,long id);

    // Elimina una publicacion, recibe como parametro su id.
    public void deletePublication(long id);
}
