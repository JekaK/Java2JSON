package com.netcracker.courses.Lab00;

import com.netcracker.courses.Lab00.ChartBuilder.ChartBuilder;
import com.netcracker.courses.Lab00.Generator.MassGenerator;
import com.netcracker.courses.Lab00.Invoker.Invoker;
import com.netcracker.courses.Lab00.Sortings.*;

import java.io.IOException;

/**
 * Created by jeka on 30.10.16.
 */

public class Main {

    public static void main(String[] args) {
        Class cls[] = new Class[]{ArraysSort.class, BubbleSort.class, MergeSort.class, QuickSort.class, SwapSort.class};
        String[] names = new String[]{"ArraysSort", "BubbleSort", "MergeSort", "QuickSort", "SwapSort"};
        int mass[];
        long results[] = new long[cls.length];
        for (int i = 0; i < cls.length; i++) {
            mass = new MassGenerator().getRandomMass(1000);
            results[i] = Invoker.arraySortInvoker(cls[i], mass);
        }
        ChartBuilder builder = ChartBuilder.newBuilder()
                .withNames(names)
                .withResults(results)
                .build();
        try {
            builder.generateChart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMass(int[] mass) {
        for (Integer i : mass) {
            System.out.println(i);
        }
    }
}
