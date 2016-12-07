package com.netcracker.courses.lab01.Mapper;

import jdk.nashorn.internal.ir.debug.JSONWriter;

/**
 * Created by jeka on 07.12.16.
 */
public abstract class JsonMapper<T> {
    public abstract void write(T object, JSONWriter writer);
}
