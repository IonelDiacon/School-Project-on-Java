package com.example.demo.repository;

import com.example.demo.models.Course;
import com.example.demo.models.Note;
import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {
    boolean existsByStudentAndCourse(Student student, Course course);

    List<Note> findByStudent(Student student);
}
