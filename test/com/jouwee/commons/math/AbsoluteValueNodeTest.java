package com.jouwee.commons.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class AbsoluteValueNode
 * 
 * @author Nícolas Pohren
 */
public class AbsoluteValueNodeTest {
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new AbsoluteValueNode(1), new AbsoluteValueNode(1));
    }
    
    @Test
    public void testToComputerString() {
        assertEquals("1", new AbsoluteValueNode(1).toComputerString());
    }
    
}
