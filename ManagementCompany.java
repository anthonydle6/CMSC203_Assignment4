package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le*/

public class ManagementCompany 
{

    // constant
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_DEPTH = 10;
    public static final int MGMT_WIDTH = 10;

    // field
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Plot plot;
    private Property[] properties;

    // constructs
    public ManagementCompany() 
    {
        this.name = ""; //name
        this.taxID = ""; //taxID
        this.mgmFeePer = 10.0; //mgmFee 10%
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); //plot size
        this.properties = new Property[MAX_PROPERTY]; //properties #
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) 
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) 
    {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany) 
    {
        if (otherCompany != null) 
        {
            this.name = otherCompany.name;
            this.taxID = otherCompany.taxID;
            this.mgmFeePer = otherCompany.mgmFeePer;
            this.plot = new Plot(otherCompany.plot);
            this.properties = new Property[MAX_PROPERTY];
            System.arraycopy(otherCompany.properties, 0, this.properties, 0, MAX_PROPERTY);
        }
    }

    // Methods
    public int addProperty(String name, String city, double rent, String owner) 
    {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
    {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) 
    {
        if (isPropertiesFull()) 
        {
        	//full array indication
            return -1; 
        } else if (property == null) 
        {
        	//null property
            return -2; 
        } else if (!plot.encompasses(property.getPlot())) 
        {
        	// out of management plot bounds
            return -3; 
        } else {
            for (Property p : properties) 
            {
            	//overlapping plots
                if (p != null && p.getPlot().overlaps(property.getPlot())) 
                {
                    return -4; 
                }
            }
            for (int i = 0; i < properties.length; i++) 
            {
                if (properties[i] == null) 
                {
                    properties[i] = new Property(property);
                    
                 // return index where property is added
                    return i; 
                }
            }
        }
        
     // full array
        return -1; 
    }

    public void removeLastProperty() 
    {
        for (int i = properties.length - 1; i >= 0; i--) 
        {
            if (properties[i] != null) 
            {
                properties[i] = null;
                break;
            }
        }
    }

    public boolean isPropertiesFull() 
    {
        for (Property property : properties) 
        {
            if (property == null) 
            {
                return false;
            }
        }
        return true;
    }

    public int getPropertiesCount() 
    {
        int count = 0;
        for (Property property : properties) 
        {
            if (property != null) count++;
        }
        return count;
    }

    public double getTotalRent() 
    {
        double totalRent = 0;
        for (Property property : properties) 
        {
            if (property != null) 
            {
                totalRent += property.getRentAmount();
            }
        }
        return totalRent;
    }

    public Property getHighestRentProperty() 
    {
        Property highestRentProperty = null;
        double highestRent = 0;
        for (Property property : properties) 
        {
            if (property != null && property.getRentAmount() > highestRent) 
            {
                highestRent = property.getRentAmount();
                highestRentProperty = property;
            }
        }
        return highestRentProperty;
    }

    public boolean isManagementFeeValid() 
    {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public String getName() 
    {
        return name;
    }

    public String getTaxID() 
    {
        return taxID;
    }

    public Property[] getProperties() 
    {
        return properties;
    }

    public double getMgmFeePer() 
    {
        return mgmFeePer;
    }

    public Plot getPlot() 
    {
        return plot;
    }

    @Override
    public String toString() 
    {
        StringBuilder info = new StringBuilder();
        info.append("Management Company: ").append(name)
            .append("\nTax ID: ").append(taxID)
            .append("\nProperties:\n");
        for (Property property : properties) 
        {
            if (property != null) 
            {
                info.append(property.toString()).append("\n");
            }
        }
        double totalManagementFee = getTotalRent() * (mgmFeePer / 100);
        info.append("Total Management Fee: ").append(totalManagementFee);
        return info.toString();
    }
}
