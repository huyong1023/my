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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleArrayQueueTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testArrayQueue(){
        CricleArrayQueueDemo queue = new CricleArrayQueueDemo(10);
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        for (int i = 0; i < 10; i++){
            queue.addQueue(i);
            queue.showQueue();
            assertFalse(queue.isEmpty());
        }
        assertTrue(queue.isFull());
        queue.showQueue();
        for (int i = 0; i < 5; i++){
            System.out.println(queue.getQueue());
            queue.showQueue();
        }

        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());


        for (int i = 0; i < 5; i++){
            queue.addQueue(i);
            queue.showQueue();
            assertFalse(queue.isEmpty());
        }
        assertTrue(queue.isFull());



        for (int i = 0; i < 10; i++){
            System.out.println(queue.getQueue());
            queue.showQueue();
        }
        assertTrue(queue.isEmpty());

    }


    @Test
    public void testArrayQueueinitException() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("init size must Greater than zero");
        ArrayQueue queue = new CricleArrayQueueDemo(-1);

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
        queue.addQueue(1);
    }
}
