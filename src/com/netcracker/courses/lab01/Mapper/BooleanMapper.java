package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Annotations.JsonProperty;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

/**
 * Created by jeka on 07.12.16.
 */
public class BooleanMapper implements JsonMapper<Boolean> {

    @Override
    public void write(Boolean object, JsonWriter writer) {
        if (object != null) {
            Class cls = object.getClass();
            int counter = 0;
            Annotation[] annotations = cls.getAnnotations();
            if (annotations.length != 0)
                for (Annotation i : annotations) {
                    if (i instanceof JsonProperty) {
                        writer.writeObjectBegin();
                        writer.writeString(((JsonProperty) i).type());
                        writer.writePropertySeparator();
                        writer.writeBoolean(object);
                        writer.writeObjectEnd();
                        if (counter < annotations.length - 1) {
                            writer.writeSeparator();
                            counter++;
                        }
                    }
                    counter = 0;
                }
            else {
                if (Modifier.isPublic(cls.getModifiers())) {
                    writer.writeObjectBegin();
                    writer.writeBoolean(object);
                    writer.writeObjectEnd();
                }
            }
        } else {
            writer.writeObjectBegin();
            writer.writeNull();
            writer.writeObjectEnd();
        }
    }
}
