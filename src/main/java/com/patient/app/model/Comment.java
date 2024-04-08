package com.patient.app.model;

import lombok.Data;

@Data
public class Comment {

    private String username;
    private String comment;
    private String date;
    private Integer likes = 0;
}
