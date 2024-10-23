package com.example.demo.service;

import com.example.demo.DTO.CourseInfoDTO;
import com.example.demo.DTO.StudentDetailsDTO;
import com.example.demo.models.Course;
import com.example.demo.models.Note;
import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final NoteRepository noteRepository;

    // Constructor injection
    public SchoolService(StudentRepository studentRepository, TeacherRepository teacherRepository,
                         CourseRepository courseRepository, NoteRepository noteRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.noteRepository = noteRepository;
    }

    public StudentDetailsDTO getStudentDetails(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<CourseInfoDTO> courseInfoList = noteRepository.findByStudent(student).stream()
                .map(note -> new CourseInfoDTO(
                        note.getCourse().getId(),
                        note.getCourse().getName(),
                        note.getCourse().getTeacher().getName(),
                        note.getGrade()
                )).collect(Collectors.toList());

        StudentDetailsDTO studentDetails = new StudentDetailsDTO();
        studentDetails.setStudentId(student.getId());
        studentDetails.setStudentName(student.getName());
        studentDetails.setCourses(courseInfoList);

        return studentDetails;
    }

    // POST Methods

    @Transactional
    public Student addStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    @Transactional
    public Teacher addTeacher(String name) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        return teacherRepository.save(teacher);
    }

    @Transactional
    public Course addCourse(String name, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        Course course = new Course();
        course.setName(name);
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @Transactional
    public Note addNoteForStudent(Long studentId, Long courseId, int grade) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (noteRepository.existsByStudentAndCourse(student, course)) {
            throw new RuntimeException("Student already has a note for this course");
        }

        Note note = new Note();
        note.setStudent(student);
        note.setCourse(course);
        note.setGrade(grade);
        return noteRepository.save(note);
    }

    // GET Methods

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
    ///perfect

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
