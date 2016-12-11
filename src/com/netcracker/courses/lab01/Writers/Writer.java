package com.netcracker.courses.lab01.Writers;

/**
 * Created by jeka on 03.12.16.
 */
public class Writer implements IWriter {

    private StringBuilder string;

    public Writer() {
    }

    public Writer(StringBuilder string) {
        this.string = string;
    }

    @Override
    public StringBuilder getValue() {
        return string;
    }

    @Override
    public void setValue(StringBuilder value) {
        this.string = value;
    }

    @Override
    public void writeObjectBegin() {
        string.append("{");
    }

    @Override
    public void writeObjectEnd() {
        if (string.toString().charAt(string.length() - 1) == ',') {
            string.deleteCharAt(string.length() - 1);
        }
        string.append("}");
    }

    @Override
    public void writeArrayBegin() {
        string.append("[");
    }

    @Override
    public void writeArrayEnd() {
        if (string.toString().charAt(string.length() - 1) == ',') {
            string.deleteCharAt(string.length() - 1);
        }
        string.append("]");
    }

    @Override
    public void writeString(String s) {
        string.append("\'");
        string.append(s);
        string.append("\'");
    }

    @Override
    public void writeNumber(Number number) {
        string.append(number);
    }

    @Override
    public void writeSeparator() {
        string.append(",");
    }

    @Override
    public void writePropertySeparator() {
        string.append(":");
    }

    @Override
    public void writeBoolean(boolean value) {
        string.append(value);
    }

    @Override
    public void writeNull() {
        string.append("null");
    }

    @Override
    public void flush() {
        string = new StringBuilder();
    }

    @Override
    public void showString() {
        System.out.println(string);
    }
}
