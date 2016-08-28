package ar.fiuba.tdd.template;

public class LinkedQueue<T> implements Queue<T> {
    private class QueueNode<T> {
        private T nodeElement;
        private QueueNode<T> nextNode;

        private QueueNode(final T nodeElement) {
            this.nodeElement = nodeElement;
        }

        public T getNodeElement() {
            return nodeElement;
        }

        public QueueNode<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(final QueueNode<T> nextNode) {
            this.nextNode = nextNode;
        }
    }

    private static final int EMPTY_SIZE = 0;

    private int size = EMPTY_SIZE;
    private QueueNode<T> firstNode;
    private QueueNode<T> lastNode;

    @Override
    public boolean isEmpty() {
        return size == EMPTY_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        QueueNode<T> newLastNode = new QueueNode<T>(item);
        if (isEmpty()) {
            firstNode = newLastNode;
        } else {
            lastNode.setNextNode(newLastNode);
        }
        lastNode = newLastNode;
        size++;
    }

    @Override
    public T top() throws AssertionError {
        try {
            return firstNode.getNodeElement();
        } catch (NullPointerException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void remove() throws AssertionError {
        try {
            firstNode = firstNode.getNextNode();
            size--;
        } catch (NullPointerException e) {
            throw new AssertionError();
        }
    }
}
