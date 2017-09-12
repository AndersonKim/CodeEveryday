package com.MyDataStructure.MyLinkedList;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * edited by AndersonKim
 * at 2017/9/12
 */

public class MyLinkedList {
    //表头是作为索引存在的不用来存储数据
    MyNode head;
    /**
     * 向表头中插入新的节点，将新节点作为表头
     * @param data
     */
    public void insertAtHead(String data){

        MyNode _new=new MyNode();
        _new.data=data;

        _new.next=head;
        head=_new;
    }

    /**
     * 删除首个节点
     */
    public MyNode deleteHead(){
        //删除的关键在于，修改表头指针的指向，并且将删除的节点返回
        MyNode temp=head.next;
        head=head.next;
        return temp;
    }


    /**
     * 遍历链表显示数据
     */
    public void displayData(){
        MyNode it=head;
        while (it.next!=null){
            System.out.println(":"+it.data+'-');
            it=it.next;
        }
    }

    /**
     * 在链表中查询指定值的节点
     * @param key
     */
    public String find(String key){
        MyNode current=head;
        StringBuffer result=new StringBuffer("");
        while (current.next!=null){
            if (current.data.equals(key)){
                return result.append("find "+key).toString();
            }else{
                current=current.next;
            }
        }
        return result.append("can't find "+key).toString();
    }

    public void delete(String data){
        MyNode current=head;
        MyNode pre;
        while (current.next!=null){
            if (current.data.equals(data)){
                pre.next=current.next;
            }else{
                current=current.next;
            }
        }
    }

    @Test
    public void test(){
        MyNode a=new MyNode();
        MyLinkedList list=new MyLinkedList();
        list.head=a;
        list.insertAtHead("2");
        list.insertAtHead("3");
        list.insertAtHead("4");
        list.insertAtHead("5");
        list.insertAtHead("6");
        String result= list.find("6");
        System.out.println(result);
        MyNode delete=list.deleteHead();
        System.out.println("deleted:"+delete.data);
        result= list.find("6");
        System.out.println(result);
        list.displayData();
    }
}
