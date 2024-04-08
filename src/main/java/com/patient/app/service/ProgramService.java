package com.patient.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.app.model.Program;
import com.patient.app.model.Video;
import com.patient.app.repo.ProgramRepository;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public void createProgram(Program program) {
        if (program == null)
            throw new IllegalArgumentException("Program cannot be null");

        programRepository.save(program);
    }

    public void updateProgram(Program program) {
        if (program == null)
            throw new IllegalArgumentException("Program cannot be null");

        programRepository.save(program);
    }

    public void deleteProgram(Program program) {
        if (program == null)
            throw new IllegalArgumentException("Program cannot be null");

        programRepository.delete(program);
    }

    public void addStep(String programId, Program.Step step) {
        if (programId == null || step == null)
            throw new IllegalArgumentException("ProgramId or step cannot be null");

        Program program = programRepository.findById(programId).orElse(null);
        if (program == null)
            throw new IllegalArgumentException("Program not found");

        if (program.getSteps_of_videos() == null)
            program.setSteps_of_videos(new ArrayList<>());

        program.getSteps_of_videos().add(step);
        programRepository.save(program);
    }

    public void addVideo(String programId, String stepTitle, Video video) {
        if (programId == null || stepTitle == null || video == null)
            throw new IllegalArgumentException("ProgramId, stepTitle or video cannot be null");

        Program program = programRepository.findById(programId).orElse(null);
        if (program == null)
            throw new IllegalArgumentException("Program not found");

        if (program.getSteps_of_videos() == null)
            throw new IllegalArgumentException("Program has no steps");

        for (Program.Step step : program.getSteps_of_videos()) {
            if (step.getTitle().equals(stepTitle)) {
                if (step.getVideos() == null)
                    step.setVideos(new ArrayList<>());

                step.getVideos().add(video);
                programRepository.save(program);
                return;
            }
        }

        throw new IllegalArgumentException("Step not found");

    }

    public void addDoctor(String programId, String doctorId) {
        if (programId == null || doctorId == null)
            throw new IllegalArgumentException("ProgramId or doctorId cannot be null");

        Program program = programRepository.findById(programId).orElse(null);
        if (program == null)
            throw new IllegalArgumentException("Program not found");

        if (program.getDoctors_id() == null)
            program.setDoctors_id(new ArrayList<>());

        program.getDoctors_id().add(doctorId);
        programRepository.save(program);
    }

    public void addArticle(String programId, Program.Article article) {
        if (programId == null || article == null)
            throw new IllegalArgumentException("ProgramId or article cannot be null");

        Program program = programRepository.findById(programId).orElse(null);
        if (program == null)
            throw new IllegalArgumentException("Program not found");

        if (program.getArticles() == null)
            program.setArticles(new ArrayList<>());

        program.getArticles().add(article);
        programRepository.save(program);
    }

    
}
