package com.jouwee.commons.math;

/**
 * Equation variable isolator
 * 
 * @author Nícolas Pohren
 */
public class JavaEquationVariableIsolator implements EquationVariableIsolator {

    @Override
    public Equation isolate(Equation equation, String variable) {
        if (equation == null) {
            return null;
        }
        Equation clone = deepClone(equation);
        clone = isolateInReference(clone, new VariableNode(variable));
        return clone;
    }
    
/**
     * Isolates an variable in the equation
     * 
     * @param equation
     * @param variable
     * @return 
     */
    private Equation isolateInReference(Equation equation, VariableNode variable) {
        while (!equation.getLeftFunction().equals(variable)) {
            equation = tryToIsolate(equation, variable);
        }
        return equation;
    }
    
    /**
     * Try to isolate
     * 
     * @param equation 
     * @param variable 
     * @return Equation
     */
    public Equation tryToIsolate(Equation equation, VariableNode variable) {
        if (equation.getRightFunction().equals(variable)) {
            ExpressionNode swap = equation.getLeftFunction();
            return new Equation(equation.getRightFunction(), swap, equation.getType());
        }
        if (equation.getLeftFunction() instanceof SumNode) {
            if (equation.getRightFunction() instanceof ValueNode) {
                SumNode sum = (SumNode) equation.getLeftFunction();
                ValueNode toChange;
                if (sum.getLeftOperant().equals(variable)) {
                    toChange = (ValueNode) sum.getRightOperant();
                } else {
                    toChange = (ValueNode) sum.getLeftOperant();
                }
                return new Equation(variable, new DifferenceNode((ValueNode) equation.getRightFunction(), toChange), equation.getType());
            }
        }
        
        return equation;
    }

    /**
     * Deep clones an equation
     * 
     * @param equation
     * @return Equation
     */
    private Equation deepClone(Equation equation) {
        return new Equation(deepClone(equation.getLeftFunction()), deepClone(equation.getRightFunction()), equation.getType());
    }

    /**
     * Deep clones an expression
     * 
     * @param expression
     * @return Expression
     */
    private Expression deepClone(Expression expression) {
        return new Expression(deepClone(expression.getNode()));
    }

    /**
     * Deep clones a node
     * 
     * @param node
     * @return node
     */
    private ExpressionNode deepClone(ExpressionNode node) {
        return node.deepClone();
    }
    
}
