package ar.fiuba.tdd.template;

public class LinkedQueue<T> implements Queue<T> {
    private T element;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return element == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        element = item;
        size++;
    }

    @Override
    public T top() {
        return element;
    }

    @Override
    public void remove() {

    }
}
