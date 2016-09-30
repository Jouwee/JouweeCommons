package com.jouwee.commons.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ExpressionSolver test
 * 
 * @author Nícolas Pohren
 */
public class ExpressionSolverTest {

    /** Delta for equations */
    public static final double DELTA = 0.00000001;
    /** Expression solver */
    private ExpressionSolver solver;
    /** Expression parser */
    private ExpressionParser parser;
    
    @Before
    public void setUp() {
        solver = new ExpressionSolver();
        parser = new ExpressionParser();
    }
    
    @Test
    public void testNullExpression() {
        assertEquals(0, solver.solve((Expression)null), DELTA);
    }
    
    @Test
    public void testAbsoluteExpressions() {
        assertEquals(1, solver.solve(parser.parse("1")), DELTA);
        assertEquals(10, solver.solve(parser.parse("10")), DELTA);
    }
    
    @Test
    public void testAdditions() {
        assertEquals(2, solver.solve(parser.parse("1 + 1")), DELTA);
        assertEquals(15, solver.solve(parser.parse("10 + 5")), DELTA);
    }
    
}
