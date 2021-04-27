package com.javeed.spring_org;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javeed.spring_orm_hibernate.Employee;
import com.javeed.spring_orm_hibernate_dao.EmployeeDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		EmployeeDao emp = context.getBean("employeedao", EmployeeDao.class);
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (true) {
			System.out.println("please select any options");
			System.out.println("**********************************************");
			System.out.println("press 1 : Insert Employees ");
			System.out.println("press 2 : Update Employees ");
			System.out.println("press 3 : Delete Employees");
			System.out.println("press 4 : Get All Employees ");
			System.out.println("press 5 : Get Employees by Id ");
			System.out.println("press 6 : For Exit");
			System.out.println("**********************************************");
			try {
				int option = sc.nextInt();
				switch (option) {
				case 1: {
					// add employee
					System.out.println("Enter Id :");
					int id = sc.nextInt();

					System.out.println("Enter Name :");
					String name = sc.next();

					System.out.println("Enter Email :");
					String email = sc.next();

					Employee e = new Employee(id, name, email);
					int i = emp.addEmployee(e);
					System.out.println("(" + i + ") rows inserted....");

					break;
				}
				case 2: {
					// update employee
					System.out.println("Enter Id :");
					int id = sc.nextInt();

					System.out.println("Enter Name :");
					String name = sc.next();

					System.out.println("Enter Email :");
					String email = sc.next();

					Employee e = new Employee(id, name, email);
					emp.updateEmployee(e);
					System.out.println("Employee updated successfully");
					break;
				}
				case 3: {
					// delete employee
					System.out.println("Enter the Id to be delete : ");
					int id = sc.nextInt();
					emp.deleteEmployee(id);
					System.out.println("Employee deleted successfully");
					break;
				}
				case 4: {
					// get all employees
					List<Employee> employees = emp.getAllEmployee();
					for (Employee employee : employees) {
						System.out.println(employee.toString());
					}
					break;
				}
				case 5: {
					// get employee by id
					System.out.println("Enter the id to get employee details : ");
					int id = sc.nextInt();
					Employee employee = emp.getEmployeeByIdEmployee(id);
					System.out.println(employee.toString());

					break;
				}
				case 6: {
					System.out.println("Thank you");
					flag = false;
					return;
					
				}

				default: {
					System.out.println("please select any one");
					break;
				}

				}
			} catch (Exception ex) {
				System.out.println("please select valid option");
			}
		}
	}
}
