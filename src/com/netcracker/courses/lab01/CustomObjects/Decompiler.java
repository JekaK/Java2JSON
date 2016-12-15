package com.netcracker.courses.lab01.CustomObjects;

import com.netcracker.courses.lab01.Annotations.JsonProperty;
import com.netcracker.courses.lab01.CustomPair.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by jeka on 02.12.16.
 */
public class Decompiler implements IObject {

    private Object object;
    private List list;

    public Decompiler(Object object) {
        this.object = object;
        list = new ArrayList();
        decompileObject();
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = new Decompiler(object);
    }


    public Object recursionDown(Object o, ArrayList result) {
        ArrayList list = null;
        if (o instanceof List) {
            list = new ArrayList();
            for (int i = 0; i < ((List) o).size(); i++) {
                recursionDown(((List) o).get(i), list);
            }
            result.add(list);
        } else {
            result.add(objectsToList(o, true));
        }
        return list;
    }

    public Object objectsToList(Object o, boolean isFromArray) {
        List result = new ArrayList();
        Class cls = o.getClass();
        if (Number.class.isAssignableFrom(cls) || CharSequence.class.isAssignableFrom(cls)) {
            if (isFromArray)
                list.add(Collections.singletonList(o));
            else
                list.add(Collections.singletonList(o));
        } else {
            Field[] fields = cls.getDeclaredFields();
            for (Field i : fields) {
                if (Modifier.isPrivate(i.getModifiers())) {
                    i.setAccessible(true);
                    Annotation[] annotations = i.getDeclaredAnnotations();
                    for (Annotation j : annotations) {
                        if (j instanceof JsonProperty) {
                            try {
                                list.add(new Pair<>(((JsonProperty) j).type(), i.get(o)));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    try {
                        list.add(new Pair<>(i.getName(), i.get(o)));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    public void decompileObject() {
        if (object instanceof List) {
            for (Object i : (List) object) {
                if (i instanceof List) {
                    list.add(recursionDown(i, new ArrayList()));
                } else {
                    List result = (List) objectsToList(i, true);
                    if (result.size() != 0)
                        list.add(result);
                }

            }
        } else {
            if (((List) objectsToList(object, false)).size() != 0)
                list.add(objectsToList(object, false));
        }
    }
}
