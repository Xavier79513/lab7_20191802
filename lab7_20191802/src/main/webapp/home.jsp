<%--
Created by IntelliJ IDEA.
  User: juga_
  Date: 6/06/2024
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lab7_20191802.beans.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Lista de Empleados</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Hire Date</th>
        <th>Job</th>
        <th>Salary</th>
        <th>Manager</th>
        <th>Department</th>
        <th>Enabled</th>
        <th>Full Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Employee employee : employees) {
    %>
    <tr>
        <td><%= employee.getEmployee_id() %></td>
        <td><%= employee.getEmail() %></td>
        <td><%= employee.getPhone_number() %></td>
        <td><%= employee.getHire_date() %></td>
        <td><%= employee.getJob_id().getJob_title() %></td>
        <td><%= employee.getSalary() %></td>
        <td><%= employee.getManager_id() != null ? employee.getManager_id().getFullNameEmployee() : "" %></td>
        <td><%= employee.getDepartment_id() != null ? employee.getDepartment_id().getDepartment_name() : "" %></td>
        <td><%= employee.getEnabled() %></td>
        <td><%= employee.getFullNameEmployee() %></td>
        <td>
            <form action="/edit" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= employee.getEmployee_id() %>" />
                <button type="submit">Edit</button>
            </form>
            <form action="/delete" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= employee.getEmployee_id() %>" />
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>