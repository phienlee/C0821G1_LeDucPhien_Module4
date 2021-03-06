package com.example.furama_resort.controller;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.service.contract.AttachServiceService;
import com.example.furama_resort.service.contract.ContractService;
import com.example.furama_resort.service.customer.CustomerService;
import com.example.furama_resort.service.employee.EmployeeService;
import com.example.furama_resort.service.service_hotel.ServiceHotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;
    private final AttachServiceService attachServiceService;
    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final ServiceHotelService serviceHotelService;

    public ContractController(ContractService contractService, AttachServiceService attachServiceService,
                              EmployeeService employeeService, CustomerService customerService,
                              ServiceHotelService serviceHotelService) {
        this.contractService = contractService;
        this.attachServiceService = attachServiceService;
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.serviceHotelService = serviceHotelService;
    }

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("attachServices", attachServiceService.findAll());
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("serviceHotel", serviceHotelService.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/index";
    }

    @PostMapping("/new-contract")
    public String addNewContract(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        return "redirect:/contracts/";
    }

}
