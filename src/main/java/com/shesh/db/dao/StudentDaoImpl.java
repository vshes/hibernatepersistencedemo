package com.shesh.db.dao;

import com.shesh.db.model.Student;
import com.shesh.db.utils.DbUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by shesh on 5/23/17.
 */
public class StudentDaoImpl implements StudentDao {
    private  EntityManagerFactory emf ;
    private Logger logger ;
    private EntityManager em;

    public StudentDaoImpl() throws IOException {
        Properties prop = DbUtil.getProp();
        emf = Persistence.createEntityManagerFactory("dbdemo", prop);
        this.logger = Logger.getLogger("DAO");
    }
    public Student findOne(String id) {
        em = emf.createEntityManager();
        return em.find(Student.class,id);

    }

    public List<Student> findAll() {

        em = emf.createEntityManager();
        return  em.createQuery("select s from Student as s",Student.class).getResultList();

    }

    public Student update(Student student) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
        return  student;

    }

    public void delete(Student student) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(student));
        em.getTransaction().commit();
        em.close();
        System.out.println("deleted !");
    }

    public Student create(Student student) {

        this.em = emf.createEntityManager();

        this.em.getTransaction().begin();
        this.em.persist(student);
        this.em.getTransaction().commit();
        logger.info("New object is created for : Student \t"+student.toString());
        return student;

    }
}
