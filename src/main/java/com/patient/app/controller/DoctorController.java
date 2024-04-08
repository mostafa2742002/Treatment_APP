package com.patient.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.patient.app.model.Comment;
import com.patient.app.model.Doctor;
import com.patient.app.model.Doctor.Session_req;
import com.patient.app.service.DoctorService;

import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DoctorController {

    @Autowired
    public DoctorService doctorService;

    @PostMapping("/doctor")
    public ResponseEntity<String> createDoctor(@RequestBody @NotNull Doctor doctor) {

        doctorService.createDoctor(doctor);
        return ResponseEntity.status(201).body("Doctor created");

    }

    @PutMapping("/doctor")
    public ResponseEntity<String> updateDoctor(@RequestBody @NotNull Doctor doctor) {

        doctorService.updateDoctor(doctor);
        return ResponseEntity.status(200).body("Doctor updated");

    }

    @DeleteMapping("/doctor")
    public ResponseEntity<String> deleteDoctor(@RequestBody @NotNull Doctor doctor) {

        doctorService.deleteDoctor(doctor);
        return ResponseEntity.status(200).body("Doctor deleted");

    }

    @PostMapping("/doctor/star")
    public ResponseEntity<String> starDoctor(@RequestParam @NotNull String doctorId, @RequestParam @NotNull Integer star) {

        doctorService.starDoctor(doctorId, star);
        return ResponseEntity.status(200).body("Doctor starred");

    }

    @PostMapping("/doctor/unstar")
    public ResponseEntity<String> unstarDoctor(@RequestParam @NotNull String doctorId, @RequestParam @NotNull Integer star) {

        doctorService.unstarDoctor(doctorId, star);
        return ResponseEntity.status(200).body("Doctor unstarred");

    }

    @PostMapping("/doctor/comment")
    public ResponseEntity<String> commentDoctor(@RequestParam @NotNull String doctorId, @RequestParam @NotNull Comment comment) {

        doctorService.commentDoctor(doctorId, comment);
        return ResponseEntity.status(200).body("Doctor commented");

    }

    @PostMapping("/doctor/session-date")
    public ResponseEntity<String> addSessionDate(@RequestParam @NotNull String doctorId, @RequestParam @NotNull String date) {

        doctorService.addSessionDate(doctorId, date);
        return ResponseEntity.status(200).body("Session date added");

    }

    @PostMapping("/doctor/session-req")
    public ResponseEntity<String> addSessionReq(@RequestParam @NotNull String doctorId, @RequestParam @NotNull Session_req req) {

        doctorService.addSessionReq(doctorId, req);
        return ResponseEntity.status(200).body("Session req added");

    }
}
