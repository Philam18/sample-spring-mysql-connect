package com.example.demo4.dao;

import com.example.demo4.model.Circle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class CircleDAO extends NamedParameterJdbcDaoSupport {

    public Circle getCircle(int id) {
        String sql = "SELECT * FROM Circle WHERE id = :id LIMIT 1";
        HashMap<String, Object> nHashMap = new HashMap<>();
        nHashMap.put("id", id);
        return getNamedParameterJdbcTemplate().queryForObject(sql, nHashMap, new CircleRowMapper());
    }

    public boolean insertCircle(Circle circle) {
        String sql = "INSERT INTO circle (id, name) values (:id, :name)";
        HashMap<String, Object> namedHashmap = new HashMap<>();
        namedHashmap.put("id", circle.getId());
        namedHashmap.put("name", circle.getName());
        try {
            int result = getNamedParameterJdbcTemplate().update(sql, namedHashmap);
            return result == 1;
        } catch (Exception e) {
            // System.out.println(e);
        }
        return false;
    }

    public String getCircleName(int id) {
        String sql = "SELECT name FROM Circle WHERE id = :id LIMIT 1";
        HashMap<String, Object> namedHashMap = new HashMap<>();
        namedHashMap.put("id", id);
        return getNamedParameterJdbcTemplate().queryForObject(sql, namedHashMap, String.class);
    }

    public int getCircleCount() {
        String sql = "SELECT count(*) FROM Circle";
        return getNamedParameterJdbcTemplate().queryForObject(sql, new HashMap<String, Object>(), int.class);
    }

    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM Circle";
        return getNamedParameterJdbcTemplate().query(sql, new CircleRowMapper());
    }

    public boolean createCircleTable() {
        String sql = "CREATE TABLE circle (id int(8) PRIMARY KEY, name varchar(500))";
        return getNamedParameterJdbcTemplate().execute(sql, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                try {
                    return ps.execute();
                }
                catch (Exception e) {
                    // System.out.println(e);
                }
                return false;
            }
        });
    }


    private static final class CircleRowMapper implements RowMapper<Circle> {
        @Override
        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Circle(resultSet.getInt("id"), resultSet.getString("name"));
        }

    }


}