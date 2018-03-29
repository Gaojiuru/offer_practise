package kNode;
//从链表中找出倒数第k个数

class List {
    int value;
    List next;

    public List(int value) {
        this.value = value;
    }
}

class Solution{
    public static List kNode(List head, int k) {
        if (head == null) {
            return null;
        } else {
            List first = head;
            List behind = head;

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
        List head = new List(0);
        List temp = null;

        for (int i = 1; i < 8; ++i) {
            List add = new List(i);
            if (i == 1) {
                head.next = add;
            } else {
                temp.next = add;
            }

            temp = add;
        }

        for (temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.value + "->");
        }

        System.out.println();
        if (Solution.kNode(head, 9) == null) {
            System.out.println("The k is too large!");
        } else {
            System.out.println(Solution.kNode(head, 8).value);
        }
    }

}
