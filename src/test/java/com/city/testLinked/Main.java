package com.city.testLinked;


class LinkImpl<E> {
    private class Node{//保存节点的数据关系，【内部类形式】
        private E data;//保存的数据
        private Node next;
        public Node(E data){//有数据的情况下才有意义
            this.data=data;
        }
        //第一次调用：this = LinkImpl.root;
        //第二次调用：this = LinkImpl.root.next;
        //第三次调用：this = LinkImpl.root.next.next;
        public void addNode(Node newNode){//保存新的node数据
            if(this.next==null){//当前节点的下一个节点为空
                this.next=newNode;//保存当前节点
            }else{
                this.next.addNode(newNode);
            }
        }
    }


    //--------------以下为Link类中定义的成员---------
    private Node root;//保存根元素
    private int count;
    //--------------以下为Link类中定义的方法---------

    public void add(E e) {
        if(e==null){//保存的数据为空
            return;
        }
        //数据本身不具有关联特性的，只有Node类有，那么要想实现关联处理就必须将数据封装在Node类中
        Node newNode=new Node(e);
        if(this.root==null){//现在没有根节点
            this.root=newNode;
        }else {//根节点存在
            this.root.addNode(newNode);//将新节点保存在合适的位置
        }
        this.count++;
    }
    public int size(){
        return this.count;
    }
}
public class Main {
    public static void main(String[] args) {
        LinkImpl<String> all=new LinkImpl<String>();
        System.out.println("【增加之前：】数据个数："+all.size());
        all.add("wanyu");
        all.add("hello");
        all.add("world");
        all.add("great");
        System.out.println("【增加之后：】数据个数："+all.size());
        System.out.println("【增加之后：】："+all.toString());

    }



}