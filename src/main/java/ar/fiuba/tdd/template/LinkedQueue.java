package ar.fiuba.tdd.template;

public class LinkedQueue<T> implements Queue<T> {
    private QueueNode<T> firstNode = new EmptyQueueNode<T>();
    private QueueNode<T> lastNode = new EmptyQueueNode<T>();

    @Override
    public boolean isEmpty() {
        return firstNode.isEmpty();
    }

    @Override
    public int size() {
        return firstNode.getSize();
    }

    @Override
    public void add(T item) {
        lastNode = lastNode.createNextNode(item, this);
    }

    @Override
    public T top() throws AssertionError {
        return firstNode.getNodeElement();
    }

    @Override
    public void remove() throws AssertionError {
        firstNode = firstNode.getNextNode(this);
    }

    private QueueNode<T> createFirstNode(T item) {
        return firstNode = new ElementQueueNode<T>(item);
    }

    private QueueNode<T> createLastEmptyNode() {
        return lastNode = new EmptyQueueNode<>();
    }

    private interface QueueNode<T> {
        public T getNodeElement();

        public QueueNode<T> getNextNode(final LinkedQueue<T> linkedQueue);

        public QueueNode<T> createNextNode(final T item, final LinkedQueue<T> linkedQueue);

        public QueueNode<T> getNode(final LinkedQueue<T> linkedQueue);

        public int getSize();

        public boolean isEmpty();
    }

    private class ElementQueueNode<T> implements QueueNode<T> {
        private T nodeElement;
        private QueueNode<T> nextNode = new EmptyQueueNode<T>();

        private ElementQueueNode(final T nodeElement) {
            this.nodeElement = nodeElement;
        }

        public T getNodeElement() {
            return nodeElement;
        }

        public QueueNode<T> getNextNode(final LinkedQueue<T> linkedQueue) {
            return nextNode.getNode(linkedQueue);
        }

        public QueueNode<T> createNextNode(final T item, final LinkedQueue<T> linkedQueue) {
            return  nextNode = new ElementQueueNode<T>(item);
        }

        public QueueNode<T> getNode(final LinkedQueue<T> linkedQueue) {
            return this;
        }

        public int getSize() {
            return 1 + nextNode.getSize();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private class EmptyQueueNode<T> implements QueueNode<T> {
        public T getNodeElement() {
            throw new AssertionError();
        }

        public QueueNode<T> getNextNode(final LinkedQueue<T> linkedQueue) {
            throw new AssertionError();
        }

        public QueueNode<T> createNextNode(final T item, final LinkedQueue<T> linkedQueue) {
            return linkedQueue.createFirstNode(item);
        }

        public QueueNode<T> getNode(final LinkedQueue<T> linkedQueue) {
            return linkedQueue.createLastEmptyNode();
        }

        public int getSize() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }
    }
}
