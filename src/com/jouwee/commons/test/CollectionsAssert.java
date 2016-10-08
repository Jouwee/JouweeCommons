package com.jouwee.commons.test;

import java.util.List;

/**
 * Methods for asserting collections
 * 
 * @author Jouwee
 */
public class CollectionsAssert {

    /**
     * Asserts two collections
     * 
     * @param <T>
     * @param expected
     * @param result 
     */
    public static <T> void assertEquals(List<T> expected, List<T> result) {
        new CollectionsAsserter().assertEquals(expected, result);
    }

    /**
     * Asserts two collections
     * 
     * @param <T>
     * @param expected
     * @param result 
     */
    public static <T> void assertEquals(T[] expected, List<T> result) {
        new CollectionsAsserter().assertEquals(expected, result);
    }

}
