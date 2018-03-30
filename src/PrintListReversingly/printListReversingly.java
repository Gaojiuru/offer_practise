package PrintListReversingly;
//输入一个链表的头结点，从尾到头反过来打印出每个结点的值

import java.util.Stack;

class List{
    int value;
    List next;
    public List(int value){
        this.value = value;
    }
}

class Solution1{
    public static void reverselyprint(List head){
        List temp = head;
        if(temp.next != null)
            reverselyprint(temp.next);
        System.out.print(temp.value + "\t");
    }
}

class Solution2{
    public static void reverselyprint(List head){
        Stack<Integer> stack = new Stack<>();
        List temp = head;
        while(temp != null) {
            stack.push(temp.value);
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
        List head = new List(0);
        List temp = head;
        for(int i = 1; i < 6; i ++){
            List list = new List(i);
            temp.next = list;
            temp = temp.next;
        }
        Solution1.reverselyprint(head);
        System.out.println();
        Solution2.reverselyprint(head);
    }
}
