package qqqbbb.Homework2dot14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest
{
    StringList out = new StringListImpl(1);

    @Test
    void test()
    {
        assertThrows(IllegalArgumentException.class, () -> out = new StringListImpl(-1));
        assertThrows(IllegalArgumentException.class, () -> out.add(null));
        assertEquals( out.size(), 0);
        assertEquals( out.add("A"), "A");
        assertEquals( out.add("B"), "B");
        assertEquals( out.add("C"), "C");
        assertEquals( out.size(), 3);
        assertThrows(IllegalArgumentException.class, () -> out.add(0,null));
        assertThrows(IllegalArgumentException.class, () -> out.set(0, null));
        assertThrows(IllegalArgumentException.class, () -> out.remove(null));
        assertThrows(IllegalArgumentException.class, () -> out.remove("a"));
        assertThrows(IllegalArgumentException.class, () -> out.contains(null));
        assertThrows(IllegalArgumentException.class, () -> out.indexOf(null));
        assertThrows(IllegalArgumentException.class, () -> out.lastIndexOf(null));
        assertThrows(IllegalArgumentException.class, () -> out.equals(null));
        assertEquals( out.add(0, "0"), "0");
        assertEquals( out.add(3, "3"), "3");
        assertEquals( out.size(), 5);
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(11,""));
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(-1,""));
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(-1, ""));
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(5, ""));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(11));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(-1));
        assertEquals( out.set(0, "00"), "00");
        assertEquals( out.remove( "00"), "00");
        assertEquals( out.size(), 4);
        assertEquals( out.remove( 3), "C");
        assertEquals( out.size(), 3);
        assertFalse(out.contains(""));
        assertFalse(out.contains("a"));
        assertTrue(out.contains("A"));
        assertTrue(out.contains("3"));
        assertEquals( out.indexOf("A"), 0);
        assertEquals( out.indexOf("3"), 2);
        assertEquals( out.indexOf(""), -1);
        assertEquals( out.indexOf("a"), -1);
        assertEquals( out.get(0), "A");
        assertEquals( out.get(2), "3");
        StringListImpl newSL = new StringListImpl(1);
        newSL.add("A");
        newSL.add("B");
        newSL.add("3");
        assertTrue( out.equals(newSL));
        out.add("3");
        assertEquals( out.indexOf("3"), 2);
        assertEquals( out.lastIndexOf("3"), 3);
        assertFalse( out.equals(newSL));
        assertFalse( out.isEmpty());
        assertEquals( out.toArray()[0], "A");
        assertEquals( out.toArray()[3], "3");
        System.out.println(out);
        out.clear();
        assertTrue( out.isEmpty());
        assertEquals( out.indexOf("3"), -1);
        assertEquals( out.size(), 0);
        assertFalse(out.contains("A"));
    }
}