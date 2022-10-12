package com.example.springbootapirest.controller;


import com.example.springbootapirest.dto.ComentDTO;
import com.example.springbootapirest.service.ComentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


// Controlador para la gestion de Comentarios
@RestController()
@RequestMapping("/api/")
public class ComentController {

    // Inyeccion del servicio comentService,
    @Autowired
    private ComentService comentService;

    @GetMapping("/publications/{publicationId}/coments")
    public List<ComentDTO> listComentsByPublicationId(@PathVariable(value = "publicationId") Long publicationId) {
        return comentService.listAllComentsByPublicationId(publicationId);
    }

    @GetMapping("/publications/{publicationId}/coments/{id}")
    public ResponseEntity<ComentDTO> listComentById(@PathVariable(value = "publicationId") Long publicationId,
                                                    @PathVariable(value = "id") Long comentId) {
        ComentDTO comentDTO = comentService.listComentById(publicationId, comentId);
        return new ResponseEntity<>(comentDTO, HttpStatus.OK);
    }


    @PostMapping("/publications/{publicationId}/coments")
    public ResponseEntity<ComentDTO> saveComent(@PathVariable(value = "publicationId") long publicationId,
                                                @Valid @RequestBody ComentDTO comentDTO) {
        return new ResponseEntity<>(comentService.createComent(publicationId, comentDTO), HttpStatus.OK);
    }

    @PutMapping("/publications/{publicationId}/coments/{id}")
    public ResponseEntity<ComentDTO> updateComent(@PathVariable(value = "publicationId") Long publicationId,
                                                  @PathVariable(value = "id") Long comentId,
                                                  @Valid @RequestBody ComentDTO comentDTO) {
        ComentDTO comentUpdated = comentService.updateComent(publicationId, comentId, comentDTO);
        return new ResponseEntity<>(comentUpdated, HttpStatus.OK);

    }

    @DeleteMapping("/publications/{publicationId}/coments/{id}")
    public ResponseEntity<String> deleteComent(@PathVariable(value = "publicationId") Long publicationId,
                                               @PathVariable(value = "id") Long comentId) {
        comentService.deleteComent(publicationId, comentId);
        return new ResponseEntity<>("Coment deleted successfully", HttpStatus.OK);
    }

}
