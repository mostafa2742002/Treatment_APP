package com.patient.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.app.model.Option;
import com.patient.app.model.Section;
import com.patient.app.model.SubSection;
import com.patient.app.repo.OptionRepository;
import com.patient.app.repo.SectionRepository;
import com.patient.app.repo.SubSectionRepository;

@Service
public class SectionsService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SubSectionRepository subSectionRepository;

    @Autowired
    private OptionRepository optionRepository;

    public void createSection(Section section) {
        if (section == null)
            throw new IllegalArgumentException("Section cannot be null");

        sectionRepository.save(section);
    }

    public void createSubSection(SubSection subsection, String sectionId) {
        if (subsection == null)
            throw new IllegalArgumentException("SubSection cannot be null");

        Section sectionObj = sectionRepository.findById(sectionId).orElse(null);
        if (sectionObj == null)
            throw new IllegalArgumentException("Section not found");

        subsection.setSection_id(sectionId);
        String subSectionId = subSectionRepository.save(subsection).getId();
        sectionObj.getSubSectionsId().add(subSectionId);

        sectionRepository.save(sectionObj);
    }

    public void createOption(Option option) {
        if (option == null)
            throw new IllegalArgumentException("Option cannot be null");

        optionRepository.save(option);
    }

    public void addOption(List<String> options_id, String subSectionId) {
        if (options_id == null)
            throw new IllegalArgumentException("Option cannot be null");

        SubSection subSectionObj = subSectionRepository.findById(subSectionId).orElse(null);
        if (subSectionObj == null)
            throw new IllegalArgumentException("SubSection not found");

        for (Object option_id : options_id) {
            Option optionObj = optionRepository.findById(option_id.toString()).orElse(null);
            if (optionObj == null)
                throw new IllegalArgumentException("Option not found");

            subSectionObj.getOptions().add(optionObj);
        }

        subSectionRepository.save(subSectionObj);
    }

}
