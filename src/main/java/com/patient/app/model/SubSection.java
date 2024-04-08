package com.patient.app.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "subsections")
public class SubSection {

    @Id
    private String id;

    private String title;
    private String description;
    private String section_id;
    private ArrayList<Option> options;

}
