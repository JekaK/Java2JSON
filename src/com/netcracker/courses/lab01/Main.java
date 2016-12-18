package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Serializer.JsonSerializer;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        JsonWriter writer = new JsonWriter(new StringWriter());
        List list = new ArrayList();
        list.add(new TestClass("test",2.0));

        long start,end,result;
        start = System.nanoTime();
        new JsonSerializer().serialize(list, writer);
        end = System.nanoTime();
        result = end - start;
        System.out.println((double)result / 1000000000.0);
        System.out.println(writer.getWriter().toString());
    }
}
