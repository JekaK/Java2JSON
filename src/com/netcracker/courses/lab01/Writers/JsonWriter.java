package com.netcracker.courses.lab01.Writers;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by jeka on 02.12.16.
 */
public class JsonWriter implements IWriter {

    private Writer writer;


    public JsonWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Writer getWriter() {
        return writer;
    }

    @Override
    public void writeObjectBegin() {
        try {
            writer.write("{");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectEnd() {
        if (writer.toString().length() >= 1 && writer.toString().charAt(writer.toString().length() - 1) == ',') {
            deleteChar();
        }
        try {
            writer.append("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeArrayBegin() {
        try {
            writer.append("[");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteChar() {
        StringBuilder value = new StringBuilder(writer.toString());
        value.deleteCharAt(value.length() - 1);
        try {
            writer = new StringWriter();
            writer.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeArrayEnd() {
        if (writer.toString().length()>=1&&writer.toString().charAt(writer.toString().length() - 1) == ',') {
            deleteChar();
        }
        try {
            writer.append("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeString(String s) {
        try {
            writer.append("\'");
            writer.append(s);
            writer.append("\'");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeNumber(Number number) {
        try {
            writer.append(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeSeparator() {
        try {
            writer.append(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writePropertySeparator() {
        try {
            writer.append(":");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeBoolean(boolean value) {
        try {
            writer.append(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeNull() {
        try {
            writer.append("null");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {
        try {
            writer.flush();
            writer = new StringWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeArrayPrimitive(PrimitiveWriter primitiveWriter) {
        primitiveWriter.writeArray();
    }

    public interface PrimitiveWriter {
        void writeArray();
    }
}
