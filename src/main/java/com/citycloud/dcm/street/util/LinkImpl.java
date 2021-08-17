package com.citycloud.dcm.street.util;

import java.util.concurrent.Executors;

class LinkImpl<E> {

        private class Node {//保存节点的数据关系，【内部类形式】

        private E data;//保存的数据

        private Node next;


        public Node(E data) {//有数据的情况下才有意义
            this.data = data;

        }
        //第一次调用：this = LinkImpl.root;
        //第二次调用：this = LinkImpl.root.next;
        //第三次调用：this = LinkImpl.root.next.next;
        public void addNode(Node newNode) {//保存新的node数据
            if (this.next == null) {//当前节点的下一个节点为空
                this.next = newNode;//保存当前节点

            } else {
                this.next.addNode(newNode);

            }


        }


    }

    public static void main(String[] args) {
        LinkImpl link = new LinkImpl();




    }
}



