package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Mapper.MapMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        MapMapper arrayMapper = new MapMapper();
        JsonWriter writer = new JsonWriter(new StringWriter());
        Map<String, TestClass> map = new HashMap<>();
        map.put("test1", new TestClass("sdfsd", 1.2));
        map.put("test2", new TestClass("sdfsd", 1.2));

        arrayMapper.write(map, writer);
        System.out.println(writer.getWriter().toString());
    }
}
