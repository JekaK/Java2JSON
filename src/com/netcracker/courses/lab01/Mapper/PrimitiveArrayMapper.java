package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class PrimitiveArrayMapper implements JsonMapper {

    public void writeByte(byte[] mass, JsonWriter writer) {

        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    public void writeShort(short[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    private void writeInt(int[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    public void writeDouble(double[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    public void writeLong(long[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    public void writeFloat(float[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            int counter = 0;
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeNumber(mass[i]);
                if (counter < mass.length - 1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        });
    }

    public void writeChar(char[] mass, JsonWriter writer) {
        writer.writeArrayPrimitive(() -> {
            writer.writeArrayBegin();
            for (int i = 0; i < mass.length; i++) {
                writer.writeString(String.valueOf(mass[i]));
                writer.writeSeparator();
            }
            writer.writeArrayEnd();
        });
    }

    @Override
    public void write(Object object, JsonWriter writer) {

        if (object instanceof byte[]) {
            writeByte((byte[]) object, writer);
            return;
        }
        if (object instanceof short[]) {
            writeShort((short[]) object, writer);
            return;
        }
        if (object instanceof int[]) {
            writeInt((int[]) object, writer);
            return;
        }
        if (object instanceof double[]) {
            writeDouble((double[]) object, writer);
            return;
        }
        if (object instanceof float[]) {
            writeFloat((float[]) object, writer);
            return;
        }
        if (object instanceof long[]) {
            writeLong((long[]) object, writer);
            return;
        }
        if (object instanceof char[]) {
            writeChar((char[]) object, writer);
        }
    }
}
