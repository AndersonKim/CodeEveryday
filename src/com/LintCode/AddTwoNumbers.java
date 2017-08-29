package com.LintCode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/*
    You have two numbers represented by a linked list,
    where each node contains a single digit.
    The digits are stored in reverse order,
    such that the 1's digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    Example
    Given 7->1->6 + 5->9->2. That is, 617 + 295.
    Return 2->1->9. That is 912.
    Given 3->1->5 and 5->9->2, return 8->0->8.
    Tags Expand
    Cracking The Coding Interview Linked List High Precision
*/

//todo define an practice linked data structure 2017年8月28日
public class AddTwoNumbers {
    public ListNode addLists(ListNode l1, ListNode l2) {
        long a = extractNumberFromListnode(l1);
        long b = extractNumberFromListnode(l2);
        return extractListnodeFromNumber(a + b);

    }

    private ListNode extractListnodeFromNumber(long number) {
        int index = 0;
        ListNode result = new ListNode((int) number % 10);
        number = number / 10;
        while (number > 10) {
            index = (int) number % 10;
            result.next = new ListNode(index);
        }
        return result;
    }

    private int extractNumberFromListnode(ListNode l1) {
        int i = 0;
        int sum = 0;
        while (l1.next != null) {
            sum += l1.val * Math.pow(10, i);
            i++;
        }
        return sum;
    }

    @Test
    public void testAddLists() {
        ListNode ln1 = new ListNode(7);
        ln1.next = new ListNode(1);
        ln1.next = new ListNode(6);
        assertThat(extractNumberFromListnode(ln1), is(617));
        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(9);
        ln2.next = new ListNode(2);
        assertThat(extractNumberFromListnode(ln2), is(295));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addLists(ln1, ln2);

        ListNode t = new ListNode(9);
        t.next = new ListNode(1);
        t.next = new ListNode(2);

        // assertThat(result, is(t));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
