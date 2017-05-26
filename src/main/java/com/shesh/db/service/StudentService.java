package com.shesh.db.service;

import com.shesh.db.model.Student;

import java.util.List;

/**
 * Created by shesh on 5/23/17.
 */
public interface StudentService {

    Student findOne(String id);
    List<Student> findAll();
    Student update(Student student);
    void delete(Student id);
    Student create(Student student);
}
