package com.jouwee.commons.chart;

import com.jouwee.commons.math.ExpressionSolver;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

/**
 * Cartesian plane
 *
 * @author Jouwee
 */
public class CartesianPlane extends BorderPane {

    /** Function rendering beans */
    private final List<FunctionRenderingBean> functionRenderingBeans;
    /** Function solver */
    private ExpressionSolver functionSolver;
    /** Line chart */
    private LineChart<Number, Number> lineChart;

    /**
     * Creates a new cartesian plane
     */
    public CartesianPlane() {
        super();
        functionRenderingBeans = new ArrayList<>();
        functionSolver = new ExpressionSolver();
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");
        rebuildSeries();
        setCenter(lineChart);
    }

    /**
     * Adds a function rendering bean
     *
     * @param functionBean
     */
    public void add(FunctionRenderingBean functionBean) {
        functionRenderingBeans.add(functionBean);
        rebuildSeries();
    }

    /**
     * Rebuild all series
     */
    private void rebuildSeries() {
        lineChart.getData().clear();
        for (FunctionRenderingBean bean : functionRenderingBeans) {
            XYChart.Series series = new XYChart.Series();
            series.setName(bean.toString());
            for (double i = getMinimumX(); i <= getMaximumX(); i++) {
                functionSolver.putVariable("a", i);
                series.getData().add(new XYChart.Data(i, functionSolver.solve(bean.getFunction())));
            }
            lineChart.getData().add(series);

        }

    }

    /**
     * Returns the minimum X
     *
     * @return double
     */
    public double getMinimumX() {
        return 0;
    }

    /**
     * Returns the maximum X
     *
     * @return double
     */
    public double getMaximumX() {
        return 10;
    }

    /**
     * Returns the function solver
     *
     * @return FunctionSolver
     */
    public ExpressionSolver getFunctionSolver() {
        return functionSolver;
    }

    /**
     * Sets the function solver
     *
     * @param functionSolver
     */
    public void setFunctionSolver(ExpressionSolver functionSolver) {
        this.functionSolver = functionSolver;
    }

}
