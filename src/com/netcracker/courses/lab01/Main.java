package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Mapper.ObjectArrayMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.io.StringWriter;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        ObjectArrayMapper arrayMapper = new ObjectArrayMapper();
        JsonWriter writer = new JsonWriter(new StringWriter());
        arrayMapper.write(new TestClass[]{new TestClass("2", 2.0), new TestClass("2", 2.0)}, writer);
        System.out.println(writer.getWriter().toString());
    }
}
