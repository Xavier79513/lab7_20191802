package com.example.lab7_20191802.DAOS;

import com.example.lab7_20191802.beans.Employee;
import com.example.lab7_20191802.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcatDAO {
    private static final String SELECT_BY_ID_QUERY = "SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM employees WHERE employee_id = ?";

    public Employee getEmployeeById(int employeeId) throws SQLException {
        Employee employee = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID_QUERY);
            stmt.setInt(1, employeeId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String fullName = rs.getString("full_name");
                employee = new Employee();
                employee.setFullNameEmployee(fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }
}