package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.List;

/**
 * Created by jeka on 07.12.16.
 */
public class ObjectArrayMapper implements JsonMapper<Object[]> {

    @Override
    public void write(Object[] object, JsonWriter writer) {
        writer.writeArrayBegin();
        for (Object i : object) {
            writeArrayObject(i, writer);
            writer.writeSeparator();
        }
        writer.writeArrayEnd();
    }

    private void writeArrayObject(Object object, JsonWriter writer) {
        SimpleJsonObject jsonObject = new SimpleJsonObject();
        List list = new Decompiler(object).getList();
        int counter = 0;
        writeList(list, jsonObject, counter, writer);
        if (object instanceof Number || object instanceof CharSequence) {
            writeList(list, jsonObject, counter, writer);
        } else {
            writer.writeObjectBegin();
            writeList(list, jsonObject, counter, writer);
            writer.writeObjectEnd();
        }
    }

    public void writeList(List list, SimpleJsonObject jsonObject, int counter, JsonWriter writer) {
        for (Object j : list) {
            jsonObject.createSimpleJsonObject(j, writer);
            if (counter < list.size() - 1) {
                writer.writeSeparator();
                counter++;
            }
        }
    }
}
