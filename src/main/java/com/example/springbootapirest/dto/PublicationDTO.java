package com.example.springbootapirest.dto;

import com.example.springbootapirest.entities.Coment;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class PublicationDTO {
    private Long id;
    private String content;

    @NotEmpty
    @Size(min = 2,message = "The publication description must be 2 characters ")
    private String description;

    @NotEmpty
    @Size(min = 2,message = "The publication title must be 2 characters ")
    private String title;


    private Set<Coment> coments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Coment> getComents() {
        return coments;
    }

    public void setComents(Set<Coment> coments) {
        this.coments = coments;
    }

    public PublicationDTO(){
        super();
    }

    public PublicationDTO(Long id, String content, String description, String title) {
        this.id = id;
        this.content = content;
        this.description = description;
        this.title = title;
    }
}
