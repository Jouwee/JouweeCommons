package com.jouwee.commons.geom;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class Point
 */
public class PointTest {

    /** Delta for tests */
    private static final double DELTA = 0.00001;
    
    @Test
    public void testAngle() {
        assertEquals(0, new Point(0, 0).angle(new Point(0, 0)), DELTA);
        assertEquals(0, new Point(0, 0).angle(new Point(1, 0)), DELTA);
        assertEquals(90, new Point(0, 0).angle(new Point(0, 1)), DELTA);
        assertEquals(180, new Point(0, 0).angle(new Point(-1, 0)), DELTA);
        assertEquals(-90, new Point(0, 0).angle(new Point(0, -1)), DELTA);
    }
    
}
