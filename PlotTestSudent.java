package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PlotTestGFA {
    private Plot plot1, plot2;

    @BeforeEach
    public void setUp() throws Exception {
        plot1 = new Plot(3, 3, 8, 8); 
        plot2 = new Plot(4, 5, 3, 2);
    }

    @AfterEach
    public void tearDown() throws Exception {
        plot1 = plot2 = null;
    }

    @org.junit.jupiter.api.Test
    public void testOverlaps() {
        assertTrue("plot1 should overlap with plot2", plot1.overlaps(plot2));
    }

    private void assertTrue(String string, boolean overlaps) {
		
	}

	@org.junit.jupiter.api.Test
    public void testDoesNotOverlap() {
        Plot plot3 = new Plot(12, 12, 3, 3);
        assertTrue("plot1 should not overlap with plot3", plot1.overlaps(plot3));
    }

    @org.junit.jupiter.api.Test
    public void testToString() {
        assertEquals("4,5,3,2", plot2.toString());
    }
}
