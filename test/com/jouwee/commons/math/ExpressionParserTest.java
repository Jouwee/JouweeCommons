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
     * 
     * @throws com.jouwee.commons.math.ParsingException
     */
    @Test
    public void testNullExpression() throws ParsingException {
        assertNull(parser.parse(null));
    }
    
    /**
     * Test the parsing of absolute value nodes
     * 
     * @throws com.jouwee.commons.math.ParsingException
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
        assertEquals(new Expression(new AbsoluteValueNode(0.1)), parser.parse("0.1"));
        assertEquals(new Expression(new AbsoluteValueNode(0.1)), parser.parse("0,1"));
    }
    
    /**
     * Test the parsing of variable nodes
     * 
     * @throws com.jouwee.commons.math.ParsingException
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
     * 
     * @throws com.jouwee.commons.math.ParsingException
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
     * 
     * @throws com.jouwee.commons.math.ParsingException
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
     * 
     * @throws com.jouwee.commons.math.ParsingException
     */
    @Test
    public void testMultiplication() throws ParsingException {
        Expression expected;
        //
        expected = new Expression(new MultiplicationNode(new AbsoluteValueNode(1), new AbsoluteValueNode(1)));
        assertEquals(expected, parser.parse("1 * 1"));
    }
    
    /**
     * Test operation chain
     * 
     * @throws com.jouwee.commons.math.ParsingException
     */
    @Test
    public void testOperationChain() throws ParsingException {
        Expression expected;
        //
        expected = new Expression(new SumNode(new AbsoluteValueNode(1), new SumNode(new AbsoluteValueNode(2), new SumNode(new AbsoluteValueNode(3), new VariableNode("a")))));
        assertEquals(expected, parser.parse("1 + 2 + 3 + a"));
        //
        expected = new Expression(new SumNode(new MultiplicationNode(new VariableNode("a"), new AbsoluteValueNode(2)), new MultiplicationNode(new VariableNode("x"), new AbsoluteValueNode(3))));
        assertEquals(expected, parser.parse("a * 2 + x * 3"));
    }
    
    /**
     * Test invalid expressions
     */
    @Test
    public void testInvalidExpressions() {
        try {
            parser.parse("-");
            fail();
        } catch(ParsingException e) {}
        try {
            parser.parse("a -");
            fail();
        } catch(ParsingException e) {}
    }
    
}
