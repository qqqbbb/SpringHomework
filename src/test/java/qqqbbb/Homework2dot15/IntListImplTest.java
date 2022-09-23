package qqqbbb.Homework2dot15;

import org.junit.jupiter.api.Test;
import qqqbbb.Homework2dot14.StringListImpl;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IntListImplTest
{

    IntListImpl out = new IntListImpl(1);
    @Test
    void test()
    {
        assertThrows(IllegalArgumentException.class, () -> out = new IntListImpl(-1));
        assertThrows(IllegalArgumentException.class, () -> out.add(null));
        assertEquals( out.size(), 0);
        assertEquals( out.add(1), 1);
        assertEquals( out.add(2), 2);
        assertEquals( out.add(4), 4);
        assertEquals( out.size(), 3);
        assertThrows(IllegalArgumentException.class, () -> out.add(0,null));
        assertThrows(IllegalArgumentException.class, () -> out.set(0, null));
        assertThrows(IllegalArgumentException.class, () -> out.remove(null));
//        assertThrows(IllegalArgumentException.class, () -> out.remove("a"));
        assertThrows(IllegalArgumentException.class, () -> out.contains(null));
        assertThrows(IllegalArgumentException.class, () -> out.indexOf(null));
        assertThrows(IllegalArgumentException.class, () -> out.lastIndexOf(null));
        assertThrows(IllegalArgumentException.class, () -> out.equals(null));
        assertEquals( out.add(0, 0), 0);
        assertEquals( out.add(3, 3), 3);
        assertEquals( out.size(), 5);
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(11,1));
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(-1,1));
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(5, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(11));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(-1));
        assertEquals( out.set(0, 11), 11);
        assertEquals( out.remove( 0), 11);
        assertEquals( out.size(), 4);
        assertEquals( out.remove( 3), 4);
        assertEquals( out.size(), 3);
        assertFalse(out.contains(33));
        assertTrue(out.contains(1));
        assertTrue(out.contains(3));

        System.out.println(out);

        assertEquals( out.indexOf(1), 0);
        assertEquals( out.indexOf(3), 2);
        assertEquals( out.indexOf(-1), -1);
        assertEquals( out.indexOf(11), -1);
        assertEquals( out.get(0), 1);
        assertEquals( out.get(2), 3);
        IntListImpl newSL = new IntListImpl(1);
        newSL.add(1);
        newSL.add(2);
        newSL.add(3);
        assertTrue( out.equals(newSL));
        out.add(3);
        assertEquals( out.indexOf(3), 2);
        assertEquals( out.lastIndexOf(3), 3);
        assertFalse( out.equals(newSL));
        assertFalse( out.isEmpty());
        assertEquals( out.toArray()[0], 1);
        assertEquals( out.toArray()[3], 3);
        out.clear();
        assertTrue( out.isEmpty());
        assertEquals( out.indexOf(3), -1);
        assertEquals( out.size(), 0);
        assertFalse(out.contains(1));
    }

    int[] createArray(int size)
    {
        Random rd = new Random();
        int[] arrayToTest = new int[size];
        for (int i = 0; i < arrayToTest.length; i++)
            arrayToTest[i] = rd.nextInt(size + 1);

        return arrayToTest;
    }

    @Test
    void testBinarySearch()
    {
        int toFind = 7;
//        int[] arrayToTest = createArray(100);
        int[] arrayToTest = new int[]{1, 2, 3, 5, 5, 5, 7, 8, 9, 10};
        IntListImpl intList = new IntListImpl(arrayToTest);
//        intList.insertionSort();
        System.out.println("indexOf " + toFind + " is " + intList.indexOf(toFind));
        System.out.println(intList);
        intList.binarySearch(toFind);
    }

    @Test
    void testSorting()
    {
        int[] arrayToTest = createArray(10000);

        long startTime = System.currentTimeMillis();
        Sorting.insertionSort(Arrays.copyOf(arrayToTest, arrayToTest.length));
        System.out.println("insertionSort test time  " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        Sorting.bubbleSort(Arrays.copyOf(arrayToTest, arrayToTest.length));
        System.out.println("bubbleSort test time  " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        Sorting.selectionSort(Arrays.copyOf(arrayToTest, arrayToTest.length));
        System.out.println("selectionSort test time  " + (System.currentTimeMillis() - startTime));
    }
}