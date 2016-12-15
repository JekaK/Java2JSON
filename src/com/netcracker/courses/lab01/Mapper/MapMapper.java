package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by jeka on 07.12.16.
 */
public class MapMapper implements JsonMapper {
    @Override
    public void write(Object object, JsonWriter writer) {
        if (object instanceof Map) {
            SimpleJsonObject simpleJsonObject = new SimpleJsonObject();
            writer.writeArrayBegin();
            for (Object entry : ((Map) object).entrySet()) {
                writer.writeString(((Entry) entry).getKey().toString());
                writer.writePropertySeparator();
                if (!(((Entry) entry).getValue() instanceof Number) && !(((Entry) entry).getValue() instanceof CharSequence)) {
                    writer.writeObjectBegin();
                    for (Object j : new Decompiler(((Entry) entry).getValue()).getList())
                        simpleJsonObject.createSimpleJsonObject(j, writer);
                    writer.writeObjectEnd();
                } else {
                    if (((Entry) entry).getValue() instanceof Number) {
                        writer.writeNumber((Number) ((Entry) entry).getValue());
                    } else {
                        writer.writeString(((Entry) entry).getValue().toString());
                    }
                }
                writer.writeSeparator();
            }
            writer.writeArrayEnd();
        }
    }
}
