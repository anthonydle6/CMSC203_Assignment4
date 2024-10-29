package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestGFA {
    Property propertyOne;

    @BeforeEach
    void setUp() throws Exception {
        propertyOne = new Property("Property AL", "MD", 6000.00, "LM", 0, 0, 1, 1); 
    }

    @AfterEach
    void tearDown() throws Exception {
        propertyOne = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("Property AL", propertyOne.getPropertyName());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(6000.00, propertyOne.getRentAmount());
    }

    @Test
    void testGetPlot() {
        assertEquals(0, propertyOne.getPlot().getX());
        assertEquals(0, propertyOne.getPlot().getY());
        assertEquals(1, propertyOne.getPlot().getWidth());
        assertEquals(1, propertyOne.getPlot().getDepth());
    }

    @Test
    void testToString() {
        assertEquals("Property AL,MD,LM,6000.0", propertyOne.toString());
    }
}
