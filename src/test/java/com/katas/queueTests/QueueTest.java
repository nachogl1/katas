package com.katas.queueTests;

import com.katas.queue.MyQueue;
import com.katas.queue.MyQueue.EmptyQueueException;
import com.katas.queue.MyQueue.FullQueueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {

    public static final int MAX_CAPACITY = 10;
    private MyQueue myQueue;

    @BeforeEach
    void setUp() {
        myQueue = new MyQueue(MAX_CAPACITY);
    }

    @Test
    void return0LengthWhenEmpty() {
        int result = myQueue.size();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void return1LengthWhen1Element() {
        myQueue.enqueue(1);
        int result = myQueue.size();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void returnIfEmptyAndIfFullBeingEmpty() {
        boolean result = myQueue.isEmpty();
        assertThat(result).isTrue();

        boolean result2 = myQueue.isFull();
        assertThat(result2).isFalse();
    }

    @Test
    void returnIfEmptyAndIfFullBeingFull() {
        for (int i = 0; i < MAX_CAPACITY - 1; i++) {
            myQueue.enqueue(1);
        }

        boolean result = myQueue.isEmpty();
        assertThat(result).isFalse();

        boolean result2 = myQueue.isFull();
        assertThat(result2).isTrue();
    }

    @Test
    void peekLastItem() {
        String lastItem = "lastItem";

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(lastItem);

        Object result = myQueue.peek();

        assertThat(result).isEqualTo(1);

    }

    @Test
    void dequeuetwoElements() {
        String firstItem = "firstItem";

        myQueue.enqueue(firstItem);
        myQueue.enqueue(1);
        myQueue.enqueue(2);

        assertThat(myQueue.isEmpty()).isFalse();
        assertThat(myQueue.isFull()).isFalse();
        assertThat(myQueue.size()).isEqualTo(3);
        assertThat(myQueue.peek()).isEqualTo(firstItem);

        myQueue.dequeue();
        Object result = myQueue.dequeue();

        assertThat(result).isEqualTo(1);

        assertThat(myQueue.isEmpty()).isFalse();
        assertThat(myQueue.isFull()).isFalse();
        assertThat(myQueue.size()).isEqualTo(1);
        assertThat(myQueue.peek()).isEqualTo(2);

        myQueue.dequeue();

        assertThat(myQueue.isEmpty()).isTrue();
        assertThat(myQueue.isFull()).isFalse();
        assertThat(myQueue.size()).isEqualTo(0);


    }

    @Test
    void returnEmptyQueueExcpetionWhenDequeueingEmpty() {
        assertThrows(EmptyQueueException.class, () ->
        {
            myQueue.dequeue();
        });
    }

    @Test
    void returnFullQueueExcpetion() {
        assertThrows(FullQueueException.class, () ->
        {
            for (int i = 0; i < MAX_CAPACITY; i++) {
                myQueue.enqueue(1);
            }
        });
    }

    @Test
    void finalTestMaxiFull() {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.dequeue();
        assertThat(myQueue.isFull()).isFalse();
        assertThat(myQueue.isEmpty()).isFalse();

        assertThat(myQueue.peek()).isEqualTo(2);

        myQueue.enqueue(3);
        myQueue.dequeue();
        myQueue.dequeue();

        assertThrows(EmptyQueueException.class, () ->
        {
            myQueue.peek();
        });

        assertThat(myQueue.isFull()).isFalse();
        assertThat(myQueue.isEmpty()).isTrue();


        for (int i = 0; i < MAX_CAPACITY - 1; i++) {
            myQueue.enqueue(i);
        }
        assertThat(myQueue.peek()).isEqualTo(0);

        assertThat(myQueue.isFull()).isTrue();
        assertThat(myQueue.isEmpty()).isFalse();


    }

}
