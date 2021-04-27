package com.javeed.spring_orm_hibernate_dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.javeed.spring_orm_hibernate.Employee;

public class EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Insert statement
	@Transactional
	public int addEmployee(Employee employee) {

		Integer rows = (Integer) hibernateTemplate.save(employee);
		return rows;
	}
	// get all employees

	public List<Employee> getAllEmployee() {

		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
		return employees;

	}

	// get employee by id
	public Employee getEmployeeByIdEmployee(int id) {

		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}

	// update employees
	@Transactional
	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);
	}

	// delete employees
	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}

}
