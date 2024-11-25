package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String name);
    List<Student> findByFirstName(String name);
    void update(Student student);
    int deleteAll();
}
