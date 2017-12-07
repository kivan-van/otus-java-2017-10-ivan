import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ivank on 2017-12-01.
 */
public class MyArrayList<T> implements List<T> {

    private int size;
    private T[] arr;
    private int currentSize = 0;
    private int last = -1;

    public MyArrayList(int size)
    {
        arr = (T[]) new Object[size];
    }

    public MyArrayList()
    {
        arr = (T[]) new Object[10];
    }

    private void resize(int addSize)
    {
        arr = Arrays.copyOf(arr, arr.length + 10);
    }

    public int size()
    {
        return currentSize;
    }

    public boolean isEmpty()
    {
        return arr.length == 0;
    }

    public boolean contains(Object o)
    {
        for (T item :arr)
        {
            if(item.equals(0))
            {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray()
    {
        return Arrays.copyOf(arr, currentSize);
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t)
    {
        if(currentSize >= arr.length)
        {
            resize(0);
        }
        arr[currentSize++] = t;

        return true;
    }

    public boolean remove(Object o)
    {
        return false;
    }

    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    public boolean addAll(Collection<? extends T> c)
    {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c)
    {
        return false;
    }

    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    public void clear()
    {

    }

    public T get(int index)
    {
        return arr[index];
    }

    public T set(int index, T element)
    {
        arr[index] = element;
        return element;
    }

    public void add(int index, T element)
    {
        System.arraycopy(arr, index, arr, index + 1,
                size - index);
        arr[index] = element;
        size++;
    }

    public T remove(int index)
    {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return new MyIterator();
    }
    public class MyIterator<E> implements ListIterator<E>
    {
        int currentPosition = 0;

        public MyIterator()
        {
            new MyIterator(0);
        }

        public MyIterator(int index)
        {
            currentPosition = index;
        }

        public boolean hasNext()
        {
            return currentPosition < currentSize;
        }

        public E next()
        {
            return (E) arr[last = currentPosition++];
        }

        public boolean hasPrevious()
        {
            return currentPosition > 0;
        }

        public E previous()
        {
            return (E) arr[last = --currentPosition];
        }

        public int nextIndex()
        {
            return currentPosition + 1;
        }

        public int previousIndex()
        {
            return currentPosition - 1;
        }

        public void remove()
        {
            if (last > -1)
            {
                System.arraycopy(arr, last + 1, arr, last, MyArrayList.this.size() - last - 1) ;
                currentPosition = last;
                last = -1;
            }
        }

        public void set(E e)
        {
            arr[last] = (T) e;
        }

        public void add(E e)
        {

        }
    }

    public ListIterator<T> listIterator(int index) {
        return new MyIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

