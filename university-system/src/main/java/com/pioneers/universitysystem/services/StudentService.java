package com.pioneers.universitysystem.services;

import com.pioneers.universitysystem.models.dtos.requests.StudentRequest;
import com.pioneers.universitysystem.models.entities.Student;
import com.pioneers.universitysystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student registerStudent(StudentRequest st){
        boolean isPassed = st.getGrade() >= 50;

        Student student = new Student(
                st.getId(), st.getName(), st.getGrade(), st.getEmail()
        );
        student.setPassed(isPassed);
        studentRepository.save(student);
        return student;
    }

    public List<Student> registerMultipleStudents (List<StudentRequest> studentRequests){
        List<Student> students = studentRequests.stream()
                .map(st -> {
                    boolean isPassed = st.getGrade() >= 50;
                    Student student = new Student(
                            st.getId(), st.getName(), st.getGrade(), st.getEmail()
                    );
                    student.setPassed(isPassed);
                    return student;
                })
                .toList();

        studentRepository.saveAll(students);
        return students;
    }

    public Student getStudentById (int id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Student with id : " + id + " is not found"));
    }

    public boolean deleteStudentByID(int id) {
        return studentRepository.deleteStudent(id);
    }

    public Student getTopStudent() {
        Student topStudent = studentRepository.getAllStudents().stream()
                .max(Comparator.comparing(Student::getGrade))
                .orElseThrow(() -> new RuntimeException("No students found in the repository"));

        return topStudent;
    }

    public List<Student> getPassedStudents() {
        List<Student> passedStudnets = studentRepository.getAllStudents().stream()
                .filter(student -> student.isPassed())
                .toList();
        return passedStudnets;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }



}
