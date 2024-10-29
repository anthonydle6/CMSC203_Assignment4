package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // construct basic field
    public Property(String propertyName, String city, double rentAmount, String owner) 
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        //default plot
        this.plot = new Plot();  
    }

    //plot parameters
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
    {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    //construct copy
    public Property(Property otherProperty) 
    {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    //getter plot
    public Plot getPlot() 
    {
        return plot;
    }

    //getter property
    public String getPropertyName() 
    {
        return propertyName;
    }

    //getter rent
    public double getRentAmount() 
    {
        return rentAmount;
    }

    public String getCity() 
    {
        return city;
    }

    public String getOwner() 
    {
        return owner;
    }

    @Override
    public String toString() 
    {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
