package com.netcracker.courses.lab01.Mapper.Interfaces;

import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 11.12.16.
 */
public interface PrimitiveArrayJsonMapper extends Mapper {
    void write(byte[] mass, JsonWriter writer);

    void write(short[] mass, JsonWriter writer);

    void write(int[] mass, JsonWriter writer);

    void write(double[] mass, JsonWriter writer);

    void write(long[] mass, JsonWriter writer);

    void write(float[] mass, JsonWriter writer);

    void write(char[] mass, JsonWriter writer);
}
