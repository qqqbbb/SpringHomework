package qqqbbb.Homework2dot15;

import java.util.Arrays;

public class IntListImpl implements IntList
{
    private int initialSize;
    private Integer[] array;
    private int size;

    public IntListImpl(int initialSize)
    {
        if (initialSize < 0)
            throw new IllegalArgumentException();

        if (initialSize == 0)
            initialSize = 1;

        this.initialSize = initialSize;
        array = new Integer[initialSize * 2];
    }

    public IntListImpl(int[] arr)
    {
        initialSize = arr.length;
        if (arr.length == 0)
            initialSize = 1;

        array = new Integer[initialSize * 2];
        size = arr.length;
        for (int i = 0; i < arr.length; i++)
            array[i] = arr[i];
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
    public Integer add(Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        if (array.length <= size)
            growArray();

        array[size] = int_;
        size++;
        return int_;
    }

    @Override
    public Integer add(int index, Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        size++;
        if (size >= array.length)
            growArray();

        for (int i = size; i > index; i--)
            array[i] = array[i-1];

        array[index] = int_;
        return int_;
    }

    @Override
    public Integer set(int index, Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        array[index] = int_;
        return int_;
    }

    @Override
    public Integer remove(Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        boolean removed = false;
        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(int_))
                removed = true;

            if (removed && i < size - 1)
                array[i] = array[i + 1];
        }
        if (removed)
        {
            size--;
            return int_;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Integer remove(int index)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Integer int_ = array[index];
        for (int i = index; i < size-1; i++)
            array[i] = array[i + 1];

        size--;
        return int_;
    }

    @Override
    public boolean contains(Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(int_))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(int_))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer int_)
    {
        if (int_ == null)
            throw new IllegalArgumentException();

        for (int i = size - 1; i >= 0; i--)
        {
            if (array[i].equals(int_))
                return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    @Override
    public boolean equals(IntList otherList)
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
        array = new Integer[initialSize];
    }

    @Override
    public Integer[] toArray()
    {
        return Arrays.copyOf(array, size);
    }

    public void insertionSort()
    {
        for (int i = 1; i < size; i++)
        {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp)
            {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public int binarySearch(int intToFind)
    {
        int middle = size / 2;
        int searchStartIndex = -1;
        int searchEndIndex = -1;
        System.out.println();
        System.out.println("binary search start " + intToFind);
//        System.out.println("binary search start  middle " + middle);

        while (middle > 0)
        {
//            System.out.println("binary search compare " + array[middle]);
            if (array[middle] > intToFind)
            {
                if (searchStartIndex == -1)
                    searchStartIndex = 0;

                searchEndIndex = middle;
                middle = (searchStartIndex + searchEndIndex) / 2;
//                System.out.println("binary search left half searchStartIndex " + searchStartIndex);
//                System.out.println("binary search left half searchEndIndex " + searchEndIndex);
//                System.out.println("binary search left half middle " + middle);
            }
            else
            {
                searchStartIndex = middle;

                if (searchEndIndex == -1)
                    searchEndIndex = size - 1;

                middle = (int)Math.ceil((searchStartIndex + searchEndIndex) * 0.5);
//                System.out.println("binary search right half searchStartIndex " + searchStartIndex);
//                System.out.println("binary search right half searchEndIndex " + searchEndIndex);
//                System.out.println("binary search right half middle " + middle);
            }
            if (array[middle] == intToFind)
            {
                System.out.println(intToFind + " found at index " + middle);
                return middle;
            }
            if (searchEndIndex == middle)
            {
                System.out.println("did not find");
                return -1;
            }
            System.out.println();
        }
        System.out.println("did not find");
        return -1;
    }
}

