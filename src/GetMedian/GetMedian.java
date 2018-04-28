package GetMedian;
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution{
    Queue<Integer> min = new PriorityQueue<Integer>();
    Queue<Integer> max = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void Insert(Integer num){
        if((min.size() + max.size()) % 2 == 0){
            if(max.size() > 0 && max.peek() > num){
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        }
        else{
            if(min.size() > 0 && min.peek() < num){
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double GetMedian(){
        int size = min.size() + max.size();
        if(size % 2 == 0)
            return (min.peek() + max.peek()) / 2.0;
        else
            return min.peek() / 1.0;
    }
}

public class GetMedian {
    public static void main(String[] args){
        int[] num = {1, 45, 8, 6, 2};
        Solution s = new Solution();
        for(int i = 0; i < num.length; i ++)
            s.Insert(num[i]);
        System.out.println(s.GetMedian());
    }
}
