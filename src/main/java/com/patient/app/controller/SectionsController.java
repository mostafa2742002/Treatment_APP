package com.patient.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.patient.app.model.Option;
import com.patient.app.model.Section;
import com.patient.app.model.SubSection;
import com.patient.app.service.SectionsService;

import jakarta.validation.constraints.NotNull;

@RestController
public class SectionsController {

    @Autowired
    public SectionsService sectionsService;


    @PostMapping("/section")
    public ResponseEntity<String> createSection(@RequestBody @NotNull Section section) {
        sectionsService.createSection(section);
        return ResponseEntity.status(201).body("Section created");
    }

    @PostMapping("/section/subsection")
    public ResponseEntity<String> createSubSection(@RequestBody @NotNull SubSection section, @RequestParam @NotNull String sectionId) {
        
        sectionsService.createSubSection(section, sectionId);
        return ResponseEntity.status(201).body("SubSection created");
    }

    @PostMapping("/option")
    public ResponseEntity<String> createOption(@RequestBody @NotNull Option option) {
        sectionsService.createOption(option);
        return ResponseEntity.status(201).body("Option created");
    }

    @PostMapping("/section/subsection/option")
    public ResponseEntity<String> addOption(@RequestBody @NotNull JsonNode option_array , @RequestParam @NotNull String subSectionId) {
        List<String> options = option_array.findValuesAsText("options");
        sectionsService.addOption(options, subSectionId);
        return ResponseEntity.status(201).body("Option created");
    }
}
