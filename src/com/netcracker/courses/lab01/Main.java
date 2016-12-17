package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Serializer.JsonSerializer;
import com.netcracker.courses.lab01.Writers.IndentedJsonWriter;

import java.io.StringWriter;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {

        IndentedJsonWriter writer = new IndentedJsonWriter(new StringWriter());
        new JsonSerializer().serialize(new TestClass[]{new TestClass("2", 3.3), new TestClass("3", 5.3)}, writer);
        System.out.println(writer.getWriter().toString());
    }
}
