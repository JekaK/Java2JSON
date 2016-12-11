

import com.netcracker.courses.Lab00.Sortings.MergeSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeka on 28.11.16.
 */
public class MergeSortTest {

    private MergeSort mergeSort;
    private int[] mass, mass1, mass2;


    private final static int SIZE = 10000;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {

        mergeSort = new MergeSort();
        mass = new int[SIZE];
        mass1 = Arrays.copyOf(mass, mass.length);
        mass2 = Arrays.copyOf(mass, mass.length);
        Random generator = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = generator.nextInt(MAX);
        }
        Arrays.sort(mass2);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void mergeSortRecursive() throws Exception {
        mergeSort.mergeSortRecursive(mass1);
        assertArrayEquals(mass1, mass2);
    }

    @Test(timeout = 100000)
    public void timeOutTestRecursive() throws Exception {
        mergeSort.mergeSortRecursive(mass1);
    }

    @Test(timeout = 100000)
    public void timeOutTestNotRecursive() throws Exception {
        mergeSort.sortNotRecursive(mass1);
    }

    @Test
    public void mergeSortNotRecursive() throws Exception {
        mergeSort.sortNotRecursive(mass1);
        assertArrayEquals(mass1, mass2);
    }

}