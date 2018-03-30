package PrintListReversingly;
//输入一个链表的头结点，从尾到头反过来打印出每个结点的值

import java.util.ArrayList;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

class Solution1{
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //ListNode temp = listNode;
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }
}

class Solution2{
    public static void reverselyprint(ListNode head){
        if(head.next == null)
            System.out.println(head.val);
        if(head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while(!stack.empty()) {
            System.out.print(stack.peek() + "\t");
            stack.pop();
        }
    }
}

public class printListReversingly {
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for(int i = 1; i < 6; i ++){
            ListNode list = new ListNode(i);
            temp.next = list;
            temp = temp.next;
        }
        Solution1 s = new Solution1();
        System.out.println(s.printListFromTailToHead(head));
        Solution2.reverselyprint(head);
    }
}
