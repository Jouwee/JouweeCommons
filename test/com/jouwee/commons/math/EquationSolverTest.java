package com.jouwee.commons.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class Equation Solver
 * 
 * @author Nícolas Pohren
 */
public class EquationSolverTest {
    
    /** Delta for equations */
    public static final double DELTA = 0.00000001;
    /** Equation solver */
    private EquationSolver solver;
    /** Equation parser */
    private EquationParser parser;
    
    @Before
    public void setUp() {
        solver = new EquationSolver();
        parser = new EquationParser();
    }
    
    @Test
    public void testNullEquation() {
        assertEquals(0d, solver.solve(null, null), DELTA);
    }
    
    @Test
    public void testAbsoluteEquations() throws ParsingException  {
        assertEquals(1d, solver.solve(parser.parse("x=1"), "x"), DELTA);
        assertEquals(10d, solver.solve(parser.parse("x=10"), "x"), DELTA);
    }
    
    @Test
    public void testSimpleAddition() throws ParsingException  {
        assertEquals(6d, solver.solve(parser.parse("x=1 + 5"), "x"), DELTA);
    }
    
    @Test
    public void testSimpleSubtraction() throws ParsingException  {
        assertEquals(4d, solver.solve(parser.parse("x=6 - 2"), "x"), DELTA);
    }
    
    @Test
    public void testSimpleAdditionWithVariables() throws ParsingException  {
        solver.putVariable("y", 5);
        assertEquals(10d, solver.solve(parser.parse("x=y + 5"), "x"), DELTA);
    }
    
    @Test
    public void testSimpleUnisolated() throws ParsingException  {
        solver.putVariable("y", 3);
        assertEquals(7d, solver.solve(parser.parse("x + y=10"), "x"), DELTA);
    }
    
}
