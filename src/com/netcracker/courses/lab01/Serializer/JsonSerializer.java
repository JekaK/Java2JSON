package com.netcracker.courses.lab01.Serializer;

import com.netcracker.courses.lab01.CustomObjects.Decompiler;
import com.netcracker.courses.lab01.Mapper.*;
import com.netcracker.courses.lab01.Mapper.Interfaces.JsonMapper;
import com.netcracker.courses.lab01.SimpleJsonObject.SimpleJsonObject;
import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeka on 05.12.16.
 */
public class JsonSerializer {

    Map<Class, JsonMapper> mappersCache;

    public JsonSerializer() {
        generateMappersCache();
    }

    private void generateMappersCache() {
        mappersCache = new HashMap<>();
        mappersCache.put(BooleanMapper.class, new BooleanMapper());
        mappersCache.put(CollectionMapper.class, new CollectionMapper());
        mappersCache.put(MapMapper.class, new MapMapper());
        mappersCache.put(NumberMapper.class, new NumberMapper());
        mappersCache.put(ObjectArrayMapper[].class, new ObjectArrayMapper());
        mappersCache.put(PrimitiveArrayMapper.class, new PrimitiveArrayMapper());
        mappersCache.put(StringMapper.class, new StringMapper());
    }

    public void serialize(Object object, JsonWriter writer) {
        JsonMapper mapper = getMapper(object.getClass());
        mapper.write(object, writer);
    }

    protected JsonMapper getMapper(Class cls) {
        JsonMapper mapper = null;
        if (cls.isArray()) {
            if (!checkPrimitive(cls))
                mapper = mappersCache.get(ObjectArrayMapper[].class);
            else mapper = mappersCache.get(PrimitiveArrayMapper.class);
        } else if (CharSequence.class.isAssignableFrom(cls))
            mapper = mappersCache.get(StringMapper.class);
        else
            mapper = mappersCache.get(cls);
        if (mapper == null) {
            if (Number.class.isAssignableFrom(cls)) {
                mapper = mappersCache.get(NumberMapper.class);
                return mapper;
            }
            if (Map.class.isAssignableFrom(cls)) {
                mapper = mappersCache.get(MapMapper.class);
                return mapper;
            }
            if (Collection.class.isAssignableFrom(cls)) {
                mapper = mappersCache.get(CollectionMapper.class);
                return mapper;
            } else {
                mapper = (object, writer) -> {
                    writer.writeObjectBegin();
                    SimpleJsonObject jsonObject = new SimpleJsonObject();
                    for (Object j : new Decompiler(object).getList()) {
                        jsonObject.createSimpleJsonObject(j, writer);
                    }
                    writer.writeObjectEnd();
                };
            }
        }
        return mapper;
    }

    private boolean checkPrimitive(Class cls) {
        return byte[].class.isAssignableFrom(cls) ||
                short[].class.isAssignableFrom(cls) ||
                int[].class.isAssignableFrom(cls) || long[].class.isAssignableFrom(cls) ||
                float[].class.isAssignableFrom(cls) ||
                double[].class.isAssignableFrom(cls) ||
                char[].class.isAssignableFrom(cls);
    }
}
