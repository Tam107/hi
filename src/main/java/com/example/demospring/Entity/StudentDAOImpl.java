package com.example.demospring.Entity;

import com.example.demospring.Dao.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //create entity manager to manage

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void findAll() {

    }

    @Override
    public void findByLastName(String lastName) {

    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id );
        entityManager.remove(theStudent);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
