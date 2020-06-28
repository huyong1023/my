package org.huyong.my.datastructures.tree;

/**
 * Created by yonghu on 2020/6/23.
 */
public class BinaryTreeDemo {


    public static void main(String[] args){

    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root = root;
    }


    public void preOrder() {

    }

    public void infixOrder(){

    }


    public void postOrder(){

    }


    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }
        return null;
    }
}


class HeroNode {
    private int no;
    private String name;


    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历"); //比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        //1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找 //2.如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//说明我们左子树找到 return resNode;
        }
        //1.左递归前序查找，找到结点，则返回，否继续判断，
        // 2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if(this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }
}
