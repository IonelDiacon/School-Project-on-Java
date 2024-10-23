package com.example.demo.DTO;

import java.util.List;

public class StudentDetailsDTO {
    private Long studentId;
    private String studentName;
    private List<CourseInfoDTO> courses;

    // Constructori, Getteri și Setteri

    public StudentDetailsDTO(Long studentId, String studentName, List<CourseInfoDTO> courses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public StudentDetailsDTO() {

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseInfoDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseInfoDTO> courses) {
        this.courses = courses;
    }
}