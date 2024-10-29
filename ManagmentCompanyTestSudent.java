package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ManagementCompanyGFATest {
    Property sampleProperty;
    ManagementCompany managementCo; 

    @BeforeEach
    public void setUp() throws Exception {
        managementCo = new ManagementCompany("Anthony", "20852", 10.0); 
    }

    @AfterEach
    public void tearDown() throws Exception {
        managementCo = null;
    }

    @org.junit.jupiter.api.Test
    public void testAddProperty() {
        sampleProperty = new Property("GS", "Le", 6000.0, "GT", 2, 5, 2, 2);		 
        Assertions.assertEquals(0, managementCo.addProperty(sampleProperty));
    }

    @org.junit.jupiter.api.Test
    public void testGetPropertiesCount() {
        sampleProperty = new Property("GS", "Le", 6000.0, "LH", 2, 5, 2, 2);		 
        managementCo.addProperty(sampleProperty);
        Assertions.assertEquals(1, managementCo.getPropertiesCount());
    }

    @org.junit.jupiter.api.Test
    public void testToString() {
        sampleProperty = new Property("GS", "GT", 6000.0, "LH", 2, 5, 2, 2);
        managementCo.addProperty(sampleProperty); 

        String expectedString = "Management Company: Anthony\n"
                + "Tax ID: 20852\n"
                + "Properties:\n"
                + "Property Name: GS, City: GT, Rent: 6000.0, Owner: LH\n"
                + "Total Management Fee: 600.0"; 
                
        System.out.println("Expected String:\n" + expectedString);
        System.out.println("Actual String:\n" + managementCo.toString());
        
        Assertions.assertEquals(expectedString, managementCo.toString());
    }
}
