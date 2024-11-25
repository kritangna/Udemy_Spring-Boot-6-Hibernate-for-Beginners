package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entityManager

    public EntityManager entityManager;

    // set up constructor
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee e", Employee.class);

        // execute query and get the result
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        int employeeId = id;

        // get employee
        Employee theEmployee = entityManager.find(Employee.class, employeeId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {

        // save employee
        Employee dbEmployee = entityManager.merge(employee);

        // return the updated employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }
}
