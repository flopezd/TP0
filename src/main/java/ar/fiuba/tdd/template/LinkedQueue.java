package ar.fiuba.tdd.template;

public class LinkedQueue<T> implements Queue<T> {
    private interface QueueNode<T> {
        public T getNodeElement();

        public QueueNode<T> getNextNode();

        public void setNextNode(final QueueNode<T> nextNode);
    }
    private class ElementQueueNode<T> implements QueueNode<T>{
        private T nodeElement;
        private QueueNode<T> nextNode;

        private ElementQueueNode(final T nodeElement) {
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

    private class EmptyQueueNode<T> implements QueueNode<T> {
        public T getNodeElement() {
            throw new AssertionError();
        }

        public QueueNode<T> getNextNode() {
            throw new AssertionError();
        }

        public void setNextNode(final QueueNode<T> nextNode) {
            throw new AssertionError();
        }
    }

    private static final int EMPTY_SIZE = 0;

    private int size = EMPTY_SIZE;
    private QueueNode<T> firstNode = new EmptyQueueNode<T>();
    private QueueNode<T> lastNode = new EmptyQueueNode<T>();

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
        QueueNode<T> newLastNode = new ElementQueueNode<T>(item);
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
        return firstNode.getNodeElement();
    }

    @Override
    public void remove() throws AssertionError {
        firstNode = firstNode.getNextNode();
        size--;
    }
}
