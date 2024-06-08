package com.example.lab7_20191802.DAOS;

import com.example.lab7_20191802.beans.Employee;
import com.example.lab7_20191802.beans.Jobs;
import com.example.lab7_20191802.beans.Departments;
import com.example.lab7_20191802.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEmployee {
    private static final String SELECT_BY_ID_QUERY = "SELECT employee_id, email, password, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id, enabled, CONCAT(first_name, ' ', last_name) AS full_name FROM employees WHERE employee_id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT employee_id, email, password, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id, enabled, CONCAT(first_name, ' ', last_name) AS full_name FROM employees";
    private static final String UPDATE_QUERY = "UPDATE employees SET email = ?, password = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, manager_id = ?, department_id = ?, enabled = ? WHERE employee_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM employees WHERE employee_id = ?";

    public List<Employee> getAllEmployees() throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = stmt.executeQuery()) {

            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                Employee employee = extractEmployeeFromResultSet(rs);
                employees.add(employee);
            }

            return employees;
        }
    }

    public Employee getEmployeeById(int employeeId) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_QUERY)) {

            stmt.setInt(1, employeeId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractEmployeeFromResultSet(rs);
                }
            }
        }

        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

            stmt.setString(1, employee.getEmail());
            stmt.setString(2, employee.getPassword());
            stmt.setString(3, employee.getPhone_number());
            stmt.setDate(4, new java.sql.Date(employee.getHire_date().getTime()));
            stmt.setString(5, employee.getJob_id().getJob_id());
            stmt.setBigDecimal(6, employee.getSalary());
            stmt.setBigDecimal(7, employee.getCommission_pct());

            if (employee.getManager_id() != null) {
                stmt.setInt(8, employee.getManager_id().getEmployee_id());
            } else {
                stmt.setNull(8, Types.INTEGER);
            }

            if (employee.getDepartment_id() != null) {
                stmt.setInt(9, employee.getDepartment_id().getDepartment_id());
            } else {
                stmt.setNull(9, Types.INTEGER);
            }

            stmt.setInt(10, employee.getEnabled());
            stmt.setInt(11, employee.getEmployee_id());

            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int employeeId) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {

            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        }
    }

    private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployee_id(rs.getInt("employee_id"));
        employee.setEmail(rs.getString("email"));
        employee.setPassword(rs.getString("password"));
        employee.setPhone_number(rs.getString("phone_number"));
        employee.setHire_date(rs.getDate("hire_date"));
        employee.setJob_id(new Jobs(rs.getString("job_id")));
        employee.setSalary(rs.getBigDecimal("salary"));
        employee.setCommission_pct(rs.getBigDecimal("commission_pct"));

        int managerId = rs.getInt("manager_id");
        if (!rs.wasNull()) {
            employee.setManager_id(new Employee(managerId));
        }

        int departmentId = rs.getInt("department_id");
        if (!rs.wasNull()) {
            employee.setDepartment_id(new Departments(departmentId));
        }

        employee.setEnabled(rs.getInt("enabled"));
        employee.setFullNameEmployee(rs.getString("full_name"));
        return employee;
    }
}
