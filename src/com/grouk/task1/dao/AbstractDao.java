package com.grouk.task1.dao;

import com.grouk.task1.exception.SqlDaoException;
import com.grouk.task1.util.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

/**
 * Created by Alena on 12.02.2017.
 */
public class AbstractDao<T> {

    private static final String DB_URL;

    static {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
            DB_URL = resourceBundle.getString("db.url");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            throw new SqlDaoException(e);
        }
    }

    public List<T> load(String query, List<Object> parameters, ResultSetMapper<T> mapper) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = con.prepareStatement(query)) {
            if (parameters != null) {
                setParameters(ps, parameters);
            }
            List<T> list = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapper.map(rs));
                }
            }
            return list;
        } catch (SQLException e) {
            throw new SqlDaoException(e);
        }
    }

    public Integer create(String query, List<Object> parameters) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            setParameters(ps, parameters);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new SqlDaoException(e);
        }
    }

    public void update(String query, List<Object> parameters) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = con.prepareStatement(query)) {

            setParameters(ps, parameters);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new SqlDaoException(e);
        }
    }

    public void delete(String query, List<Object> parameters) {
        try (Connection con = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = con.prepareStatement(query)) {

            setParameters(ps, parameters);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new SqlDaoException(e);
        }
    }

    private void setParameters(PreparedStatement ps, List<Object> parameters) {
        IntStream.range(0, parameters.size())
                .forEach(i -> {
                    try {
                        ps.setObject(i + 1, parameters.get(i));
                    } catch (SQLException e) {
                        throw new SqlDaoException(e);
                    }
                });
    }
}
