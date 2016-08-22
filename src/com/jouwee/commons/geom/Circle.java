package com.jouwee.commons.geom;

/**
 * Representation of a circle
 * 
 * @author Jouwee
 */
public class Circle {
    
    /** Center point */
    private final Point center;
    /** Radius */
    private final double radius;

    /**
     * Creates a new Circle
     * 
     * @param center
     * @param radius 
     */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Check if two circles collides
     * 
     * @param circle
     * @return boolean
     */
    public boolean intersect(Circle circle) {
        return Math.abs(center.distance(circle.center)) <= (radius + circle.radius);
    }

    /**
     * Returns the center
     * 
     * @return Point
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Returns the radius
     * 
     * @return double
     */
    public double getRadius() {
        return radius;
    }

}
