package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Serializer.JsonSerializer;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 02.12.16.
 */
public class Main {


    public static void main(String[] args) {
        JsonWriter writer = new JsonWriter(new TestClass("sdf", 12.01));
        JsonSerializer serializer = new JsonSerializer(writer.createJson());
        serializer.toJson("file.out");
        StringBuilder builder = serializer.fromJson("file.out");
        System.out.println(builder);
    }
}
