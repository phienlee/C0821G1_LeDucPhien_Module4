package com.example.furama_resort.controller;

import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.service.employee.DepartmentService;
import com.example.furama_resort.service.employee.EducationDegreeService;
import com.example.furama_resort.service.employee.EmployeeService;
import com.example.furama_resort.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final PositionService positionService;
    private final DepartmentService departmentService;
    private final EducationDegreeService educationDegreeService;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(PositionService positionService, DepartmentService departmentService,
                              EducationDegreeService educationDegreeService, EmployeeService employeeService) {
        this.positionService = positionService;
        this.departmentService = departmentService;
        this.educationDegreeService = educationDegreeService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("emList", employeeService.findAll());
        return "employee/index";
    }

    @PostMapping("/new-employee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/";
    }


    @GetMapping("/create")
    public String addNew(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        return "employee/new";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employees/";
    }
}
