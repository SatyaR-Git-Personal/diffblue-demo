package com.example.unit.diffBlue.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StudentTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student()}
     *   <li>{@link Student#setId(Long)}
     *   <li>{@link Student#setName(String)}
     *   <li>{@link Student#setPassportNumber(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getName()}
     *   <li>{@link Student#getPassportNumber()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        actualStudent.setId(123L);
        actualStudent.setName("Name");
        actualStudent.setPassportNumber("42");
        String actualToStringResult = actualStudent.toString();
        assertEquals(123L, actualStudent.getId().longValue());
        assertEquals("Name", actualStudent.getName());
        assertEquals("42", actualStudent.getPassportNumber());
        assertEquals("Student [id=123, name=Name, passportNumber=42]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student(Long, String, String)}
     *   <li>{@link Student#setId(Long)}
     *   <li>{@link Student#setName(String)}
     *   <li>{@link Student#setPassportNumber(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getName()}
     *   <li>{@link Student#getPassportNumber()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Student actualStudent = new Student(123L, "Name", "42");
        actualStudent.setId(123L);
        actualStudent.setName("Name");
        actualStudent.setPassportNumber("42");
        String actualToStringResult = actualStudent.toString();
        assertEquals(123L, actualStudent.getId().longValue());
        assertEquals("Name", actualStudent.getName());
        assertEquals("42", actualStudent.getPassportNumber());
        assertEquals("Student [id=123, name=Name, passportNumber=42]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student(String, String)}
     *   <li>{@link Student#setId(Long)}
     *   <li>{@link Student#setName(String)}
     *   <li>{@link Student#setPassportNumber(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getName()}
     *   <li>{@link Student#getPassportNumber()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        Student actualStudent = new Student("Name", "42");
        actualStudent.setId(123L);
        actualStudent.setName("Name");
        actualStudent.setPassportNumber("42");
        String actualToStringResult = actualStudent.toString();
        assertEquals(123L, actualStudent.getId().longValue());
        assertEquals("Name", actualStudent.getName());
        assertEquals("42", actualStudent.getPassportNumber());
        assertEquals("Student [id=123, name=Name, passportNumber=42]", actualToStringResult);
    }
}

