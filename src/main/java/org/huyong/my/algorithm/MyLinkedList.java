package org.huyong.my.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {
    private Node head;

    LinkedList list = new LinkedList();
    List list2 = new ArrayList();
    public Node reverse(Node node){
        if (node == null || node.next == null) {
            return head;
        }
        Node newHead = null;
        Node tmp = null;
        while (node != null) {
            tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
        }
        return newHead;
    }


    public Node getLastIndex(Node n, int index){
        if (null == n){
            return n;
        }
        Node strart = n;

        for (int i = 0; i < index - 1; i++){
            if (strart.next != null) {
                strart = strart.next;
            } else {
                return null;
            }
        }
        while (strart.next != null){
            strart = strart.next;
            n = n.next;
        }
        return n;
    }






    public void print(Node node){
        while (null != node){
            System.out.println(node.val + "  ");
            node = node.next;
        }
    }


    @Test
    public void test(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        System.out.println(getLastIndex(node1, 3));
    }

}
