package ds;

import java.util.Iterator;

public class Sequence implements Iterable<Integer>
{
     int start, increment, limit;

    public Sequence(int start, int increment, int limit)
    {
        this.start = start;
        this.increment = increment;
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new SequenceIterator(this);
    }

    public static void main(String[] args)
    {
        for (Integer i : new Sequence(1, 2, 100))
        {
            System.out.println(i);
        }
        System.out.println("--------------------------");

        for (Integer i : new Sequence(1, 3, 10))
        {
            System.out.println(i);
        }
    }
}

class SequenceIterator implements Iterator<Integer>
{
    private Sequence sequence;
    private int nextValue;

    public SequenceIterator(Sequence sequence)
    {
        this.sequence = sequence;
        this.nextValue = sequence.start;
    }

    @Override
    public boolean hasNext()
    {
        return this.nextValue <= this.sequence.limit;
    }

    @Override
    public Integer next()
    {
        if (this.sequence.limit < this.nextValue)
        {
            throw new UnsupportedOperationException("No such element");
        }
        int r = this.nextValue;
        this.nextValue += this.sequence.increment;
        return r;
    }
}
