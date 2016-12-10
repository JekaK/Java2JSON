package com.netcracker.courses.Lab00.Sortings;

/**
 * Created by jeka on 30.10.16.
 */

import com.netcracker.courses.Lab00.anotations.StartAnnotation;

/**
 * Class for bubble sorting arrays
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @see <a href = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC">Bubble sort</a>
 * @since 30.10.16
 */
public class BubbleSort {

    /**
     * Method for bubble sorting with "Up" element
     *
     * @param mass massive of integer that must be sorted
     * @return none
     */
    @StartAnnotation(startMethod = "bubbleSortUp")
    public long bubbleSortUp(int[] mass) {

        long start = System.nanoTime();
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 1; j < mass.length - i; j++) {
                if (mass[j] < mass[j - 1]) {
                    int a = mass[j - 1];
                    mass[j - 1] = mass[j];
                    mass[j] = a;
                }
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Method for bubble sorting with "Down" element
     *
     * @param mass massive of integer that must be sorted
     * @return none
     */
    @StartAnnotation(startMethod = "bubbleSortDown")
    public long bubbleSortDown(int[] mass) {

        long start = System.nanoTime();
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = 1; j < mass.length - i; j++) {
                if (mass[j] > mass[j - 1]) {
                    int a = mass[j - 1];
                    mass[j - 1] = mass[j];
                    mass[j] = a;
                }
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
