package com.netcracker.courses.lab01.Mapper.Interfaces;

import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 08.12.16.
 */
public interface JsonMapper<T> {
    void write(T object, JsonWriter writer);
}
