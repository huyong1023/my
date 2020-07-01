package org.huyong.my.datastructures.tree;

/**
 * Created by yonghu on 2020/7/1.
 */
public class AVLTreeDemo {


}


class AVLTree {
    private Node root;

}




class Node {
    int value;
    Node left;
    Node rigth;

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }


    public int rightHeight() {
        if (rigth == null) {
            return 0 ;
        }
        return rigth.height();
    }

    public int height() {
        return  Math.max(left == null ? 0 : left.height(), rigth == null ? 0 : rigth.height()) + 1;
    }
}