package com.jouwee.commons.math;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class Expression
 * 
 * @author Nícolas Pohren
 */
public class ExpressionTest {
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new Expression(new AbsoluteValueNode(1)), new Expression(new AbsoluteValueNode(1)));
    }
    
}
