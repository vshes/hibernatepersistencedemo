package com.shesh.db.dao;

import com.shesh.db.model.Student;
import java.util.List;

/**
 * Created by shesh on 5/23/17.
 */
public interface StudentDao {

     Student findOne(String id);
     List<Student> findAll();
     Student update(Student student);
     void delete(Student student);
     Student create(Student student);
}
