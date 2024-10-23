package com.example.demo.DTO;

public class CourseInfoDTO {
    private Long courseId;
    private String courseName;
    private String teacherName;
    private int note;

    public CourseInfoDTO(Long courseId, String courseName, String teacherName, int note) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.note = note;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}