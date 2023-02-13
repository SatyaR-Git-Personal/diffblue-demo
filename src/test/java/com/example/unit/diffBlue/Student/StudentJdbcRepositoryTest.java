package com.example.unit.diffBlue.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentJdbcRepositoryTest {
    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentJdbcRepository studentJdbcRepository;

    /**
     * Method under test: {@link StudentJdbcRepository#findAll()}
     */
    @Test
    void testFindAll() {
        List<Student> actualFindAllResult = studentJdbcRepository.findAll();
        assertEquals(2, actualFindAllResult.size());
        Student getResult = actualFindAllResult.get(0);
        assertEquals("New-Passport", getResult.getPassportNumber());
        Student getResult1 = actualFindAllResult.get(1);
        assertEquals("A1234657", getResult1.getPassportNumber());
        assertEquals("Satya", getResult1.getName());
        assertEquals(10010L, getResult1.getId().longValue());
        assertEquals("Name-Updated", getResult.getName());
        assertEquals(10001L, getResult.getId().longValue());
    }

    /**
     * Method under test: {@link StudentJdbcRepository#findById(long)}
     */
    @Test
    void testFindById() throws DataAccessException {
        Student student = new Student();
        when(jdbcTemplate.queryForObject((String) any(), (Object[]) any(), (RowMapper<Object>) any()))
                .thenReturn(student);
        assertSame(student, studentJdbcRepository.findById(123L));
        verify(jdbcTemplate).queryForObject((String) any(), (Object[]) any(), (RowMapper<Object>) any());
    }

    /**
     * Method under test: {@link StudentJdbcRepository#deleteById(long)}
     */
    @Test
    void testDeleteById() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        studentJdbcRepository.deleteById(123L);
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link StudentJdbcRepository#insert(Student)}
     */
    @Test
    void testInsert() throws DataAccessException {
        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        assertEquals(1, studentJdbcRepository.insert(new Student("Name", "42")));
        verify(jdbcTemplate).update((String) any(), (Object[]) any());
    }

    /**
     * Method under test: {@link StudentJdbcRepository#insert(Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testInsert2() throws DataAccessException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository.insert(StudentJdbcRepository.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        studentJdbcRepository.insert(null);
    }

    /**
     * Method under test: {@link StudentJdbcRepository.StudentRowMapper#mapRow(ResultSet, int)}
     */
    @Test
    void testStudentRowMapperMapRow() throws SQLException {
        StudentJdbcRepository.StudentRowMapper studentRowMapper = new StudentJdbcRepository.StudentRowMapper();
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString((String) any())).thenReturn("String");
        when(resultSet.getLong((String) any())).thenReturn(1L);
        Student actualMapRowResult = studentRowMapper.mapRow(resultSet, 10);
        assertEquals(1L, actualMapRowResult.getId().longValue());
        assertEquals("String", actualMapRowResult.getPassportNumber());
        assertEquals("String", actualMapRowResult.getName());
        verify(resultSet, atLeast(1)).getString((String) any());
        verify(resultSet).getLong((String) any());
    }

    /**
     * Method under test: {@link StudentJdbcRepository.StudentRowMapper#mapRow(ResultSet, int)}
     */
    @Test
    void testStudentRowMapperMapRow2() throws SQLException {
        StudentJdbcRepository.StudentRowMapper studentRowMapper = new StudentJdbcRepository.StudentRowMapper();
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString((String) any())).thenThrow(new SQLException());
        when(resultSet.getLong((String) any())).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> studentRowMapper.mapRow(resultSet, 10));
        verify(resultSet).getLong((String) any());
    }

    /**
     * Method under test: {@link StudentJdbcRepository#update(Student)}
     */
    @Test
    void testUpdate() {
        assertEquals(0, studentJdbcRepository.update(new Student("Name", "42")));
    }

    /**
     * Method under test: {@link StudentJdbcRepository#update(Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository.update(StudentJdbcRepository.java:50)
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository$$FastClassBySpringCGLIB$$9d2da997.invoke(<generated>)
        //   See https://diff.blue/R013 to resolve this issue.

        studentJdbcRepository.update(null);
    }

    /**
     * Method under test: {@link StudentJdbcRepository#update(Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: PreparedStatementCallback; SQL [update student  set name = ?, passport_number = ?  where id = ?]; NULL not allowed for column "NAME"; SQL statement:
        //   update student  set name = ?, passport_number = ?  where id = ? [23502-214]; nested exception is org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "NAME"; SQL statement:
        //   update student  set name = ?, passport_number = ?  where id = ? [23502-214]
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository.update(StudentJdbcRepository.java:49)
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository$$FastClassBySpringCGLIB$$9d2da997.invoke(<generated>)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "NAME"; SQL statement:
        //   update student  set name = ?, passport_number = ?  where id = ? [23502-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.table.Column.validateConvertUpdateSequence(Column.java:365)
        //       at org.h2.table.Table.convertUpdateRow(Table.java:968)
        //       at org.h2.command.dml.SetClauseList.prepareUpdate(SetClauseList.java:140)
        //       at org.h2.command.dml.Update.update(Update.java:88)
        //       at org.h2.command.dml.DataChangeStatement.update(DataChangeStatement.java:74)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:169)
        //       at org.h2.command.Command.executeUpdate(Command.java:252)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
        //       at com.zaxxer.hikari.pool.ProxyPreparedStatement.executeUpdate(ProxyPreparedStatement.java:61)
        //       at com.zaxxer.hikari.pool.HikariProxyPreparedStatement.executeUpdate(HikariProxyPreparedStatement.java)
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository.update(StudentJdbcRepository.java:49)
        //       at com.example.unit.diffBlue.Student.StudentJdbcRepository$$FastClassBySpringCGLIB$$9d2da997.invoke(<generated>)
        //   See https://diff.blue/R013 to resolve this issue.

        Student student = new Student();
        student.setId(123L);
        studentJdbcRepository.update(student);
    }
}

