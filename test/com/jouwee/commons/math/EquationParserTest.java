package com.jouwee.commons.math;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for EquationParser class
 * 
 * @author Nícolas Pohren
 */
public class EquationParserTest {
    
    /** Equation parser to use in tests */
    private EquationParser parser;
    
    /**
     * Setups the test
     */
    @Before
    public void setup() {
        parser = new EquationParser();
    }
    
    /**
     * Test the parsing of simple equations
     */
    @Test
    public void testNullEquation() {
        assertNull(parser.parse(null));
    }
    
    /**
     * Test the parsing of simple equations
     */
    @Test
    public void testSimpleEquations() {
        Equation equation;
        //
        equation = parser.parse("1 + 1=2 + 2");
        assertEquals("1 + 1", equation.getLeftFunction().toComputerString());
        assertEquals("2 + 2", equation.getRightFunction().toComputerString());
        assertEquals(EquationType.EQUALS_TO, equation.getType());
    }
    
}
