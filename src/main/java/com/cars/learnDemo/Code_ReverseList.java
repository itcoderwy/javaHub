package com.cars.learnDemo;

/**
 * @Description 单双链表得反转删除
 * @Author Wy005
 * @Date 2021/1/5 15:09
 * @Version 1.0
 **/
public class Code_ReverseList {

    public class Node{
        private int value;
        private Node next;
        public Node(Node next) {
            this.next = next;
        }
    }

    public static Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while(head!= null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
