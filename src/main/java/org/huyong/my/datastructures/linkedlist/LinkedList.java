/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/22 11:18
 */
package org.huyong.my.datastructures.linkedlist;

import org.omg.CORBA.NO_IMPLEMENT;

public abstract class LinkedList {
}



class Node{
    private int no;
    private String name;
    private String nickName;
    public Node next;


    public Node (int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
}