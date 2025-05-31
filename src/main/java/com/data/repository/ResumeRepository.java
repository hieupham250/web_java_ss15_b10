package com.data.repository;

import com.data.model.Resume;

import java.util.List;

public interface ResumeRepository {
    List<Resume> findAll();
    Resume findById(long id);
    boolean create(Resume resume);
    boolean update(Resume resume);
    boolean delete(long id);
}
