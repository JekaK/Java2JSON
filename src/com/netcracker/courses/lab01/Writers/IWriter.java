package com.netcracker.courses.lab01.Writers;

import java.io.Writer;

/**
 * Created by jeka on 02.12.16.
 */
public interface IWriter {

    public void writeObjectBegin();

    public void writeObjectEnd();

    public void writeArrayBegin();

    public void writeArrayEnd();

    public void writeString(String s);

    public void writeNumber(Number number);

    public void writeSeparator();

    public void writePropertySeparator();

    public void writeBoolean(boolean value);

    public void writeNull();

    public void flush();
    public Writer getWriter();
}
