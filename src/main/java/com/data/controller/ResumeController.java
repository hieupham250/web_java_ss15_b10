package com.data.controller;

import com.data.dto.ResumeDTO;
import com.data.model.Resume;
import com.data.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public String resume(Model model) {
        List<Resume> resumes = resumeService.findAll();
        model.addAttribute("resumes", resumes);
        return "resumeList";
    }

    @GetMapping("/add")
    public String addResume(Model model) {
        model.addAttribute("resumeDTO", new ResumeDTO());
        return "addResume";
    }

    @PostMapping("/add")
    public String addResume(@Valid @ModelAttribute ResumeDTO resumeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addResume";
        }

        Resume resume = new Resume();
        resume.setFullName(resumeDTO.getFullName());
        resume.setEmail(resumeDTO.getEmail());
        resume.setPhoneNumber(resumeDTO.getPhoneNumber());
        resume.setEducation(resumeDTO.getEducation());
        resume.setExperience(resumeDTO.getExperience());
        resume.setSkills(resumeDTO.getSkills());
        resumeService.create(resume);
        return "redirect:/resume";
    }

    @GetMapping("/edit/{id}")
    public String editResume( Model model, @PathVariable long id) {
        Resume resume = resumeService.findById(id);
        ResumeDTO resumeDTO = new ResumeDTO();

        resumeDTO.setId(resume.getId());
        resumeDTO.setFullName(resume.getFullName());
        resumeDTO.setEmail(resume.getEmail());
        resumeDTO.setPhoneNumber(resume.getPhoneNumber());
        resumeDTO.setEducation(resume.getEducation());
        resumeDTO.setExperience(resume.getExperience());
        resumeDTO.setSkills(resume.getSkills());

        model.addAttribute("resumeDTO", resumeDTO);
        return "editResume";
    }

    @PostMapping("/edit")
    public String editResume(@Valid @ModelAttribute ResumeDTO resumeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editResume";
        }

        Resume resume = new Resume();
        resume.setId(resumeDTO.getId());
        resume.setFullName(resumeDTO.getFullName());
        resume.setEmail(resumeDTO.getEmail());
        resume.setPhoneNumber(resumeDTO.getPhoneNumber());
        resume.setEducation(resumeDTO.getEducation());
        resume.setExperience(resumeDTO.getExperience());
        resume.setSkills(resumeDTO.getSkills());

        System.out.println("id chỉnh sửa " + resume.getId());

        resumeService.update(resume);

        return "redirect:/resume";
    }

    @GetMapping("/delete/{id}")
    public String deleteResume(@PathVariable long id) {
        boolean success = resumeService.delete(id);
        return "redirect:/resume";
    }
}
