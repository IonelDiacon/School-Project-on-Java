package com.example.demo.controller;

import com.example.demo.DTO.StudentDetailsDTO;
import com.example.demo.models.Course;
import com.example.demo.models.Note;
import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {


    @Autowired
    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }



    // Obține detalii despre un student specific, inclusiv cursuri, profesori și note
    @GetMapping("/{id}/details")
    public StudentDetailsDTO getStudentDetails(@PathVariable Long id) {
        return schoolService.getStudentDetails(id);
    }
    ////////////////PREFECT

    // POST Methods
    @PostMapping("/student")
    public Student addStudent(@RequestParam String name) {
        return schoolService.addStudent(name);
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestParam String name) {
        return schoolService.addTeacher(name);
    }

    @PostMapping("/course")
    public Course addCourse(@RequestParam String name, @RequestParam Long teacherId) {
        return schoolService.addCourse(name, teacherId);
    }

    @PostMapping("/note")
    public Note addNote(@RequestParam Long studentId, @RequestParam Long courseId, @RequestParam int grade) {
        return schoolService.addNoteForStudent(studentId, courseId, grade);
    }

    // GET Method - Return all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }
    ////PERFECT

    // GET Method - Return all teachers
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return schoolService.getAllTeachers();
    }

    // GET Method - Return all courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return schoolService.getAllCourses();
    }

    // GET Method - Return all notes
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return schoolService.getAllNotes();
    }

    // GET Method - Get student by id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return schoolService.getStudentById(id);
    }

    // GET Method - Get teacher by id
    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return schoolService.getTeacherById(id);
    }

    // GET Method - Get course by id
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return schoolService.getCourseById(id);
    }

    // GET Method - Get note by id
    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return schoolService.getNoteById(id);
    }
}
