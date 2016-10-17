package com.jouwee.commons.math;

import java.util.regex.Pattern;

/**
 * Expression parser
 * 
 * @author Nícolas Pohren
 */
public class ExpressionParser {

    /** Numeric pattern */
    private static final Pattern NUMERIC = Pattern.compile("\\-?\\d+");
    
    /**
     * Parses a Expression
     * 
     * @param toParse
     * @return Expression
     * @throws com.jouwee.commons.math.ParsingException
     */
    public Expression parse(String toParse) throws ParsingException {
        if (toParse == null) {
            return null;
        }
        try {
            String[] tokens = tokenize(toParse);
            return new Expression(parse(tokens, 0));
        } catch (Exception e) {
            throw new ParsingException(e);
        }
    }

    /**
     * Tokenize the string
     * 
     * @param toParse
     * @return String[]
     */
    private String[] tokenize(String toParse) {
        return toParse.split(" ");
    }

    /**
     * Parses tokens
     * 
     * @param tokens
     * @param i
     * @return Expression
     */
    private ExpressionNode parse(String[] tokens, int i) {
        ValueNode leftNode = parseValue(tokens, i);
        if (tokens.length - 1 > i) {
            ExpressionNode rightNode = parse(tokens, i + 2);
            return parseOperation(tokens, i + 1, leftNode, rightNode);
        }
        return leftNode;
    }

    /**
     * Parse value node
     * 
     * @param tokens
     * @param i
     * @return ValueNode
     * @throws NumberFormatException 
     */
    private ValueNode parseValue(String[] tokens, int i) throws NumberFormatException {
        if (NUMERIC.matcher(tokens[i]).matches()) {
            return new AbsoluteValueNode(Integer.parseInt(tokens[i]));
        } else {
            return new VariableNode(tokens[i]);
        }
    }

    /**
     * Parse an operation
     * 
     * @param tokens
     * @param i
     * @param leftNode
     * @param rightNode
     * @return ExpressionNode
     */
    private ExpressionNode parseOperation(String[] tokens, int i, ValueNode leftNode, ExpressionNode rightNode) {
        if (tokens[i].equals("+")) {
            return new SumNode(leftNode, rightNode);
        } else if (tokens[i].equals("-")) {
            return new DifferenceNode(leftNode, rightNode);
        } else {
            return new MultiplicationNode(leftNode, rightNode);
        }
    }

    
}
