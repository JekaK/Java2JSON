package com.netcracker.courses.lab01.Serializer;

import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.util.Map;

/**
 * Created by jeka on 05.12.16.
 */
public class JsonSerializer {

    private Map<Class, JsonMapper> mappersCache;

    public JsonSerializer() {
        //TODO:add in list mappers
    }

    public void serialize(Object object, JSONWriter writer) {
        //TODO:add method body
    }

    public JsonMapper getMapper(Class cls) {
        JsonMapper mapper = mappersCache.get(cls);
        if (mapper == null) {
            mapper = new JsonMapper() {
                @Override
                public void write(Object object, JsonWriter writer) {
                    //TODO:add method body
                }
            };
        }
        return mapper;
    }
/*
    public StringBuilder fromJson(String fileName) {
        builder = new StringBuilder();
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(fileIn);
            builder = (StringBuilder) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert in != null;
            in.close();
            assert fileIn != null;
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    public void toJson(String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(builder);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
