package com.jouwee.commons.math;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test of class Expression
 * 
 * @author Nícolas Pohren
 */
public class ExpressionTest {
    
    /** Delta */
    private static final double DELTA = 0.00001;
    /** Expression parser */
    private ExpressionParser parser;
    
    @Before
    public void setup() {
        parser = new ExpressionParser();
    }
    
    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        assertEquals(new Expression(new AbsoluteValueNode(1)), new Expression(new AbsoluteValueNode(1)));
    }
    
    /**
     * Test method getVariableCoeficient
     * 
     * @throws com.jouwee.commons.math.ParsingException
     */
    @Test
    public void testGetVariableCoeficient() throws ParsingException {
        assertEquals(0, parser.parse("1 + 1").getVariableCoeficient("x"), DELTA);
        assertEquals(0, parser.parse("2 * y").getVariableCoeficient("x"), DELTA);
        //
        assertEquals(2, parser.parse("2 * x").getVariableCoeficient("x"), DELTA);
        assertEquals(2, parser.parse("1 + 2 * x").getVariableCoeficient("x"), DELTA);
        assertEquals(2, parser.parse("3 * y + 2 * x").getVariableCoeficient("x"), DELTA);
        assertEquals(2, parser.parse("2 * x + 1").getVariableCoeficient("x"), DELTA);
        assertEquals(2, parser.parse("2 * x + 3 * y").getVariableCoeficient("x"), DELTA);
        assertEquals(0.2, parser.parse("0.20 * a + 0.30 * b").getVariableCoeficient("a"), DELTA);
    }
    
}
