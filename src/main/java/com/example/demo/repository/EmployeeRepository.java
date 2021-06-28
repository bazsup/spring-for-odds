package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> listAll() {
        // jpql
        return entityManager.createQuery("from Employee").getResultList();
    }

    @Transactional
    public void save(Employee employee) {
        // save employee to table
        entityManager.persist(employee);
    }

    public Employee getById(Integer id) {
        // save employee to table
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}
