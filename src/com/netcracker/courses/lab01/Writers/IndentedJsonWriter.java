package com.netcracker.courses.lab01.Writers;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by jeka on 18.12.16.
 */
public class IndentedJsonWriter extends JsonWriter {
    private int deep;

    public IndentedJsonWriter(Writer writer) {
        super(writer);
        deep = 0;
    }

    public int getDeep() {
        return deep;
    }

    private void writeTabCount() {
        try {
            getWriter().write("\n");
            for (int i = 0; i < deep; i++) {
                getWriter().write("\t");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeObjectBegin() {
        super.writeObjectBegin();
        deep++;
        writeTabCount();

    }

    @Override
    public void writeObjectEnd() {
        deep--;
        writeTabCount();
        super.writeObjectEnd();
    }

    @Override
    public void writeArrayBegin() {
        super.writeArrayBegin();
        deep++;
        writeTabCount();
    }

    @Override
    public void writeArrayEnd() {
        deep--;
        writeTabCount();
        super.writeArrayEnd();
    }

    @Override
    public void writeSeparator() {
        super.writeSeparator();

        writeTabCount();
    }
}
