package com.katas.queue;

public class MyQueue {
    private Object[] storage;
    private int elementCount = 0;

    public MyQueue(int capacity) {
        this.storage = new Object[capacity];
    }

    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public boolean isFull() {
        return this.elementCount == storage.length - 1;
    }

    public void enqueue(Object newElement) {
        if (isFull()) throw new FullQueueException();

        this.storage[elementCount++] = newElement;
    }

    public Object peek() {
        if (isEmpty()) throw new EmptyQueueException();

        return storage[0];
    }

    public Object dequeue() {
        if (isEmpty()) throw new EmptyQueueException();

        Object toReturn = this.storage[0];

        shiftStorage();

        elementCount--;

        return toReturn;
    }

    private void shiftStorage() {
        Object[] shiftedStorage = new Object[this.storage.length];

        for (int i = 1; i < this.storage.length - 1; i++) {
            shiftedStorage[i - 1] = this.storage[i];
        }

        this.storage = shiftedStorage;
    }

    public class EmptyQueueException extends RuntimeException {
    }

    public class FullQueueException extends RuntimeException {
    }
}
