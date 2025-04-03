package com.example.api_sem4.service;

import com.example.api_sem4.dto.ClassDTO;
import com.example.api_sem4.entity.Class;
import com.example.api_sem4.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> getAllClass() {
        return classRepository.findAll();
    }

    public Class saveClass(ClassDTO classDTO){
        Class aClass = new Class();
        aClass.setName(classDTO.getName());
        aClass.setGrade(classDTO.getGrade());
        return classRepository.save(aClass);
    }

    public Class updateClass(ClassDTO classDTO){
        Class aClass = saveClass(classDTO);
        return classRepository.save(aClass);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public Optional<Class> getClassById(Long id){
        return classRepository.findById(id);
    }
}
