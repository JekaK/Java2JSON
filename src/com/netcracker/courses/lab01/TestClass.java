package com.netcracker.courses.lab01;

import com.netcracker.courses.lab01.Annotations.JsonProperty;

import java.util.ArrayList;

/**
 * Created by jeka on 02.12.16.
 */
public class TestClass {
    @JsonProperty(type = "value")
    private String value;
    @JsonProperty(type = "jeka")
    private Double jeka;

    @JsonProperty(type = "list")
    private ArrayList list;

    public int anInt = 10;
    private ArrayList list1;

    public TestClass(String value, Double jeka) {
        this.value = value;
        this.jeka = jeka;
        list = new ArrayList();
        list1 = new ArrayList();


        list.add(new Integer(12));
        list.add(new Integer(13));
        list1.add(new Integer(100));
        list1.add(new Integer(101));

        list.add(list1);
    }

}
