package com.ck.linkedlist.easy;

import com.ck.linkedlist.common.ListNode;

// LC - 21 : Merge Two Sorted Lists
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		
		ListNode headA = new ListNode(1);
		ListNode node2A = new ListNode(2);
		ListNode node3A = new ListNode(4);

		headA.next = node2A;
		node2A.next = node3A;
		
		ListNode headB = new ListNode(1);
		ListNode node2B = new ListNode(3);
		ListNode node3B = new ListNode(4);
		
		headB.next = node2B;
		node2B.next = node3B;
		
		ListNode result = mergeTwoListsI(headA, headB);
		while(result!=null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode mergeTwoListsI(ListNode list1, ListNode list2) {
        
        if(list1==null && list2==null)
            return null;
        
        ListNode result = new ListNode();
        ListNode head = result;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
            	result.next=new ListNode(list1.val);
                list1=list1.next;
            }
            else{
            	result.next=new ListNode(list2.val);
                list2=list2.next;
            }
            result=result.next;
        }
        while(list1!=null){
        	result.next=new ListNode(list1.val);
            list1=list1.next;
            result=result.next;
        }
        while(list2!=null){
            result.next=new ListNode(list2.val);
            list2=list2.next;
            result=result.next;
        }
        
        return head.next;
    }
	
	public static ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode head = node;
        while(l1!=null || l2!=null){
            if(l2==null || (l1!=null && l1.val<=l2.val)){
                node.next=l1;
                l1=l1.next;
            }
            else{
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        return head.next;
    }

}
