package com.biz.service.impl;

import com.biz.dao.StudentDao;
import com.biz.po.Student;
import com.biz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentDao;

    public List<Student> findOnePage(int curPage) {
        return studentDao.findOnePage((curPage - 1) * 10);
    }

    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    public int findTotalPage() {
        int totalPage = studentDao.getStudentAmont()/10;
        if(studentDao.getStudentAmont()%10 !=0) {
            totalPage++;
        }
        return totalPage;
    }

    public Student findStudent(String id) {
        return studentDao.getStudentById(id);
    }

    public int deleteStudent(String id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
