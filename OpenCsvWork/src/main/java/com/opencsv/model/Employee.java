package com.opencsv.model;

import com.opencsv.bean.CsvBindByPosition;

public class Employee {

    @CsvBindByPosition(position = 0)
    private Integer empId;

    @CsvBindByPosition(position = 1)
    private String empName;

    @CsvBindByPosition(position = 2)
    private String region;

    public Integer getEmpId() {
        return empId;
    }

    public Employee setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public String getEmpName() {
        return empName;
    }

    public Employee setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Employee setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empId=").append(empId);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
