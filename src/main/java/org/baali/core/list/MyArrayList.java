package org.baali.core.list;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

public class MyArrayList<T> extends AbstractList<T> implements List<T>
{
    private T[] data = (T[]) new Object[1];
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
            System.out.println(data.length + " Data length");
        }
        System.out.println("data length: " + data.length);
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
        if (index < count && index >= 0)
        {
            return data[index];
        }
        else
        {
            throw new IndexOutOfBoundsException(index + " is not a valid index!!!");
        }
    }

    @Override
    public T set(int index, T element)
    {
        if (index < count && index >= 0)
        {
            return data[index] = element;
        }
        else
        {
            throw new IndexOutOfBoundsException(index + " is not a valid index!!!");
        }
    }

    @Override
    public void add(int index, T element)
    {
        if (index > count || index < 0)
        {
            throw new IndexOutOfBoundsException((index) + " is not a valid index!!!");
        }
        if (index == count)
        {
            add(element);
            return;
        }
        ensureCapacity(count + 2);
        /*
            This is crude way to add new element
            in between the list
        */
      /*  for(int i = count; i > index; )
        {
            data[i] = data[--i];
        }*/
        System.arraycopy(data, index, data, index+1, count - index );
        //System.out.println("Array size: " + data.length);
        //System.out.println("Element at index " + data[index]);
        data[index] = element;
        count++;
    }

    @Override
    public T remove(int index)
    {
        T temp = data[index];
        System.out.println("Data before delete " +  Arrays.asList(data));
        System.arraycopy(data, index + 1, data, index, count - index - 1);
        System.out.println("Data after delete " + Arrays.asList(data));
        data[--count] = null;
        return temp;
    }

    @Override
    public int indexOf(Object o)
    {
        return 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("MyArrayList[");
        for(int i = 0; i < count; i++)
        {
            sb.append(data[i] + ", ");
        }
        if (count > 0)
        {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
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
