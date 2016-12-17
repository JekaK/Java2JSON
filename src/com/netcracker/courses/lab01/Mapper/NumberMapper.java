package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Annotations.JsonProperty;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Normalizer.SeparatorNormalizer;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

/**
 * Created by jeka on 07.12.16.
 */
public class NumberMapper implements JsonMapper<Number> {

    @Override
    public void write(Number object, JsonWriter writer) {
        if (object != null) {
            Class cls = object.getClass();
            Annotation[] annotations = cls.getAnnotations();
            if (annotations.length != 0)
                for (Annotation i : annotations) {
                    if (i instanceof JsonProperty) {
                        writer.writeObjectBegin();
                        writer.writeString(((JsonProperty) i).type());
                        writer.writePropertySeparator();
                        writer.writeNumber(object);
                        writer.writeObjectEnd();
                        writer.writeSeparator();
                    }
                }
            else {
                if (Modifier.isPublic(cls.getModifiers())) {
                    writer.writeObjectBegin();
                    writer.writeNumber(object);
                    writer.writeObjectEnd();
                }
            }
            new SeparatorNormalizer().deleteLastSeparator(writer);
        }
    }
}
