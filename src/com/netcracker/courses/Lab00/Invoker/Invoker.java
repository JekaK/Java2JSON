package com.netcracker.courses.Lab00.Invoker;

import com.netcracker.courses.Lab00.anotations.StartAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jeka on 10.12.16.
 */
public class Invoker {
    public static long arraySortInvoker(Class c, int mass[]) {
        Class cls = c;
        Method[] methods = cls.getDeclaredMethods();
        for (Method i : methods) {
            Annotation[] annotation = i.getDeclaredAnnotations();
            for (Annotation j : annotation) {
                if (j instanceof StartAnnotation) {
                    try {
                        return (Long) i.invoke(cls.newInstance(), mass);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return -1;
    }

    public static void arraySortInvoker(Class c, int mass[], String name) {
        Class cls = c;
        Method[] methods = cls.getDeclaredMethods();
        for (Method i : methods) {
            Annotation[] annotation = i.getDeclaredAnnotations();
            for (Annotation j : annotation) {
                if (j instanceof StartAnnotation) {
                    try {
                        if (((StartAnnotation) j).startMethod().equals(name))
                            i.invoke(cls.newInstance(), mass);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
