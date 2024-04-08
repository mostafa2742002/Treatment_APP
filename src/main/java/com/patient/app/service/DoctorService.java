package com.patient.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.app.model.Comment;
import com.patient.app.model.Doctor;
import com.patient.app.repo.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void createDoctor(Doctor doctor) {
        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");

        doctorRepository.save(doctor);
    }

    public void updateDoctor(Doctor doctor) {
        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");

        doctorRepository.save(doctor);
    }

    public void deleteDoctor(Doctor doctor) {
        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");

        doctorRepository.delete(doctor);
    }

    public void starDoctor(String doctorId, Integer star) {
        if (doctorId == null || star == null)
            throw new IllegalArgumentException("DoctorId or star cannot be null");

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        if (star == 1)
            doctor.setStar_1(doctor.getStar_1() + 1);
        else if (star == 2)
            doctor.setStar_2(doctor.getStar_2() + 1);
        else if (star == 3)
            doctor.setStar_3(doctor.getStar_3() + 1);
        else if (star == 4)
            doctor.setStar_4(doctor.getStar_4() + 1);
        else if (star == 5)
            doctor.setStar_5(doctor.getStar_5() + 1);
        else
            throw new IllegalArgumentException("Invalid star value");

        doctorRepository.save(doctor);
    }

    public void unstarDoctor(String doctorId, Integer star) {
        if (doctorId == null || star == null)
            throw new IllegalArgumentException("DoctorId or star cannot be null");

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        if (star == 1)
            doctor.setStar_1(doctor.getStar_1() - 1);
        else if (star == 2)
            doctor.setStar_2(doctor.getStar_2() - 1);
        else if (star == 3)
            doctor.setStar_3(doctor.getStar_3() - 1);
        else if (star == 4)
            doctor.setStar_4(doctor.getStar_4() - 1);
        else if (star == 5)
            doctor.setStar_5(doctor.getStar_5() - 1);
        else
            throw new IllegalArgumentException("Invalid star value");

        doctorRepository.save(doctor);
    }

    public void commentDoctor(String doctorId, Comment comment) {
        if (doctorId == null || comment == null)
            throw new IllegalArgumentException("DoctorId or comment cannot be null");

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        if (doctor.getComments() == null)
            doctor.setComments(new ArrayList<>());

        doctor.getComments().add(comment);
        doctorRepository.save(doctor);
    }

    public void addSessionDate(String doctorId, String date) {
        if (doctorId == null || date == null)
            throw new IllegalArgumentException("DoctorId or date cannot be null");

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        if (doctor.getSessions_dates() == null)
            doctor.setSessions_dates(new ArrayList<>());

        doctor.getSessions_dates().add(date);
        doctorRepository.save(doctor);
    }

    public void addSessionReq(String doctorId, Doctor.Session_req req) {
        if (doctorId == null || req == null)
            throw new IllegalArgumentException("DoctorId or req cannot be null");

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null)
            throw new IllegalArgumentException("Doctor not found");

        if (doctor.getSessions_reqests() == null)
            doctor.setSessions_reqests(new ArrayList<>());

        doctor.getSessions_reqests().add(req);
        doctorRepository.save(doctor);
    }

    
}
