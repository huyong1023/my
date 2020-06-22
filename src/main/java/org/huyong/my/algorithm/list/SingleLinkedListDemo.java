package org.huyong.my.algorithm.list;

/**
 * Created by yonghu on 2020/6/18.
 */
public class SingleLinkedListDemo {
}



class SingleLinkedList{

    private HeroNode head = new HeroNode(0, "", "");

}


class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString(){
        return "HeroNode:{no=" + this.no + ",name=" + this.name + ",nickname=" + this.nickname + "}";


    }
}