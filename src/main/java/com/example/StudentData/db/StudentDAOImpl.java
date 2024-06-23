package com.example.StudentData.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    EntityManager em;

    @Autowired
    StudentDAOImpl(EntityManager em){
        this.em = em;
    }


    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> res = em.createQuery("FROM Student",Student.class);
        return res.getResultList();
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        Student theStudent = em.find(Student.class,id);
        em.remove(theStudent);

    }

    @Transactional
    @Override
    public Student updateStudent(Student theStudent) {
        Student newStudent = em.merge(theStudent);
        return newStudent;
    }

    @Override
    public Student findStudentbyId(int id) {
        Student theStudent = em.find(Student.class,id);
        return theStudent;
    }


}
