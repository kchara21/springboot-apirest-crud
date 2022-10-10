package com.example.springbootapirest.repository;

import com.example.springbootapirest.entities.Coment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentRepository extends JpaRepository<Coment,Long> {

    public List<Coment> findByPublicationId(long publicationId);
}
