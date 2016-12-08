package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Mapper.Interfaces.ArrayJsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class ObjectArrayMapper implements ArrayJsonMapper {

    @Override
    public void write(Object[] object, JsonWriter writer) {
        for (Object i : object) {
            writer.writeArrayObject(i);
        }
    }
}
