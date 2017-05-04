package com.biz.web.controller;

import com.biz.po.Student;
import com.biz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    List<Student> studentList;

    @RequestMapping("/studentMain")
    public ModelAndView studentList(int cur_page) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        studentList = studentService.findOnePage(cur_page);
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("total_page", studentService.findTotalPage());
        modelAndView.addObject("cur_page", cur_page);
        modelAndView.setViewName("studentMain");
        return modelAndView;
    }

    @RequestMapping("/goAdd")
    public ModelAndView goAddView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(Student student) throws Exception {
        if(studentService.findStudent(student.getId())==null) {
            studentService.saveStudent(student);
            return studentList(1);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","学生已存在");
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping("/goUpdate")
    public ModelAndView goUpdateView(String id, int cur_page) throws ParseException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", studentService.findStudent(id));
        modelAndView.addObject("cur_page", cur_page);
        modelAndView.setViewName("updateStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ModelAndView updateStudent(Student student, int cur_page) throws Exception {
        studentService.updateStudent(student);
        return studentList(cur_page);
    }

    @RequestMapping("/deleteStudent")
    public ModelAndView deleteStudent(String id, int cur_page) throws Exception {
        studentService.deleteStudent(id);
        return studentList(cur_page);
    }
}
