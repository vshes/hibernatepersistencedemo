package com.shesh.db.dao;

import com.shesh.db.model.Student;
import com.shesh.db.utils.DbUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shesh on 5/26/17.
 */
public class StudentDaoSessionFactoryImpl implements  StudentDao{


    private SessionFactory sessionFactory;
    public StudentDaoSessionFactoryImpl() throws Exception {
        Configuration cfg = new Configuration();
        cfg.addProperties(DbUtil.getProp("sf.properties"));
       cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        this.sessionFactory = cfg.buildSessionFactory();
        System.out.println("Hibernate Configured Using Session !");

    }

    public Student findOne(String id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student where id = :id");
        query.setParameter("id",id);
        Student student = (Student) query.list().get(0);
        return student;

    }

    public List<Student> findAll() {
        return sessionFactory.openSession().createQuery("select s from Student s").getResultList();

    }

    public Student update(Student student) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public void delete(Student student) {
        System.out.println("Now Removing Student");
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.remove(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted Object !");
    }

    public Student create(Student student) {

        Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(student);
                session.getTransaction().commit();
        return student;
    }


}
