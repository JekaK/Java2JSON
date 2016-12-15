package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.Collection;

/**
 * Created by jeka on 07.12.16.
 */
public class CollectionMapper implements JsonMapper {
    @Override
    public void write(Object object, JsonWriter writer) {
        if (object instanceof Collection) {
            writer.writeArrayBegin();
            for (Object i : (Collection) object) {
                writeCollection(i, writer);
            }
            writer.writeArrayEnd();
        }
    }

    private void writeCollection(Object object, JsonWriter writer) {
        writer.writeObjectBegin();
        SimpleJsonObject jsonObject;
        jsonObject = new SimpleJsonObject();
        for (Object j : new Decompiler(object).getList()) jsonObject.createSimpleJsonObject(j, writer);
        writer.writeObjectEnd();
        writer.writeSeparator();
    }
}
