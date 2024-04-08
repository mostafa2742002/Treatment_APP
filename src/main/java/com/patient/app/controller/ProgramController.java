package com.patient.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.app.model.Program;
import com.patient.app.model.Video;
import com.patient.app.model.Program.Article;
import com.patient.app.model.Program.Step;
import com.patient.app.service.ProgramService;

import jakarta.validation.constraints.NotNull;

@RestController
public class ProgramController {

    @Autowired
    public ProgramService programService;

    @PostMapping("/program")
    public ResponseEntity<String> createProgram(@RequestBody @NotNull Program program) {
        programService.createProgram(program);
        return ResponseEntity.status(201).body("Program created");
    }

    @PutMapping("/program")
    public ResponseEntity<String> updateProgram(@RequestBody @NotNull Program program) {
        programService.updateProgram(program);
        return ResponseEntity.status(200).body("Program updated");
    }

    @DeleteMapping("/program")
    public ResponseEntity<String> deleteProgram(@RequestBody @NotNull Program program) {
        programService.deleteProgram(program);
        return ResponseEntity.status(200).body("Program deleted");
    }

    @PostMapping("/program/step")
    public ResponseEntity<String> addStep(@RequestBody @NotNull String programId, @RequestBody @NotNull Step step) {
        programService.addStep(programId, step);
        return ResponseEntity.status(201).body("Step added");
    }

    @PostMapping("/program/step/video")
    public ResponseEntity<String> addVideo(@RequestBody @NotNull String programId, @RequestBody @NotNull String stepTitle, @RequestBody @NotNull Video video) {
        programService.addVideo(programId, stepTitle, video);
        return ResponseEntity.status(201).body("Video added");
    }

    @PostMapping("/program/doctor")
    public ResponseEntity<String> addDoctor(@RequestBody @NotNull String programId, @RequestBody @NotNull String doctorId) {
        programService.addDoctor(programId, doctorId);
        return ResponseEntity.status(201).body("Doctor added");
    }

    @PostMapping("/program/article")
    public ResponseEntity<String> addArticle(@RequestBody @NotNull String programId, @RequestBody @NotNull Article article) {
        programService.addArticle(programId, article);
        return ResponseEntity.status(201).body("Article added");
    }
}
