package com.netcracker.courses.Lab00.Sortings;

import com.netcracker.courses.Lab00.anotations.StartAnnotation;

/**
 * Created by jeka on 31.10.16.
 */

/**
 * Class for sorting massive of integers by Swap sort method
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @see <a href="http://citforum.ck.ua/programming/theory/sorting/sorting1.shtml#2_2">Swap sort</a>
 * @since 30.10.16
 */
public class SwapSort {

    /**
     * Method for sorting massive of integers by swap sort algorithm
     *
     * @param mass massive of integers that must be sorted
     * @return none
     */

    @StartAnnotation(startMethod = "swapSort")
    public long swapSort(int[] mass) {

        long start = System.nanoTime();
        for (int i = 1; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (mass[i] < mass[j]) {
                    int a = mass[i];
                    mass[i] = mass[j];
                    mass[j] = a;
                }
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
