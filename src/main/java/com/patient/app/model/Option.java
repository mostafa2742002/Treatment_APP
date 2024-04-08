package com.patient.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "options")
public class Option {

    @Id
    private String id;

    private String title;
    private String description;
}
