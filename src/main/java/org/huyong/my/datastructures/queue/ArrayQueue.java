/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/21 19:01
 */
package org.huyong.my.datastructures.queue;

public interface ArrayQueue {

    public String ERROR_MSG_INIT = "init queue size must Greater than zero";
    public String ERROR_MSG_FULL = "queue is full";
    public String ERROR_MSG_EMPTY = "queue is empty";

    public boolean isFull();

    public boolean isEmpty();

    public void  addQueue(int val);

    public int getQueue();

    public void showQueue();

    public int headQueue();

}
