package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Mapper.MapMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {
    public static void main(String[] args) {
        MapMapper arrayMapper = new MapMapper();
        JsonWriter writer = new JsonWriter(new StringWriter());
        Map<String, List> map = new HashMap<>();
        ArrayList list = new ArrayList();
        list.add(new TestClass("sdfsd", 1.2));
        map.put("test1", list);
        map.put("test2", list);
        arrayMapper.write(map, writer);
        System.out.println(writer.getWriter().toString());
    }
}
