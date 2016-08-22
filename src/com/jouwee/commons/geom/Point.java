package com.jouwee.commons.geom;

/**
 * Representation of a Point
 * 
 * @author Jouwee
 */
public class Point {
    
    /** X coordinate */
    public final double x;
    /** X coordinate */
    public final double y;

    /**
     * Creates a new Point
     */
    public Point() {
        this(0, 0);
    }
    
    /**
     * Creates a new point
     * 
     * @param source 
     */
    public Point(Point source) {
        this(source.x, source.y);
    }
    
    /**
     * Creates a point
     * 
     * @param x
     * @param y 
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Derive this point in the X coordinate
     * 
     * @param newX
     * @return Point
     */
    public Point deriveX(double newX) {
        return new Point(newX, y);
    }
    
    /**
     * Returns the distance between two points
     * 
     * @param p
     * @return double
     */
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
    
    /**
     * Returns the angle between two points
     * 
     * @param p
     * @return double
     */
    public double angle(Point p) {
        return Math.atan2(p.y - y, p.x - x) * 180 / Math.PI;
    }
    
    /**
     * Derive this point in the Y coordinate
     * 
     * @param newY
     * @return Point
     */
    public Point deriveY(double newY) {
        return new Point(x, newY);
    }
    
    /**
     * Derive this point in the X coordinate
     * 
     * @param xFactor
     * @return Point
     */
    public Point deriveXFactor(double xFactor) {
        return new Point(x * xFactor, y);
    }
    
    /**
     * Derive this point in the Y coordinate
     * 
     * @param yFactor
     * @return Point
     */
    public Point deriveYFactor(double yFactor) {
        return new Point(x, y * yFactor);
    }
    
    /**
     * Returns the X coordinate
     * 
     * @return double
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the Y coordinate
     * 
     * @return double
     */
    public double getY() {
        return y;
    }   
    
}
