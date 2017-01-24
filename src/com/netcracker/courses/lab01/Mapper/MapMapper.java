package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by jeka on 07.12.16.
 */
public class MapMapper implements JsonMapper<Map> {
    @Override
    public void write(Map object, JsonWriter writer) {
        if (object != null) {
            SimpleJsonObject simpleJsonObject = new SimpleJsonObject();
            int counter1 = 0, counter2 = 0;
            writer.writeArrayBegin();
            for (Object entry : (object).entrySet()) {
                writer.writeString(((Entry) entry).getKey().toString());
                writer.writePropertySeparator();
                if (!(((Entry) entry).getValue() instanceof Number) && !(((Entry) entry).getValue() instanceof CharSequence)) {
                    writer.writeObjectBegin();
                    List l = new Decompiler(((Entry) entry).getValue()).getList();
                    for (Object j : l) {
                        simpleJsonObject.createSimpleJsonObject(j, writer);
                        if (counter2 < l.size() - 1) {
                            writer.writeSeparator();
                            counter2++;
                        }
                    }
                    counter2 = 0;
                    writer.writeObjectEnd();
                } else {
                    if (((Entry) entry).getValue() instanceof Number) {
                        writer.writeNumber((Number) ((Entry) entry).getValue());
                    } else {
                        writer.writeString(((Entry) entry).getValue().toString());
                    }
                }
                if (counter1 < (object).entrySet().size() - 1) {
                    writer.writeSeparator();
                    counter1++;
                }
                counter1 = 0;
            }
            writer.writeArrayEnd();
        }
    }
}
