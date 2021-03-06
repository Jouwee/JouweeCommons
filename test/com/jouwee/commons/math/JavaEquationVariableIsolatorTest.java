package com.jouwee.commons.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class JavaEquationVariableIsolatorTest {
    
    /** Equation variable isolator */
    private JavaEquationVariableIsolator isolator;
    /** Equation parser */
    private EquationParser parser;
    
    @Before
    public void setUp() {
        isolator = new JavaEquationVariableIsolator();
        parser = new EquationParser();
    }

    @Test
    public void testNullEquation() {
        assertNull(isolator.isolate(null, null));
    }
    
    @Test
    public void testAlreadyIsolatedEquations() throws ParsingException  {
        assertEquals(parser.parse("x=1"), isolator.isolate(parser.parse("x=1"), "x"));
        assertEquals(parser.parse("x=a+b+c+1"), isolator.isolate(parser.parse("x=a+b+c+1"), "x"));
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
