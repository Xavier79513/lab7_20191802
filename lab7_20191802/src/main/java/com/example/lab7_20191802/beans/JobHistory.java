package com.example.lab7_20191802.beans;

import com.example.lab7_20191802.beans.Employee;
import com.example.lab7_20191802.beans.Jobs;
import com.example.lab7_20191802.beans.Departments;

import java.util.Date;

public class JobHistory {
    private int job_history_id;
    private Employee employee_id;
    private Date start_date;
    private Date end_date;
    private Jobs job_id;
    private Departments department_id;

    public int getJob_history_id() {
        return job_history_id;
    }

    public void setJob_history_id(int job_history_id) {
        this.job_history_id = job_history_id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Jobs getJob_id() {
        return job_id;
    }

    public void setJob_id(Jobs job_id) {
        this.job_id = job_id;
    }

    public Departments getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Departments department_id) {
        this.department_id = department_id;
    }
}
