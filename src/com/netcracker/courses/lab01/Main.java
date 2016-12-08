package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Mapper.Interfaces.ArrayJsonMapper;
import com.netcracker.courses.lab01.Mapper.ObjectArrayMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        ArrayJsonMapper arrayMapper = new ObjectArrayMapper();
        JsonWriter writer = new JsonWriter();
        arrayMapper.write(new Object[]{new TestClass("asd", 2.0)}, writer);
        System.out.println(writer.getWritableBuilder());
    }
}
