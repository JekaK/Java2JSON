package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.ArrayJsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class ObjectArrayMapper implements ArrayJsonMapper {

    @Override
    public void write(Object[] object, JsonWriter writer) {
        writer.writeArrayBegin();
        for (Object i : object) {
            writeArrayObject(i, writer);
        }
        writer.writeArrayEnd();
    }

    private void writeArrayObject(Object object, JsonWriter writer) {
        writer.writeObjectBegin();
        SimpleJsonObject jsonObject = new SimpleJsonObject();
        for (Object j : new Decompiler(object).getList()) jsonObject.createSimpleJsonObject(j, writer);
        writer.writeObjectEnd();
        writer.writeSeparator();
    }
}
