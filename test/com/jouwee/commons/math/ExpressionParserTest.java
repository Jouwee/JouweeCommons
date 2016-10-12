package com.jouwee.commons.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class ExpressionParserTest {
    
    /** Expression parser to use in tests */
    private ExpressionParser parser;
    
    /**
     * Setups the test
     */
    @Before
    public void setup() {
        parser = new ExpressionParser();
    }
    
    /**
     * Test the parsing of a null Expression
     */
    @Test
    public void testNullExpression() throws ParsingException {
        assertNull(parser.parse(null));
    }
    
    /**
     * Test the parsing of absolute value nodes
     */
    @Test
    public void testAbsoluteValueNodes() throws ParsingException {
        assertEquals(new Expression(new AbsoluteValueNode(1)), parser.parse("1"));
        assertEquals(new Expression(new AbsoluteValueNode(8)), parser.parse("8"));
        assertEquals(new Expression(new AbsoluteValueNode(10)), parser.parse("10"));
        assertEquals(new Expression(new AbsoluteValueNode(20019)), parser.parse("20019"));
        assertEquals(new Expression(new AbsoluteValueNode(-1)), parser.parse("-1"));
        assertEquals(new Expression(new AbsoluteValueNode(-8)), parser.parse("-8"));
        assertEquals(new Expression(new AbsoluteValueNode(-10)), parser.parse("-10"));
        assertEquals(new Expression(new AbsoluteValueNode(-20019)), parser.parse("-20019"));
    }
    
    /**
     * Test the parsing of variable nodes
     */
    @Test
    public void testVariableNodes() throws ParsingException {
        assertEquals(new Expression(new VariableNode("x")), parser.parse("x"));
        assertEquals(new Expression(new VariableNode("a")), parser.parse("a"));
        assertEquals(new Expression(new VariableNode("y")), parser.parse("y"));
        assertEquals(new Expression(new VariableNode("z")), parser.parse("z"));
    }
    
    /**
     * Test simple addition
     */
    @Test
    public void testAddition() throws ParsingException {
        Expression expected;
        //
        expected = new Expression(new SumNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
        assertEquals(expected, parser.parse("1 + 1"));
    }
    
    /**
     * Test simple Difference
     */
    @Test
    public void testDifference() throws ParsingException {
        Expression expected;
        //
        expected = new Expression(new DifferenceNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
        assertEquals(expected, parser.parse("1 - 1"));
    }
    
    /**
     * Test simple Difference
     */
    @Test
    public void testMultiplication() throws ParsingException {
        Expression expected;
        //
        expected = new Expression(new MultiplicationNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
        assertEquals(expected, parser.parse("1 * 1"));
    }
    
    /**
     * Test invalid expressions
     */
    @Test
    public void testInvalidExpressions() {
        try {
            parser.parse("a -");
            fail();
        } catch(ParsingException e) {}
    }
    
}
