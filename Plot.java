package application;

/*Class: CMSC-203-23488
Program: Assignment #4 Implementation
Instructor: Huseyin Aygun
Summary of Description: Property Management App
Due Date: 10/28/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Anthony Le
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // default constructor
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    // parameterized x, y, width, and depth
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    //construct
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth); // calls the parameterized constructor
    }

    //setter and getters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // encompass check
    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x &&
                plot.y >= this.y &&
                plot.x + plot.width <= this.x + this.width &&
                plot.y + plot.depth <= this.y + this.depth);
    }

    //overlap check
    public boolean overlaps(Plot plot) {
        return (this.x < plot.x + plot.width &&
                this.x + this.width > plot.x &&
                this.y < plot.y + plot.depth &&
                this.y + this.depth > plot.y);
    }

    // toString method
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
