package com.netcracker.courses.lab01.Annotations;

import java.lang.annotation.*;

/**
 * Created by jeka on 02.12.16.
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonProperty {
    String type() default "defaultName";
}
