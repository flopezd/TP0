package ar.fiuba.tdd.template;

public class LinkedQueue<T> implements Queue<T> {
    T element;

    @Override
    public boolean isEmpty() {
        return element == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(T item) {
        element = item;
    }

    @Override
    public T top() {
        return element;
    }

    @Override
    public void remove() {

    }
}
