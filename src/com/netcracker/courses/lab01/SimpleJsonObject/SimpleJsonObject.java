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

            } else {
                writer.writeString(String.valueOf(((Pair) o).getLeft()));
                writer.writePropertySeparator();
                writer.writeArrayBegin();
                int counter = 0;
                for (Object i : (List) ((Pair) o).getRight()) {
                    createSimpleJsonObject(i, writer);
                    if (counter < ((List) ((Pair) o).getRight()).size()-1) {
                        writer.writeSeparator();
                        counter++;
                    }
                }
                writer.writeArrayEnd();
            }
        } else if (o instanceof Number) {
            writer.writeNumber((Number) o);

        } else {
            if (o instanceof List) {
                writer.writeArrayBegin();
                int counter = 0;
                for (Object i : (List) o) {
                    createSimpleJsonObject(i, writer);
                    if (counter < ((List) o).size()-1) {
                        writer.writeSeparator();
                        counter++;
                    }
                }
                writer.writeArrayEnd();
            } else {
                if (o instanceof Boolean) {
                    writer.writeBoolean((Boolean) o);
                } else {
                    writer.writeString(o.toString());
                }
            }
        }
    }
}
