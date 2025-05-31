package com.data.service;

import com.data.model.Resume;
import com.data.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImp implements ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume findById(long id) {
        return resumeRepository.findById(id);
    }

    @Override
    public boolean create(Resume resume) {
        return resumeRepository.create(resume);
    }

    @Override
    public boolean update(Resume resume) {
        return resumeRepository.update(resume);
    }

    @Override
    public boolean delete(long id) {
        return resumeRepository.delete(id);
    }
}
