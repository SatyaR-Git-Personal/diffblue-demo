package com.example.unit.diffBlue.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setPassportNumber(resultSet.getString("passport_number"));
            return student;
        }

    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from student where id=?", id);
    }

    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
                student.getId(), student.getName(), student.getPassportNumber());
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
                student.getName(), student.getPassportNumber(), student.getId());
    }

}

