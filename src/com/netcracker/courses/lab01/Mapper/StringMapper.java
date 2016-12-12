package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class StringMapper implements JsonMapper {
    @Override
    public void write(Object object, JsonWriter writer) {
        writer.writeObjectBegin();
        writer.writeString(String.valueOf(object));
        writer.writeObjectEnd();
    }
}
