package org.baali.core.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class MyArrayList<T> implements List<T>
{
    private T[] data = (T[])new Object[10];
    private int count;


    @Override
    public void replaceAll(UnaryOperator<T> operator)
    {

    }

    @Override
    public void sort(Comparator<? super T> c)
    {

    }

    @Override
    public Spliterator<T> spliterator()
    {
        return null;
    }

    @Override
    public int size()
    {
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a)
    {
        return null;
    }

    @Override
    public boolean add(T t)
    {
        ensureCapacity(count + 2);
        data[count++] = t;
        return true;
    }

    private void ensureCapacity(int minCapacity)
    {
        if (data.length < minCapacity)
        {
            data = Arrays.copyOf(data, minCapacity);
        }
    }

    @Override
    public boolean remove(Object o)
    {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public void clear()
    {
        Arrays.fill(data, 0, count, null);
        count = 0;
    }

    @Override
    public T get(int index)
    {
        return null;
    }

    @Override
    public T set(int index, T element)
    {
        return null;
    }

    @Override
    public void add(int index, T element)
    {

    }

    @Override
    public T remove(int index)
    {
        return null;
    }

    @Override
    public int indexOf(Object o)
    {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return null;
    }
}
