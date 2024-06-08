package com.example.lab7_20191802.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private int employee_id;
    private String email;
    private String password;
    private String phone_number;
    private Date hire_date;
    private Jobs job_id;
    private BigDecimal salary;
    private BigDecimal commission_pct;
    private Employee manager_id;
    private Departments department_id;
    private int enabled;
    private String fullNameEmployee;

    // Constructor por defecto
    public Employee() {
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    // Constructor con todos los atributos
    public Employee(int employee_id, String email, String password, String phone_number, Date hire_date, Jobs job_id, BigDecimal salary, BigDecimal commission_pct, Employee manager_id, Departments department_id, int enabled, String fullNameEmployee) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
        this.enabled = enabled;
        this.fullNameEmployee = fullNameEmployee;
    }

    // Constructor con atributos mínimos
    public Employee(int employee_id, String email, String password, String phone_number, Date hire_date, Jobs job_id, Departments department_id) {
        this.employee_id = employee_id;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.department_id = department_id;
    }

    // Getters y Setters
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Jobs getJob_id() {
        return job_id;
    }

    public void setJob_id(Jobs job_id) {
        this.job_id = job_id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(BigDecimal commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Employee getManager_id() {
        return manager_id;
    }

    public void setManager_id(Employee manager_id) {
        this.manager_id = manager_id;
    }

    public Departments getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Departments department_id) {
        this.department_id = department_id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }
}