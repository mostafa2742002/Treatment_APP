package com.patient.app.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "doctors")
public class Doctor {

    @Id
    private String id;

    private String name;
    private String description;
    private String speciality;
    private String experience;
    private String email;
    private String language;
    private String phone;
    private ArrayList<Option> Subspecialties;
    private Integer star_1;
    private Integer star_2;
    private Integer star_3;
    private Integer star_4;
    private Integer star_5;
    private ArrayList<Comment> comments;
    private ArrayList<String> sessions_dates;
    private ArrayList<Session_req> sessions_reqests;

    public record Session_req(String date, String time, String patient_id, String patient_note) {
    }
}
