package com.github.leetcode.AddTwoNumbers_002;

public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean plusOne = false;
        ListNode node = null;
        if(l1 == null && l2 == null) {
            return new ListNode(0);
        }
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if(plusOne){
                sum += 1;
                plusOne = false;
            }
            if(sum>=10){
                plusOne = true;
                sum %= 10;
            }
            node = new ListNode(sum, node);
        }
        ListNode reversedNode = null;
        if(plusOne){
            reversedNode = new ListNode(1, reversedNode);
        }
        reversedNode = new ListNode(node.val, reversedNode);
        while(node.next != null){
            reversedNode = new ListNode(node.next.val, reversedNode);
            node = node.next;
        }

        return reversedNode;
    }
}
