package com.jouwee.commons.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uk.ac.ed.ph.jacomax.JacomaxPropertiesConfigurator;
import uk.ac.ed.ph.jacomax.MaximaConfiguration;
import uk.ac.ed.ph.jacomax.MaximaInteractiveProcess;
import uk.ac.ed.ph.jacomax.MaximaProcessLauncher;

/**
 * Equation isolator using Maxima
 *
 * @author Nícolas Pohren
 */
public class MaximaEquationVariableIsolator implements EquationVariableIsolator {

    /** Output pattern */
    private static final Pattern OUTPUT = Pattern.compile("\\(\\%o1\\)\\s+\\[(.*)\\].*");
    /** Equation parser */
    private final EquationParser parser;

    /**
     * Creates the isolator
     */
    public MaximaEquationVariableIsolator() {
        this.parser = new EquationParser();
    }
    
    @Override
    public Equation isolate(Equation equation, String variable) {
        if (equation == null) {
            return null;
        }
        try {
            MaximaConfiguration configuration = new JacomaxPropertiesConfigurator(MaximaEquationVariableIsolator.class.getResourceAsStream("jacomax.properties")).configure();
            MaximaProcessLauncher launcher = new MaximaProcessLauncher(configuration);
            MaximaInteractiveProcess process = launcher.launchInteractiveProcess();
            String result = process.executeCall("solve([" + equation.toComputerString() + "], [x]);");
            Matcher matcher = OUTPUT.matcher(result);
            matcher.find();
            process.terminate();
            return parser.parse(matcher.group(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
