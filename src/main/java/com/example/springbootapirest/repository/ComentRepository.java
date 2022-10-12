package com.example.springbootapirest.repository;

import com.example.springbootapirest.entities.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// Creacion del repositorio para la entidad "Comentario", usando JPA para el facil manejo de datos relacionales.
public interface ComentRepository extends JpaRepository<Coment,Long> {

    // Metodo creado para la busqueda de una publicacion por id
    public List<Coment> findByPublicationId(long publicationId);
}
