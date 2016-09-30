package com.jouwee.commons.math;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class Variable Node
 * 
 * @author Nícolas Pohren
 */
public class VariableNodeTest {
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new VariableNode("x"), new VariableNode("x"));
    }
    
}
