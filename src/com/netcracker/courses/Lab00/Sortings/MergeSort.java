package com.netcracker.courses.Lab00.Sortings;

import com.netcracker.courses.Lab00.anotations.StartAnnotation;

/**
 * Created by jeka on 31.10.16.
 */

/**
 * Class for sorting massive of integers by Merge sort method
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D1%81%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5%D0%BC">Merge sort</a>
 * @since 30.10.16
 */
public class MergeSort {
    /**
     * Method for merge sorting algorithm implementation in recursive variant
     *
     * @param mass massive of integers that must be sorted
     * @return massive of sorted integers if recursion is over or recursively going down
     * {@code
     * if (len < 2) return mass;
     * int middle = len / 2;
     * return merge(mergeSortRecursive(Arrays.copyOfRange(mass, 0, middle)),
     * mergeSortRecursive(Arrays.copyOfRange(mass, middle, len)));}
     */
    private int[] numbers;
    private int[] helper;

    private int number;


    @StartAnnotation(startMethod = "mergeSortRecursive")
    public long mergeSortRecursive(int[] mass) {

        long start = System.nanoTime();
        mergeRecursive(mass, 0, mass.length - 1);
        long end = System.nanoTime();
        return end - start;
    }

    private void mergeRecursive(int[] numbers, int left, int right) {
        int mid;

        if (right > left) {
            mid = (right + left) / 2;
            mergeRecursive(numbers, left, mid);
            mergeRecursive(numbers, (mid + 1), right);

            merge(numbers, left, (mid + 1), right);
        }
    }


    /**
     * Method for merge sorting algorithm implementation in non-recursive variant
     *
     * @param values massive of integers that must be sorted
     * @return massive of sorted integers if recursion is over or recursively going down
     */
    @StartAnnotation(startMethod = "mergeSortNotRecursive")
    public long sortNotRecursive(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];

        long start = System.nanoTime();
        mergesort(0, number - 1);
        long end = System.nanoTime();
        return end - start;
    }

    private void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }


    }

    private static void merge(int[] numbers, int left, int mid, int right) {
        int[] temp = new int[numbers.length];
        int i, left_end, num_elements, tmp_pos;

        left_end = (mid - 1);
        tmp_pos = left;
        num_elements = (right - left + 1);

        while ((left <= left_end) && (mid <= right)) {
            if (numbers[left] <= numbers[mid])
                temp[tmp_pos++] = numbers[left++];
            else
                temp[tmp_pos++] = numbers[mid++];
        }

        while (left <= left_end)
            temp[tmp_pos++] = numbers[left++];

        while (mid <= right)
            temp[tmp_pos++] = numbers[mid++];

        for (i = 0; i < num_elements; i++) {
            numbers[right] = temp[right];
            right--;
        }
    }
}
