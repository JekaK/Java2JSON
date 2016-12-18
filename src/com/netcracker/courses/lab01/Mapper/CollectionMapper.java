package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.Normalizer.SeparatorNormalizer;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.Collection;

/**
 * Created by jeka on 07.12.16.
 */
public class CollectionMapper implements JsonMapper<Collection> {
    @Override
    public void write(Collection object, JsonWriter writer) {
        if (object != null) {
            writer.writeArrayBegin();
            for (Object i : object) {
                writeCollection(i, writer);
            }
            writer.writeArrayEnd();
        }
        new SeparatorNormalizer().deleteLastSeparator(writer);
    }

    private void writeCollection(Object object, JsonWriter writer) {
        SimpleJsonObject jsonObject;
        if (object instanceof Number || object instanceof CharSequence) {
            jsonObject = new SimpleJsonObject();
            for (Object j : new Decompiler(object).getList()) jsonObject.createSimpleJsonObject(j, writer);
        } else {
            writer.writeObjectBegin();
            jsonObject = new SimpleJsonObject();
            for (Object j : new Decompiler(object).getList()) jsonObject.createSimpleJsonObject(j, writer);
            writer.writeObjectEnd();
        }
    }
}
