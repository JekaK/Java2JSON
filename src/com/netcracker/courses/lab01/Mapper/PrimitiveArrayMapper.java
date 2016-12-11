package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Mapper.Interfaces.PrimitiveArrayJsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class PrimitiveArrayMapper implements PrimitiveArrayJsonMapper {


    @Override
    public void write(byte[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(short[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(int[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(double[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(long[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(float[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writePrimitive(mass[i]);
            }
        });
    }

    @Override
    public void write(char[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            for (int i = 0; i < mass.length; i++) {
                writer.writeCharacter(mass[i]);
            }
        });
    }
}
