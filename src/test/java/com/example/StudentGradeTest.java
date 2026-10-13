package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
 
import static org.junit.jupiter.api.Assertions.*;
 
public class StudentGradeTest {
 
    private StudentGrade studentGrade;
 
    @BeforeEach
    void setUp() {
        studentGrade = new StudentGrade();
    }
 
    // ===== calculateGrade: independent path =====
 
    @Test
    void calculateGrade_scoreNegatif_throwException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> studentGrade.calculateGrade(-1));
        assertEquals("Score must be between 0 and 100", ex.getMessage());
    }
 
    @Test
    void calculateGrade_scoreLebihDari100_throwException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> studentGrade.calculateGrade(101));
        assertEquals("Score must be between 0 and 100", ex.getMessage());
    }
 
    @Test
    void calculateGrade_gradeA() {
        assertEquals("A", studentGrade.calculateGrade(85));
    }
 
    @Test
    void calculateGrade_gradeB() {
        assertEquals("B", studentGrade.calculateGrade(75));
    }
 
    @Test
    void calculateGrade_gradeC() {
        assertEquals("C", studentGrade.calculateGrade(65));
    }
 
    @Test
    void calculateGrade_gradeD() {
        assertEquals("D", studentGrade.calculateGrade(55));
    }
 
    @Test
    void calculateGrade_gradeE() {
        assertEquals("E", studentGrade.calculateGrade(40));
    }
 
    // ===== calculateGrade: boundary value =====
 
    @ParameterizedTest
    @CsvSource({
            "100,A", "80,A", "79,B", "70,B", "69,C",
            "60,C", "59,D", "50,D", "49,E", "0,E"
    })
    void calculateGrade_boundaryValue(int score, String expected) {
        assertEquals(expected, studentGrade.calculateGrade(score));
    }
 
    // ===== isPassed =====
 
    @Test
    void isPassed_scoreDiAtasBatas_true() {
        assertTrue(studentGrade.isPassed(75));
    }
 
    @Test
    void isPassed_scoreTepatBatas60_true() {
        assertTrue(studentGrade.isPassed(60));
    }
 
    @Test
    void isPassed_scoreDibawahBatas_false() {
        assertFalse(studentGrade.isPassed(59));
    }
 
    @Test
    void isPassed_scoreNol_false() {
        assertFalse(studentGrade.isPassed(0));
    }
 
    @Test
    void isPassed_score100_true() {
        assertTrue(studentGrade.isPassed(100));
    }
 
    @Test
    void isPassed_scoreNegatif_throwException() {
        assertThrows(IllegalArgumentException.class,
                () -> studentGrade.isPassed(-1));
    }
 
    @Test
    void isPassed_scoreLebihDari100_throwException() {
        assertThrows(IllegalArgumentException.class,
                () -> studentGrade.isPassed(101));
    }
}
