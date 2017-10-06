package com.company;

import javax.lang.model.util.Elements;
import java.util.*;

public class CircularArrayList<E> extends ArrayList<E>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public CircularArrayList()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CircularArrayList( int initialCapacity )
    {
        elements = new Object[initialCapacity];
    }

    CircularArrayList( Collection<? extends E> c )
    {
        elements = c.toArray();
        size = c.size();
    }

    private void checkIndexRange( int index )
    {
        if( index<0 || index > size )
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add( int index, E element )
    {
        if( index < 0 || index > size )
        {
            throw new IndexOutOfBoundsException( );
        }
        if( index != size )
        {
            System.arraycopy( elements, index, elements, index +1, size - index );
        }
        elements[index] = element;
        size++;
        modCount ++;
        }

    @Override
    public E get( int index )
    {
        checkIndexRange( index );
        return (E) elements[index];
    }

    @Override
    public E set( int index, E element )
    {
        checkIndexRange(  index );
        E old = (E) elements[index];

        elements[index] = element;
        return super.set( index, element );
    }

    @Override
    public E remove( int index )
    {
        checkIndexRange( index );
        E old = (E) elements[index];
        if( index != size -1 )
        {
            System.arraycopy( elements, index + 1, elements, (size - index - 1) );
        }
    }
}
