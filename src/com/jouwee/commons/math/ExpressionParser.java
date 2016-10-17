package com.jouwee.commons.math;

import java.util.regex.Pattern;

/**
 * Expression parser
 * 
 * @author Nícolas Pohren
 */
public class ExpressionParser {

    /** Numeric pattern */
    private static final Pattern NUMERIC = Pattern.compile("\\-?\\d*?(,|\\.)?\\d+");
    /** End of file */
    private static final String EOF = "\uffff";
    /** Tokens */
    private String[] tokens;
    /** Current token */
    private int currentToken;
    
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
            tokens = tokenize(toParse);
            currentToken = 0;
            return new Expression(parseExpression());
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
     * Parses an expression
     * 
     * @return Expression
     */
    private ExpressionNode parseExpression() throws ParsingException {
        if (isTokenValue()) {
            ExpressionNode leftNode = parseValueOrPrecedingOperation();
            nextToken();
            if (isToken(EOF)) {
                return leftNode;
            }
            if (isTokenOperation()) {
                if (isToken("+")) {
                    nextToken();
                    return new SumNode(leftNode, parseExpression());
                }
                if (isToken("-")) {
                    nextToken();
                    return new DifferenceNode(leftNode, parseExpression());
                }
            }
        }
        throw new ParsingException("Value expected");
    }

    /**
     * Parses an value of a preceeding operation
     */
    private ExpressionNode parseValueOrPrecedingOperation() {
        ValueNode leftNode = parseValue();
        if (getToken(1).equals("*")) {
            nextToken();
            nextToken();
            return new MultiplicationNode(leftNode, parseValueOrPrecedingOperation());
        }
        return leftNode;
    }
    
    /**
     * Parse value node
     * 
     * @return ValueNode
     * @throws NumberFormatException 
     */
    private ValueNode parseValue() throws NumberFormatException {
        if (NUMERIC.matcher(getToken()).matches()) {
            return new AbsoluteValueNode(Double.parseDouble(getToken().replace(",", ".")));
        } else {
            return new VariableNode(getToken());
        }
    }

    /**
     * Go to the next token
     * 
     * @return String
     */
    private String nextToken() {
        currentToken++;
        return getToken();
    }
    
    /**
     * Checks if it mathces with the current token
     * 
     * @param token
     * @return boolean
     */
    private boolean isToken(String token) {
        return getToken().equals(token);
    }
    
    /**
     * Returns if the token is a value
     * 
     * @return boolean
     */
    private boolean isTokenValue() {
        return !isTokenOperation() && !isToken(EOF);
    }
    
    /**
     * Returns if the token is a operation
     * 
     * @return boolean
     */
    private boolean isTokenOperation() {
        return isToken("+") || isToken("-") || isToken("*");
    }
    
    /**
     * Returns the token
     * 
     * @return String
     */
    private String getToken() {
        return getToken(0);
    }
    
    /**
     * Returns the token
     * 
     * @return String
     */
    private String getToken(int lookahead) {
        if (currentToken + lookahead >= tokens.length) {
            return EOF;
        }
        return tokens[currentToken + lookahead];
    }

    
}
