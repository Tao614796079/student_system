package com.biz.dao;

import com.biz.po.Student;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface StudentDao {
    List<Student> findOnePage(int start);

    int saveStudent(Student student);

    int getStudentAmont();

    Student getStudentById(String id);

    int deleteStudentById(String id);

    int updateStudent(Student student);
}
