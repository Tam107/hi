package com.example.demospring.Dao;

import com.example.demospring.Entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    void findAll();
    void findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();
}
