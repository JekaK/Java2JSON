package Lab01Tests;

import com.netcracker.courses.lab01.Serializer.JsonSerializer;
import com.netcracker.courses.lab01.TestClass;
import com.netcracker.courses.lab01.Writers.JsonWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeka on 18.12.16.
 */
public class SerializationTest {
    private JsonWriter writer;
    private JsonSerializer serializer;

    @Before
    public void init() {
        writer = new JsonWriter(new StringWriter());
        serializer = new JsonSerializer();
    }

    @Test
    public void testBoolean() {
        serializer.serialize(true, writer);
        assertEquals("{true}", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testCollection() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(new TestClass("sdfsdf", 2.0));
        serializer.serialize(list, writer);
        assertEquals("[1,{'value':'sdfsdf','jeka':2.0,'list':[10,13,[100,101]],'anInt':10,'aBoolean':false}]", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put("1", 1);
        map.put("2", new TestClass("dsf", 2.0));
        serializer.serialize(map, writer);
        assertEquals("['1':1,'2':{'value':'dsf','jeka':2.0,'list':[10,13,[100,101]],'anInt':10,'aBoolean':false}]", writer.getWriter().toString());
        writer.flush();
    }
    @Test
    public void testNumber() {
        serializer.serialize(1, writer);
        assertEquals("{1}", writer.getWriter().toString());
        writer.flush();
    }
    @Test
    public void testObjectArray() {
        serializer.serialize(new TestClass[]{new TestClass("sdf", 1.0), new TestClass("dsfsdf", 2.0)}, writer);
        assertEquals("[{'value':'sdf','jeka':1.0,'list':[10,13,[100,101]],'anInt':10,'aBoolean':false},{'value':'dsfsdf','jeka':2.0,'list':[10,13,[100,101]],'anInt':10,'aBoolean':false}]", writer.getWriter().toString());
        writer.flush();
    }

    @Test
    public void testNumberArray() {
        serializer.serialize(new int[]{1,2,3,4,5}, writer);
        assertEquals("[1,2,3,4,5]", writer.getWriter().toString());
        writer.flush();
    }
    @Test
    public void testString() {
        serializer.serialize("test", writer);
        assertEquals("{'test'}", writer.getWriter().toString());
        writer.flush();
    }
}
