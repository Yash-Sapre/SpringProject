package com.example.StudentData.db;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    void deleteStudent(int id);
    Student updateStudent(Student theStudent);
    Student findStudentbyId(int id);
}
