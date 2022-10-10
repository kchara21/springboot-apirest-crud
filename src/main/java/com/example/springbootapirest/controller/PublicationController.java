package com.example.springbootapirest.controller;

import com.example.springbootapirest.dto.PublicationDTO;
import com.example.springbootapirest.dto.PublicationResponse;
import com.example.springbootapirest.service.PublicationService;
import com.example.springbootapirest.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping
    public PublicationResponse listPublications(@RequestParam(value = "pageNumber",defaultValue = AppConstants.DEFAULT_NUMBER_PAGE,required = false) int pageNumber,
                                                @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_SIZE_PAGE,required = false) int pageSize,
                                                @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
                                                @RequestParam(value = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIR,required = false) String sortDir){

        return publicationService.listAllPublications(pageNumber,pageSize,sortBy,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> listOnePublicationById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(publicationService.listOnePublicationById(id));
    }


    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@Valid @RequestBody PublicationDTO publicationDTO){
        return new ResponseEntity<>(publicationService.createPublication(publicationDTO), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublication(@Valid @RequestBody PublicationDTO publicationDTO,@PathVariable(name = "id") long id){
        PublicationDTO publicationResponse = publicationService.updatePublication(publicationDTO,id);
        return new ResponseEntity<>(publicationResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id){
        publicationService.deletePublication(id);

        return new ResponseEntity<>("Publication deleted successfully",HttpStatus.OK);

    }


}
