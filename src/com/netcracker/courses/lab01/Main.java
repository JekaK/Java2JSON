package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Serializer.JsonSerializer;
import com.netcracker.courses.lab01.Writers.IndentedJsonWriter;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        IndentedJsonWriter writer = new IndentedJsonWriter(new StringWriter());
        Map map = new HashMap();
        new JsonSerializer().serialize(map, writer);
        System.out.println(writer.getWriter());
    }
}