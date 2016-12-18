package Lab00Tests;

import com.netcracker.courses.Lab00.Sortings.ArraysSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeka on 28.11.16.
 */
public class ArraysSortTest {

    private ArraysSort arraysSort;
    private int[] mass, mass1, mass2;

    private final static int SIZE = 10000;
    private final static int MAX = 20;

    @org.junit.Before
    public void setUp() throws Exception {
        arraysSort = new ArraysSort();
        mass = new int[SIZE];
        mass1 = Arrays.copyOf(mass, mass.length);
        mass2 = Arrays.copyOf(mass, mass.length);
        Random generator = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = generator.nextInt(MAX);
        }
        Arrays.sort(mass2);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @Test(timeout = 100000)
    public void timeOutTestArraysSort() throws Exception {
        arraysSort.standartArraysSort(mass1);
    }

    @org.junit.Test
    public void standardArraysSort() throws Exception {
        arraysSort.standartArraysSort(mass1);
        assertArrayEquals(mass1, mass2);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void nullTest() throws Exception {
        arraysSort.standartArraysSort(null);
    }
}