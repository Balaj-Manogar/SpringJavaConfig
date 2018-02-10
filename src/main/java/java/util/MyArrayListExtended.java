package java.util;

public class MyArrayListExtended<T> extends ArrayList<T>
{
    public int getModCount()
    {
        return super.modCount;
    }

    public long getActualDataSize()
    {
        return elementData.length;
    }
}
