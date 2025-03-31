package com.example.api_sem4.controller;

import com.example.api_sem4.dto.ClassDTO;
import com.example.api_sem4.entity.Class;
import com.example.api_sem4.service.ClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping("/")
    public List<Class> getAllClasses(){
        return classService.getAllClass();
    }

    @PostMapping("/add")
    public ResponseEntity<Class> addClass(@RequestBody ClassDTO classDTO) {
        Class savedClass = classService.saveClass(classDTO);
        return ResponseEntity.ok(savedClass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        Optional<Class> existingClass = classService.getClassById(id);
        if (existingClass.isPresent()) {
            classDTO.setId(id);  // Set the ID of the class to update
            Class updatedClass = classService.saveClass(classDTO);
            return ResponseEntity.ok(updatedClass);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete class by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        Optional<Class> existingClass = classService.getClassById(id);
        if (existingClass.isPresent()) {
            classService.deleteClass(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
