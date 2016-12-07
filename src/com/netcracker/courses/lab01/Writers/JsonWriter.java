package com.netcracker.courses.lab01.Writers;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.CustomPair.Pair;

import java.util.List;

/**
 * Created by jeka on 02.12.16.
 */
public class JsonWriter {

    private Writer writer;
    private Decompiler decompiler;

    public JsonWriter() {
        writer = new Writer();
    }

    public JsonWriter(Object object) {
        writer = new Writer();
        this.decompiler = new Decompiler(object);
    }

    public Decompiler getObject() {
        return decompiler;
    }

    public void setObject(Decompiler object) {
        this.decompiler.setObject(object);
    }

    public StringBuilder createJson() {
        List<Object> list = decompiler.getList();
        StringBuilder result = new StringBuilder();
        for (Object i : list) {
            result.append(createObjectJson(i));
        }
        return result;
    }

    public void createSimpleJsonObject(Object o) {
        if (o instanceof Pair) {
            if (!(((Pair) o).getRight() instanceof List)) {
                writer.writeString(String.valueOf(((Pair) o).getLeft()));
                writer.writePropertySeparator();
                if (((Pair) o).getRight() instanceof Number) {
                    writer.writeNumber((Number) ((Pair) o).getRight());
                } else {
                    writer.writeString(((Pair) o).getRight().toString());
                }
                writer.writeSeparator();
            } else {
                writer.writeString(String.valueOf(((Pair) o).getLeft()));
                writer.writePropertySeparator();
                writer.writeArrayBegin();
                ((List) ((Pair) o).getRight()).forEach(this::createSimpleJsonObject);
                writer.writeArrayEnd();
                writer.writeSeparator();
            }
        } else if (o instanceof Number) {
            writer.writeNumber((Number) o);
            writer.writeSeparator();
        } else {
            if (o instanceof List) {
                writer.writeArrayBegin();
                ((List) o).forEach(this::createSimpleJsonObject);
                writer.writeArrayEnd();
            } else {
                writer.writeString(o.toString());
                writer.writeSeparator();
            }
        }
    }

    private StringBuilder createObjectJson(Object object) {
        StringBuilder builder = new StringBuilder();
        writer.setValue(builder);
        writer.writeObjectBegin();
        ((List<Pair<Object, Object>>) object).forEach(this::createSimpleJsonObject);
        writer.writeObjectEnd();
        writer.flush();
        return builder;
    }
}
