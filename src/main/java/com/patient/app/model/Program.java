package com.patient.app.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Program {

    @Id
    private String id;

    private String title;
    private String description;
    private String type;
    private String duration;
    private Video demo_video;
    private String price;
    private String enroll;
    private ArrayList<Step> steps_of_videos; // like [[video1, video2], [video3, video4]] mean step 1 has video1 and video2, step 2 has video3 and video4
    private ArrayList<String> doctors_id;
    private ArrayList<Article> articles;


    public record Article(String title, String description){}
    @Data
    public class Step {
        private ArrayList<Video> videos;
        private String title;
        private String description;
    }
}
