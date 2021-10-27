package com.opencsv.controller;

import com.opencsv.model.Employee;
import com.opencsv.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CSVController {

    @Autowired
    private CsvService service;

    @GetMapping
    public List<Employee> writeEmployees(){
        String csvPath = service.createCsv(getEmps());
        return service.getEmpsFromCsv(csvPath);
    }

    private List<Employee> getEmps(){
        List<Employee> empList = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setEmpId(1).setEmpName("Vijay").setRegion("India");

        Employee e2 = new Employee();
        e2.setEmpId(2).setEmpName("Pia").setRegion("India");

        empList.add(e1);
        empList.add(e2);
        return empList;
    }
}
