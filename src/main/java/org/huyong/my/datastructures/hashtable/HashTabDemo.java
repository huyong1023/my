package org.huyong.my.datastructures.hashtable;

/**
 * Created by yonghu on 2020/6/22.
 */
public class HashTabDemo {
}



class HashTab{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size){
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }
}

class EmpLinkedList{
    private Emp head;
}



class Emp {

    public Emp next;
}