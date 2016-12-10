package com.netcracker.courses.Lab00.Sortings;


import com.netcracker.courses.Lab00.anotations.StartAnnotation;

/**
 * Class for sorting massive of integers by Quick sort method
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @since 30.10.16
 */
public class QuickSort {
    /**
     * Method for sorting massive of integers by quick sort algorithm
     *
     * @param mass massive of integers that must be sorted
     */


    @StartAnnotation(startMethod = "quickSort")
    public long quickSort(int mass[]) {

        long start = System.nanoTime();
        doSort(mass, 0, mass.length - 1);
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Method for dividing on parts massive and then sort it. Using recursion for simplify code.<br>
     * If recursion is over, method is off
     *
     * @param mass  massive of integers that must be sort
     * @param left  integer value that meaning left index of parent massive (from be sorted)
     * @param right integer value that meaning right index of parent massive (to be sorted)
     * @return none
     */
    public void doSort(int mass[], int left, int right) {
        int index = partition(mass, left, right);
        if (left < index - 1)
            doSort(mass, left, index - 1);
        if (index < right)
            doSort(mass, index, right);
    }

    /**
     * Method for sorting part of massive. Using dividing massive of 2 parts and finding pivot
     * for better sorting
     *
     * @param mass  massive of integers that must be sort
     * @param left  index for multiplying with right index and finding pivot
     * @param right integer multiplying with left index and finding pivot
     * @return index index of element where left be placed
     */
    private int partition(int mass[], int left, int right) {
        int i = left, j = right;
        int a;
        int pivot = mass[(left + right) / 2];

        while (i <= j) {
            while (mass[i] < pivot)
                i++;
            while (mass[j] > pivot)
                j--;
            if (i <= j) {
                a = mass[i];
                mass[i] = mass[j];
                mass[j] = a;
                i++;
                j--;
            }
        }
        return i;
    }

}
