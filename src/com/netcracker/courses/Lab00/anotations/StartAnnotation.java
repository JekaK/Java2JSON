package com.netcracker.courses.Lab00.anotations;

import java.lang.annotation.*;

/**
 * Created by jeka on 21.11.16.
 */

/**
 * Annotation created for start method by reflection Api
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StartAnnotation {
    /**
     * Marker method for start method by invoking class
     */
    public String startMethod();
}
