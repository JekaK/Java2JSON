package com.netcracker.courses.Lab00.Generator;

/**
 * Created by jeka on 31.10.16.
 */

/**
 * Class for generating massive of integers in custom variants
 *
 * @author Eugheniy Krukun
 * @version 1.0
 * @since 30.10.16
 */
public class MassGenerator {
    /**
     * Method for generating sorted massive of integers from 1 to length
     *
     * @param length a length of massive that must be generated
     * @return int[] Return generated sorted massive of integers from 1 to length
     */
    public int[] getSortedMass(int length) {
        int[] mass = new int[length];
        for (int i = 0; i < length; i++) {
            mass[i] = i + 1;
        }
        return mass;
    }

    /**
     * Method for generating sorted massive of integers from 1 to length - 1 with last random element from 1 to 10
     *
     * @param length a length of massive that must be generated
     * @return int[] Return generated sorted massive of integers from 1 to length -1 with last random element from 1 to 10
     */
    public int[] getSortedMassWithOneElement(int length) {
        int[] mass = new int[length + 1];
        for (int i = 0; i < length; i++) {
            mass[i] = i + 1;
        }
        mass[length] = 1 + (int) (Math.random() * (length - 1));
        return mass;
    }

    /**
     * Method for generating sorted massive of integers from length to 1
     *
     * @param length a length of massive that must be generated
     * @return int[] Return generated sorted massive of integers from length to 1
     */
    public int[] getReverseSortedMass(int length) {
        int[] mass = new int[length];
        for (int i = mass.length, j = 0; i > 0; i--, j++) {
            mass[j] = i;
        }
        return mass;
    }

    /**
     * Method for generating random massive array-long of length
     *
     * @param length a length of massive that must be generated
     * @return int[] Return random generated massive of integers from 1 to 10 and withs length from 1 to length
     */
    public int[] getRandomMass(int length) {
        int[] mass = new int[length];
        for (int i = 0; i < length; i++) {
            mass[i] = 1 + (int) (Math.random() * (length - 1));
        }
        return mass;
    }
}
