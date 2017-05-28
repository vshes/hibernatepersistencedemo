package com.shesh.db.dao;

import com.shesh.db.model.Student;
import com.shesh.db.utils.DbUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by shesh on 5/26/17.
 */
public class StudentDaoSessionFactoryImpl implements  StudentDao{


    private SessionFactory sessionFactory;
    public StudentDaoSessionFactoryImpl() throws Exception {
        sessionFactory  = new Configuration().addProperties(DbUtil.getProp("sf.properties"))
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

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
        Session session = sessionFactory.openSession()1;
        Query query = session.createQuery("select s from Student s");
        List<Student> resultList = query.getResultList();
        session.close();
        return resultList;

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
        System.out.println("Creating Object using SessionFactory !");
        Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(student);
                session.getTransaction().commit();

        return student;
    }


}
