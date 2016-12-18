package Lab01Tests;

import com.netcracker.courses.lab01.Writers.IWriter;
import com.netcracker.courses.lab01.Writers.JsonWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeka on 18.12.16.
 */
public class WriterTest {
    private IWriter writer;

    @Before
    public void init() {
        writer = new JsonWriter(new StringWriter());
        writer.writeString("test");
        writer.flush();
    }

    @Test
    public void testObjectBegin() {
        writer.writeObjectBegin();
        assertEquals("{", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testObjectEnd() {
        writer.writeObjectEnd();
        assertEquals("}", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testArrayBegin() {
        writer.writeArrayBegin();
        assertEquals("[", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testWriteArrayEnd() {
        writer.writeArrayEnd();
        assertEquals("]", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testWriteString() {
        String hello = "Hello, World!";
        writer.writeString("Hello, World!");
        assertEquals("\'" + hello + "\'", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testWriteNumber() {
        Number n = 2;
        writer.writeNumber(n);
        assertEquals(n, Integer.valueOf(writer.getWriter().toString()));
        writer.flush();
    }

    @Test
    public void testWriteSeparator() {
        writer.writeSeparator();
        assertEquals(",", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testWritePropertySeparator() {
        writer.writePropertySeparator();
        assertEquals(":", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testWriteBoolean() {
        writer.writeBoolean(true);
        assertEquals(true, Boolean.valueOf(writer.getWriter().toString()));
        writer.flush();
    }

    @Test
    public void testWriteNull() {
        writer.writeNull();
        assertEquals("null", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testFlush() {
        writer.flush();
        assertEquals("", writer.getWriter().toString());
        writer.flush();
    }
}
