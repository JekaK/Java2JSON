package com.netcracker.courses.lab01.SimpleJsonObject;

import com.netcracker.courses.lab01.CustomPair.Pair;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.List;

/**
 * Created by jeka on 15.12.16.
 */
public class SimpleJsonObject {
    public SimpleJsonObject() {
    }
    public void createSimpleJsonObject(Object o, JsonWriter writer) {
        if (o instanceof Pair) {
            if (!(((Pair) o).getRight() instanceof List)) {
                writer.writeString(String.valueOf(((Pair) o).getLeft()));
                writer.writePropertySeparator();
                if (((Pair) o).getRight() instanceof Number) {
                    writer.writeNumber((Number) ((Pair) o).getRight());
                } else {
                    if (((Pair) o).getRight() instanceof Boolean) {
                        writer.writeBoolean((Boolean) ((Pair) o).getRight());
                    } else
                        writer.writeString(((Pair) o).getRight().toString());
                }
                writer.writeSeparator();
            } else {
                writer.writeString(String.valueOf(((Pair) o).getLeft()));
                writer.writePropertySeparator();
                writer.writeArrayBegin();
                for (Object i : (List) ((Pair) o).getRight()) {
                    createSimpleJsonObject(i, writer);
                }
                writer.writeArrayEnd();
                writer.writeSeparator();
            }
        } else if (o instanceof Number) {
            writer.writeNumber((Number) o);
            writer.writeSeparator();
        } else {
            if (o instanceof List) {
                writer.writeArrayBegin();
                for (Object i : (List) o) {
                    createSimpleJsonObject(i, writer);
                }
                writer.writeArrayEnd();
            } else {
                if (o instanceof Boolean) {
                    writer.writeBoolean((Boolean) o);
                } else {
                    writer.writeString(o.toString());
                    writer.writeSeparator();
                }
            }
        }
    }
}
