package org.huyong.my.algorithm.list;

/**
 * Created by yonghu on 2020/6/18.
 */
public class DoubleLinkedListDemo {
}


class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");
}


class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;


    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

}