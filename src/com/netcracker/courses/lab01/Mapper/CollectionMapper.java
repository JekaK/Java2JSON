package com.netcracker.courses.lab01.Mapper;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.Collection;
import java.util.List;

/**
 * Created by jeka on 07.12.16.
 */
public class CollectionMapper implements JsonMapper<Collection> {
    @Override
    public void write(Collection object, JsonWriter writer) {
        if (object != null) {
            int counter = 0;
            writer.writeArrayBegin();
            for (Object i : object) {
                writeCollection(i, writer);
                if (counter < object.size()-1) {
                    writer.writeSeparator();
                    counter++;
                }
            }
            writer.writeArrayEnd();
        }
    }

    private void writeCollection(Object object, JsonWriter writer) {
        SimpleJsonObject jsonObject;
        int counter = 0;
        jsonObject = new SimpleJsonObject();
        List list = new Decompiler(object).getList();
        if (object instanceof Number || object instanceof CharSequence) {
           writeList(list,jsonObject,counter,writer);
        } else {
            writer.writeObjectBegin();
            writeList(list,jsonObject,counter,writer);

            writer.writeObjectEnd();
        }
    }
    public void writeList(List list, SimpleJsonObject jsonObject, int counter,JsonWriter writer){
        for (Object j : list) {
            jsonObject.createSimpleJsonObject(j, writer);
            if (counter < list.size()-1) {
                writer.writeSeparator();
                counter++;
            }
        }
    }
}
