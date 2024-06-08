package com.example.lab7_20191802.DAOS;

import com.example.lab7_20191802.beans.Jobs;
import com.example.lab7_20191802.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoJobs {
    private static final String SELECT_ALL_JOBS_QUERY = "SELECT job_id, job_title, min_salary, max_salary FROM jobs";
    private static final String INSERT_JOB_QUERY = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES (?, ?, ?, ?)";
    private static final String SELECT_JOB_BY_ID_QUERY = "SELECT job_id, job_title, min_salary, max_salary FROM jobs WHERE job_id = ?";

    // Método para listar todos los puestos de trabajo disponibles
    public List<Jobs> getAllJobs() throws SQLException {
        List<Jobs> jobsList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL_JOBS_QUERY);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Jobs job = new Jobs();
                job.setJob_id(rs.getString("job_id"));
                job.setJob_title(rs.getString("job_title"));
                job.setMin_salary(rs.getInt("min_salary"));
                job.setMax_salary(rs.getInt("max_salary"));
                jobsList.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(conn, stmt, rs);
        }
        return jobsList;
    }

    // Método para añadir un nuevo puesto de trabajo
    public void addJob(Jobs job) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(INSERT_JOB_QUERY);
            stmt.setString(1, job.getJob_id());
            stmt.setString(2, job.getJob_title());
            stmt.setInt(3, job.getMin_salary());
            stmt.setInt(4, job.getMax_salary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(conn, stmt, null);
        }
    }

    // Método para obtener un puesto de trabajo por ID
    public Jobs getJobById(String jobId) throws SQLException {
        Jobs job = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(SELECT_JOB_BY_ID_QUERY);
            stmt.setString(1, jobId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                job = new Jobs();
                job.setJob_id(rs.getString("job_id"));
                job.setJob_title(rs.getString("job_title"));
                job.setMin_salary(rs.getInt("min_salary"));
                job.setMax_salary(rs.getInt("max_salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(conn, stmt, rs);
        }
        return job;
    }

    // Método para cerrar conexiones
    private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}