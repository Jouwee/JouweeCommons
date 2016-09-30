package com.jouwee.commons.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class DifferenceNodeTest {
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new DifferenceNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)), new DifferenceNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
    }
    
    @Test
    public void testToComputerString() {
        assertEquals("1 - 1", new DifferenceNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)).toComputerString());
    }
    
}
