package com.example.springbootapirest.service;

import com.example.springbootapirest.dto.ComentDTO;

import java.util.List;


// Interfaz del servicio de la entidad "comentario"
public interface ComentService {

    // Creacion de un comentario, recibe como parametros el id de la publicacion a la que pertenece, asi como las propiedades de la entidad "comentario".
    public ComentDTO createComent(long publicationId, ComentDTO comentDTO);

    // Lista todos los comentarios de una publicacion, reciba como parametro el id de la publicacion.
    public List<ComentDTO> listAllComentsByPublicationId(long publicationId);

    // Lista un comentario de una publicacion, reciba como parametros el id de la publicacion, y el id del comentario
    public ComentDTO listComentById(Long publicationId,Long comentId);

    // Actualiza los comentarios de una publicacion, recibe como parametros el id de la publicacion, el id del comentario, y el cuerpo del comentario.
    public ComentDTO updateComent(Long publicationId,Long comentId, ComentDTO comentRequest);

    // Elimina un comentario, recibe como parametro el id de la publicacion, y del comentario.
    public void deleteComent(Long publicationId, Long comentId );

}
