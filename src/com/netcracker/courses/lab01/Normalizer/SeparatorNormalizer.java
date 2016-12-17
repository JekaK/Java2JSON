package com.netcracker.courses.lab01.Normalizer;

import com.netcracker.courses.lab01.Writers.JsonWriter;

import java.io.IOException;


/**
 * Created by jeka on 18.12.16.
 */
public class SeparatorNormalizer {
    public void deleteLastSeparator(JsonWriter s) {
        for (int i = 0; i < s.getWriter().toString().length() - 1; i++) {
            if (s.getWriter().toString().charAt(i) == ',' && s.getWriter().toString().charAt(i + 1) == '\n') {
                StringBuilder builder = new StringBuilder(s.getWriter().toString());
                builder.deleteCharAt(i);
                builder.setCharAt(i,'\r');

                s.flush();
                try {
                    s.getWriter().write(String.valueOf(builder));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
