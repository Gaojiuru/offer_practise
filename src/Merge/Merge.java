package Merge;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        ListNode newList = null;
        if(list1.val <= list2.val){
            newList = list1;
            newList.next = Merge(list1.next, list2);
        }
        else{
            newList = list2;
            newList.next = Merge(list1, list2.next);
        }
        return newList;
    }
}

public class Merge {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode temp = list1;
        for(int i = 3; i < 8; i += 2){
            ListNode add = new ListNode(i);
            temp.next = add;
            temp = add;
        }

        ListNode list2 = new ListNode(2);
        temp = list2;
        for(int i = 4; i < 9; i += 2){
            ListNode add = new ListNode(i);
            temp.next = add;
            temp = add;
        }

        ListNode newList = new Solution().Merge(list1, list2);
        while(newList != null){
            System.out.print(newList.val + "\t");
            newList = newList.next;
        }
    }
}
