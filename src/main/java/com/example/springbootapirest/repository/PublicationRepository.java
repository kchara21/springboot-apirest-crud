package com.example.springbootapirest.repository;

import com.example.springbootapirest.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

// Creacion del repositorio para la entidad "Publicacion", usando JPA para el facil manejo de datos relacionales.
public interface PublicationRepository extends JpaRepository<Publication,Long> {

}
