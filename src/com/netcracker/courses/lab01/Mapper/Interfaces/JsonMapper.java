package com.netcracker.courses.lab01.Mapper.Interfaces;

import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public interface JsonMapper extends Mapper {
    public void write(Object object, JsonWriter writer);
}
