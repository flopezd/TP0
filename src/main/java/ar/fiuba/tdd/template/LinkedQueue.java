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
    private int size = 0;
    private QueueNode<T> firstNode;
    private QueueNode<T> lastNode;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        QueueNode<T> newLastNode = new QueueNode<T>(item);
        if (isEmpty()) firstNode = newLastNode;
        else lastNode.setNextNode(newLastNode);
        lastNode = newLastNode;
        size++;
    }

    @Override
    public T top() {
        return firstNode.getNodeElement();
    }

    @Override
    public void remove() {
        if (isEmpty()) return;
        firstNode = firstNode.getNextNode();
        size--;
    }
}
