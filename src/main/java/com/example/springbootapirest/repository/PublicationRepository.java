package com.example.springbootapirest.repository;

import com.example.springbootapirest.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication,Long> {

}
