package FindFirstCommonNode;
//输入两个链表，找出它们的第一个公共结点

import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        ListNode pHeadLong = pHead1;
        ListNode pHeadShort = pHead2;
        int dis = length1 - length2;
        if(length1 < length2){
            pHeadLong = pHead2;
            pHeadShort = pHead1;
            dis = length2 - length1;
        }
        for(int i = 0; i < dis; i ++)
            pHeadLong = pHeadLong.next;

        while(pHeadLong != null && pHeadShort != null && pHeadLong.val != pHeadShort.val){
            pHeadLong = pHeadLong.next;
            pHeadShort = pHeadShort.next;
        }
        ListNode common = pHeadLong;
        return common;
    }

    private int getLength(ListNode pHead){
        int length = 0;
        ListNode temp = pHead;
        while(temp != null){
            length ++;
            temp = temp.next;
        }
        return length;
    }
}

public class FindFirstCommonNode {
    public static void main(String[] args){
        ListNode pHead1 = new ListNode(1);
        ListNode pHead2 = new ListNode(4);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        pHead1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node21 = new ListNode(5);
        pHead2.next = node21;
        node21.next = node3;
        node3.next = node4;

        System.out.println(new Solution().FindFirstCommonNode(pHead1, pHead2).val);
    }
}
