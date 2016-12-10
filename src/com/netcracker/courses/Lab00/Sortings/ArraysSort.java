package com.netcracker.courses.Lab00.Sortings;

import com.netcracker.courses.Lab00.anotations.StartAnnotation;

import java.util.Arrays;

/**
 * Created by jeka on 31.10.16.
 */

/**
 * Class that gives method for sorting arrays in standard method invoke
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @since 30.10.16
 */
public class ArraysSort {


    /**
     * Standard array sort method invoker for sorting massive
     *
     * @param mass a massive of Integer values that must be sorted
     * @return none
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html">Arrays</a>
     */
    @StartAnnotation(startMethod = "standartArraysSort")
    public long standartArraysSort(int[] mass) {

        long startTime = System.nanoTime();
        Arrays.sort(mass);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        return duration;
    }
}
