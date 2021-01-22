/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/21 11:36
 */
package org.huyong.my.datastructures.queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class QueueTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testArrayQueue(){
        ArrayQueue queue = new ArrayQueueDemo(10);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        for (int i = 0; i < 10; i++){
            queue.addQueue(i);
            assertFalse(queue.isEmpty());
        }
        assertTrue(queue.isFull());
        queue.showQueue();
        for (int i = 0; i < 10; i++){
            System.out.println(queue.getQueue());
            queue.showQueue();
        }

        assertTrue(queue.isEmpty());
        assertTrue(queue.isFull());
    }





    @Test
    public void testArrayQueueGetException() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("queue is empty");
        ArrayQueue queue = new ArrayQueueDemo(10);
        queue.getQueue();

    }


    @Test
    public void testArrayQueueAddException() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("queue is full");
        ArrayQueue queue = new ArrayQueueDemo(10);
        for (int i = 0; i < 10; i++){
            queue.addQueue(i);
        }

        queue.getQueue();
        queue.showQueue();
        queue.addQueue(1);
    }
}
