package ar.fiuba.tdd.template;

public interface Queue<T> {
    boolean isEmpty();

    int size();

    void add(T item);

    T top();

    void remove();
}
