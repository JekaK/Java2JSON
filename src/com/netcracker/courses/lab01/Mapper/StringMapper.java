package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Normalizer.SeparatorNormalizer;
import com.netcracker.courses.lab01.Writers.JsonWriter;

/**
 * Created by jeka on 07.12.16.
 */
public class StringMapper implements JsonMapper<String> {
    @Override
    public void write(String object, JsonWriter writer) {
        writer.writeObjectBegin();
        writer.writeString(object);
        writer.writeObjectEnd();
        new SeparatorNormalizer().deleteLastSeparator(writer);
    }
}
