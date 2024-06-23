package com.example.StudentData.Controller;


import com.example.StudentData.db.Student;
import com.example.StudentData.db.StudentDAO;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Webapp {
    private StudentDAO s;


    public Webapp(StudentDAO s){
        this.s = s;
    }

    @GetMapping("/")
    public String showStudents(Model m){
        List<Student> studentList = s.getAllStudents();
        m.addAttribute("studentList",studentList);
        return "indexPage";
    }

    @PostMapping("/delete")
    public String removeStudent(HttpServletRequest req){
        s.deleteStudent(Integer.parseInt(req.getParameter("id")));
        return "updatedPage";
    }

    @GetMapping("/insert")
    public String insertStudentsPage(Model m){
        List<Student> studentList = s.getAllStudents();
        m.addAttribute("studentList",studentList);
        return "insertStudent";
    }

    @PostMapping("/insert")
    public String insertStudents(HttpServletRequest req, Model m){
        Student temp = new Student();
        temp.setId(Integer.parseInt(req.getParameter("id")));
        temp.setFirstName(req.getParameter("firstName"));
        temp.setLastName(req.getParameter("lastName"));
        temp.setTotalPercentage(Integer.parseInt(req.getParameter("totalPercentage")));
        s.updateStudent(temp);
        return "updatedPage";
    }

    @PostMapping("/updateForm")
    public String updateStudentsForm(HttpServletRequest req, Model m){
        Student temp = s.findStudentbyId(Integer.parseInt(req.getParameter("id")));
        m.addAttribute("id",Integer.toString(temp.getId()));

        m.addAttribute("firstName",temp.getFirstName());
        m.addAttribute("lastName",temp.getLastName());
        m.addAttribute("totalPercentage",Integer.toString(temp.getTotalPercentage()));

        return "updatePage";
    }
    @PostMapping("/update")
    public String updateStudents(HttpServletRequest req, Model m){
        Student temp = new Student();
        temp.setId(Integer.parseInt(req.getParameter("id")));
        temp.setFirstName(req.getParameter("firstName"));
        temp.setLastName(req.getParameter("lastName"));
        temp.setTotalPercentage(Integer.parseInt(req.getParameter("totalPercentage")));
        s.updateStudent(temp);
        return "updatedPage";
    }

}
