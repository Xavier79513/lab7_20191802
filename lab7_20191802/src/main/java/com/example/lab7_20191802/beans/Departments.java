package com.example.lab7_20191802.beans;

import com.example.lab7_20191802.beans.Employee;
import com.example.lab7_20191802.beans.Locations;
public class Departments {
    private int department_id;
    private String department_name;
    private Employee manager_id;
    private Locations location_id;

    public Departments(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Employee getManager_id() {
        return manager_id;
    }

    public void setManager_id(Employee manager_id) {
        this.manager_id = manager_id;
    }

    public Locations getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Locations location_id) {
        this.location_id = location_id;
    }
}