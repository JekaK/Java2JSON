package Lab00Tests;

import com.netcracker.courses.Lab00.Sortings.QuickSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeka on 28.11.16.
 */
public class QuickSortTest {
    private QuickSort quickSort;
    private int[] mass, mass1, mass2;

    private final static int SIZE = 100;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        quickSort = new QuickSort();
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

    @Test(timeout = 10)
    public void timeOutTestQuickSort() throws Exception {
        quickSort.quickSort(mass1);
    }

    @Test
    public void quickSort() throws Exception {
        quickSort.quickSort(mass1);
        assertArrayEquals(mass1, mass2);
    }

}