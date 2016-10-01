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
        return new Equation(expressionParser.parse(parts[0]).getNode(), expressionParser.parse(parts[2]).getNode(), getEquality(parts[1]));
    }

    /**
     * Split the parts of the equation
     * 
     * @param toParse
     * @return String[]
     */
    private String[] split(String toParse) {
        if (toParse.contains("<=")) {
            String normalized = toParse.replace(" <= ", "<=");
            return new String[] {normalized.split("<=")[0], "<=", normalized.split("<=")[1]};
        } else if (toParse.contains(">=")) {
            String normalized = toParse.replace(" >= ", ">=");
            return new String[] {normalized.split(">=")[0], ">=", normalized.split(">=")[1]};
        } else {
            String normalized = toParse.replace(" = ", "=");
            return new String[] {normalized.split("=")[0], "=", normalized.split("=")[1]};
        }
    }
    
    /**
     * Returns the equality
     * 
     * @param equality
     * @return EquationType
     */
    private EquationType getEquality(String equality) {
        switch (equality) {
            case "=":
                return EquationType.EQUALS_TO;
            case ">=":
                return EquationType.GREATER_THAN_OR_EQUALS_TO;
            default:
                return EquationType.LESSER_THAN_OR_EQUALS_TO;
        }
    }

}
