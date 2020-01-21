package com.example.restservice.controller;

import com.example.restservice.Student;
import com.example.restservice.StudentRegistration;
import com.example.restservice.StudentRegistrationReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @RequestMapping(method = RequestMethod.POST, value="/student")
    @ResponseBody
    public StudentRegistrationReply registerStudent(@RequestBody Student student) {
        System.out.println("In registerStudent");
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();

        StudentRegistration.getInstance().add(student);
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setStuID(student.getStuID());
        stdregreply.setRegistrationStatus("Successful");
        return stdregreply;
    }

    @RequestMapping(method = RequestMethod.GET, value="/student")
    @ResponseBody
    public List<Student> getAllStudents() {
        return StudentRegistration.getInstance().getStudentRecords();
    }


    @RequestMapping(method = RequestMethod.PUT, value="/student")
    @ResponseBody
    public String updateStudentRecord(@RequestBody Student stdn) {
        System.out.println("In updateStudentRecord");
        return StudentRegistration.getInstance().upDateStudent(stdn);
    }


    @RequestMapping(method = RequestMethod.DELETE, value="/student/{stuID}")
    @ResponseBody
    public String deleteStudentRecord(@PathVariable("stuID") String stuID) {
        System.out.println("In deleteStudentRecord");
        return StudentRegistration.getInstance().deleteStudent(stuID);
    }
}
