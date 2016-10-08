package com.jouwee.commons.test;

import java.util.ArrayList;
import org.junit.Assert;
import java.util.List;

/**
 * Asserter of collections
 * 
 * @author Jouwee
 */
public class CollectionsAsserter {
    
    /**
     * Asserts two collections
     * 
     * @param <T>
     * @param expected
     * @param result 
     */
    public <T> void assertEquals(List<T> expected, List<T> result) {
        Assert.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
        }
    }

    /**
     * Asserts two collections
     * 
     * @param <T>
     * @param expected
     * @param result 
     */
    public <T> void assertEquals(T[] expected, List<T> result) {
        List<T> lExpected = new ArrayList<>();
        for (T item : expected) {
            lExpected.add(item);
        }
        assertEquals(lExpected, result);
    }
    
}
