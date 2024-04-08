package com.patient.app.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "sections")
public class Section {

    @Id
    String id;

    String title;
    ArrayList<String> subSectionsId;
}
