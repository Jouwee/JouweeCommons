package com.jouwee.commons.math;

/**
 * Equation parser
 * 
 * @author Nícolas Pohren
 */
public class EquationParser {

    /** Expression parser */
    private final ExpressionParser expressionParser;

    /**
     * Creates a new equation parser
     */
    public EquationParser() {
        this.expressionParser = new ExpressionParser();
    }
    
    /**
     * Parses a equation
     * 
     * @param toParse
     * @return Equation
     */
    public Equation parse(String toParse) {
        if (toParse == null) {
            return null;
        }
        String[] parts = split(toParse);
        return new Equation(expressionParser.parse(parts[0]), expressionParser.parse(parts[2]), getEquality(parts[1]));
    }

    /**
     * Split the parts of the equation
     * 
     * @param toParse
     * @return String[]
     */
    private String[] split(String toParse) {
        return new String[] {toParse.split("=")[0], "=", toParse.split("=")[1]};
    }
    
    /**
     * Returns the equality
     * 
     * @param equality
     * @return EquationType
     */
    private EquationType getEquality(String equality) {
        return EquationType.EQUALS_TO;
    }

}
