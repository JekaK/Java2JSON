package com.netcracker.courses.lab01.Serializer;

import java.io.*;

/**
 * Created by jeka on 05.12.16.
 */
public class JsonSerializer {
    private StringBuilder builder;

    public JsonSerializer(StringBuilder builder) {
        this.builder = builder;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public StringBuilder fromJson(String fileName) {
        builder = new StringBuilder();
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(fileIn);
            builder = (StringBuilder) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert in != null;
            in.close();
            assert fileIn != null;
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    public void toJson(String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
            oos.writeObject(builder);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
