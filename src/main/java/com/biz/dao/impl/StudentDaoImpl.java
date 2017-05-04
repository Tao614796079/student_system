package com.biz.dao.impl;

import com.biz.dao.StudentDao;
import com.biz.po.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
@Repository("studentDao")
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int saveStudent(Student student) {
        return getSqlSession().insert("com.zt.vo.student.mapper.saveStudent", student);
    }

    public List<Student> findOnePage(int start) {
        return getSqlSession().selectList("com.zt.vo.student.mapper.findOnePage", start);
    }

    public int getStudentAmont() {
        return getSqlSession().selectOne("com.zt.vo.student.mapper.findStudentAmont");
    }

    public Student getStudentById(String id) {
        return getSqlSession().selectOne("com.zt.vo.student.mapper.findStudentById", id);
    }

    public int deleteStudentById(String id) {
        return getSqlSession().delete("com.zt.vo.student.mapper.deleteStudentById", id);
    }

    public int updateStudent(Student student) {
        return getSqlSession().update("com.zt.vo.student.mapper.updateStudent", student);
    }
}
