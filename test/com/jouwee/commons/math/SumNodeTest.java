package com.jouwee.commons.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class SumNode
 * 
 * @author Nícolas Pohren
 */
public class SumNodeTest {
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new SumNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)), new SumNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
    }
    
    @Test
    public void testToComputerString() {
        assertEquals("1 + 1", new SumNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)).toComputerString());
    }
    
}
