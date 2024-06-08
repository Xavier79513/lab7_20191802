package com.example.lab7_20191802.Servlets;

import com.example.lab7_20191802.DAOS.DaoEmployee;
import com.example.lab7_20191802.beans.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEmployee daoEmployee = new DaoEmployee();
        List<Employee> employees = null;
        try {
            employees = daoEmployee.getAllEmployees();
            request.setAttribute("employees", employees);
            RequestDispatcher view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);
        } catch (SQLException e) {
            // Manejar la excepción SQLException aquí
            e.printStackTrace();
            response.getWriter().println("Error al obtener los empleados: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // No hay operaciones POST en este servlet, puedes dejar este método vacío o implementar la lógica necesaria
    }
}