package ru.sbrf.kubarev;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class DIYArrayList<T> implements List<T> {

    private Object[] storage;
    private int currentposition = 0;

    private class ListItr implements ListIterator<T>
    {
        int cursor;

        int last = - 1;

        public ListItr (int index)
        {
            cursor = index;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException();
        }



        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();

        }

        @Override
        public T previous() {
            throw new UnsupportedOperationException();

        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();

        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            DIYArrayList.this.set(cursor, t);
        }

        public T next() {
            int size = DIYArrayList.this.storage.length;

            if (last >= size)
                throw  new NoSuchElementException();

            T temp = (T) DIYArrayList.this.get(++last);
            return temp;
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

    public  DIYArrayList()
    {

        System.out.println("Конструктор без параметров");

    }

    public  DIYArrayList(int size)
    {
        if (size > 0) {
            storage = new Object[size];

            System.out.println("Конструктор с размером " + size);
        }
        else throw new RuntimeException("неверный размер списка");
    }

    @Override
    public int size() {

        return storage.length;

    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();

    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();

    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean add(T t) {


        if (currentposition < storage.length) {
            storage[currentposition++] = t;
            return true;
        }
        else {
            storage = Arrays.copyOf(storage, currentposition+1);
            storage[currentposition++] = t;
            return true;
        }


    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        int addedsize = c.size();
        Object[] newarray = c.toArray();
        storage = Arrays.copyOf(storage, currentposition+addedsize);
        for (int i = 0 ; i < addedsize; i++)
        {
            storage[currentposition++] = newarray[i];
        }
        return true;

    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();

    }


    public void replaceAll(UnaryOperator<T> operator) {
        throw new UnsupportedOperationException();

    }


    public void sort(Comparator<? super T> c) {

        Arrays.sort((T[]) storage, 0, storage.length, c);

    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();

    }

    @Override
    public T get(int index) {

        if (index < currentposition)
            return (T)storage[index];
        else
                throw new RuntimeException("Превышен размер массива");

    }

    @Override
    public T set(int index, T element) {

        if (index > currentposition)
            throw new RuntimeException("превышен размер");
        T old = (T)storage[index];
        storage[index] = element;
        return old;

    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();

    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr(0);

    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);

    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }


    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();

    }


}
