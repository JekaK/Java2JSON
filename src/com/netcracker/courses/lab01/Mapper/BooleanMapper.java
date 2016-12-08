package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Annotations.JsonProperty;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

/**
 * Created by jeka on 07.12.16.
 */
public class BooleanMapper implements JsonMapper {

    @Override
    public void write(Object object, JsonWriter writer) {
        if (object instanceof Boolean) {
            Class cls = object.getClass();
            Annotation[] annotations = cls.getAnnotations();
            if (annotations.length != 0)
                for (Annotation i : annotations) {
                    if (i instanceof JsonProperty) {
                        writer.writeBooleanObject(((JsonProperty) i).type(), (Boolean) object);
                    }
                }
            else {
                if (Modifier.isPublic(cls.getModifiers())) {
                    writer.writeBoolean((Boolean) object);
                }
            }
        }
    }
}
