package GetLeastNumbers_Solution;
//输入n个整数，找出其中最小的K个数。
// 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution1{
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k > input.length)
            return res;
        if(k == input.length) {
            for(int i = 0; i < input.length; i ++)
                res.add(input[i]);
            return res;
        }

        int low = 0;
        int high = input.length - 1;
        int index = Partition(input, low, high);
        while(index != k - 1){
            if(index > k - 1)
                index = Partition(input, low, index - 1);
            if(index < k - 1)
                index = Partition(input, index + 1, high);
            else
                break;
        }

        for(int i = 0; i < k; i ++)
            res.add(input[i]);

        return res;
    }

    private int Partition(int[] input, int low, int high){
        int pivot = input[low];
        while(low < high){
            while(low < high && input[high] >= pivot)
                high --;
            input[low] = input[high];
            while(low < high && input[low] <= pivot)
                low ++;
            input[high] = input[low];
            if(low >= high)
                break;
        }
        input[low] = pivot;
        return low;
    }
}

class Solution2{
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k > input.length || k == 0)
            return res;
        if(k == input.length) {
            for(int i = 0; i < input.length; i ++)
                res.add(input[i]);
            return res;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < k; i ++)
            heap.offer(input[i]);

        for(int i = k; i < input.length; i ++){
            if(input[i] < heap.peek()){
                heap.poll();
                heap.offer(input[i]);
            }
            else continue;
        }

        for(int i = 0; i < k; i ++)
            res.add(heap.poll());

        return res;
    }
}

public class GetLeastNumbers_Solution {
    public static void main(String[] args){
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        //System.out.println(new Solution1().GetLeastNumbers_Solution(input, 4));
        System.out.println(new Solution2().GetLeastNumbers_Solution(input, 0));
    }
}
