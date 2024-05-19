package com.komal.curdEmployee;

import com.komal.curdEmployee.dao.Employee;
import com.komal.curdEmployee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurdEmployeeApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(CurdEmployeeApplication.class, args);
	}

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee =  new Employee("komal", "Rachewar", "komal@gmail.com", "8412948993");
//		Employee employee1 =  new Employee("kajal", "Rachewar", "kajal@gmail.com", "1234567890");
//
//		employeeRepo.saveAndFlush(employee);
//		employeeRepo.saveAndFlush(employee1);

	}
}
