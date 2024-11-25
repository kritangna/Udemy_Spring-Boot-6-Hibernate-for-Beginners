package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        Student theStudent = entityManager.find(Student.class, theId);
        entityManager.remove(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student ", Student.class);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // Create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student WHERE lastName=:theData", Student.class);

        // set query params
        theQuery.setParameter("theData", theLastName);

        // return query results

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String name) {
        // Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student WHERE firstName=:theData", Student.class);

        // set params
        theQuery.setParameter("theData", name);

        // return query
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRows = entityManager.createQuery("delete from Student").executeUpdate();
        return numOfRows;
    }
}
