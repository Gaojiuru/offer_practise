package kNode;
//输入一个链表，输出该链表中倒数第k个结点

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public static ListNode kNode(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        } else {
            ListNode first = head;
            ListNode behind = head;

            for(int i = 0; i < k - 1; ++i) {
                if (first.next == null) {
                    return null;
                }

                first = first.next;
            }

            while(first.next != null) {
                first = first.next;
                behind = behind.next;
            }

            return behind;
        }
    }
}


public class kNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        for (int i = 2; i < 6; ++i) {
            ListNode add = new ListNode(i);
            temp.next = add;
            temp = add;
        }

        for (temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + "->");
        }

        System.out.println();

        Solution.kNode(head, 0);
    }

}
