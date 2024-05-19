package com.komal.curdEmployee.controller;

import com.komal.curdEmployee.dao.Employee;
import com.komal.curdEmployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String getEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        if(employeeList.isEmpty()) {
            model.addAttribute("employeeListError", "No Data Found");
        } else {
            model.addAttribute("employeeList", employeeList);
        }
        return "employeeList";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("isUpdate", false);
        return "addUpdateEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        model.addAttribute("message", "Employee added successfully");
        model.addAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("isUpdate", true);
        return "addUpdateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        String message = employeeService.deleteEmployeeById(id);
        model.addAttribute("message", message);
        model.addAttribute("alertClass", "alert-success");
        return "redirect:/";
    }

}
