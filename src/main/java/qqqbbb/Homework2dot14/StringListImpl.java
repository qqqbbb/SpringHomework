package qqqbbb.Homework2dot14;

import java.util.Arrays;

public class StringListImpl implements StringList
{
    private final int initialSize;
    private String[] array;
    private int size;

    public StringListImpl(int initialSize)
    {
        if (initialSize < 0)
            throw new IllegalArgumentException();

        if (initialSize == 0)
            initialSize = 1;

        this.initialSize = initialSize;
        array = new String[initialSize * 2];
    }

    @Override
    public String toString()
    {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; i < size; i++)
        {
            if (array[i] == null)
                continue;

            sb.append(array[i]);
            if (i + 1 < size)
                sb.append(',').append(' ');
        }
        sb.append(']');
        return sb.toString();
    }

    public void growArray()
    {
        array = Arrays.copyOf(array, array.length * 2);
//        System.out.println("grow array " + array.length);
    }

    @Override
    public String add(String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        if (array.length <= size)
            growArray();

        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        size++;
        if (size >= array.length)
            growArray();

        for (int i = size; i > index; i--)
            array[i] = array[i-1];

        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        boolean removed = false;
        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(item))
                removed = true;

            if (removed && i < size - 1)
                array[i] = array[i + 1];
        }
        if (removed)
        {
            size--;
            return item;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String remove(int index)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        String item = array[index];
        for (int i = index; i < size-1; i++)
            array[i] = array[i + 1];

        size--;
        return item;
    }

    @Override
    public boolean contains(String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item)
    {
        if (item == null)
            throw new IllegalArgumentException();

        for (int i = size - 1; i >= 0; i--)
        {
            if (array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    @Override
    public boolean equals(StringList otherList)
    {
        if (otherList == null)
            throw new IllegalArgumentException();

        if (otherList.size() != size)
            return false;

        for (int i = 0; i < size; i++)
        {
            if (!array[i].equals(otherList.get(i)))
                return false;
        }
        return true;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        size = 0;
        array = new String[initialSize];
    }

    @Override
    public String[] toArray()
    {
        return Arrays.copyOf(array, size);
    }
}

