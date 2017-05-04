package com.biz.service;

import com.biz.po.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface StudentService {
    List<Student> findOnePage(int curPage);
    int saveStudent(Student student);
    int findTotalPage();
    Student findStudent(String id);
    int deleteStudent(String id);
    int updateStudent(Student student);
}
