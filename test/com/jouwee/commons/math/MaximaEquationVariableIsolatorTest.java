package com.jouwee.commons.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class MaximaEquationVariableIsolatorTest {
    
    /** Equation variable isolator */
    private EquationVariableIsolator isolator;
    /** Equation parser */
    private EquationParser parser;
    
    @Before
    public void setUp() {
        isolator = new MaximaEquationVariableIsolator();
        parser = new EquationParser();
    }

    @Test
    public void testNullEquation() {
        assertNull(isolator.isolate(null, null));
    }
    
    @Test
    public void testAlreadyIsolatedEquations() throws ParsingException  {
        assertEquals(parser.parse("x=1"), isolator.isolate(parser.parse("x=1"), "x"));
        assertEquals(parser.parse("x=a + 1"), isolator.isolate(parser.parse("x=a + 1"), "x"));
    }
    
    @Test
    public void testSimpleInversion() throws ParsingException  {
        assertEquals(parser.parse("x=1"), isolator.isolate(parser.parse("1=x"), "x"));
        assertEquals(parser.parse("x=y"), isolator.isolate(parser.parse("y=x"), "x"));
    }
    
    @Test
    public void testSimpleAddition() throws ParsingException  {
        assertEquals(parser.parse("x=1 - y"), isolator.isolate(parser.parse("x + y=1"), "x"));
    }
    
}
