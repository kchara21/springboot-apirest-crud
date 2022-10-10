package com.example.springbootapirest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ComentDTO {
    private long id;

    @NotEmpty(message = "Name must not be null")
    private String name;

    @NotEmpty(message = "The email must be not null")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10,message = "The body must have equal or more than 10 characteres...")
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ComentDTO() {
        super();
    }
}
