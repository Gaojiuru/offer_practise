package PrintMinNumber;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numbers.length; i ++)
            list.add(numbers[i]);
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer s1, Integer s2){
                String str1 = s1 + "" + s2;
                String str2 = s2 + "" + s1;
                return str1.compareTo(str2);
            }
        });
        for(Integer i : list)
            res.append(i);
        return res.toString();
    }
}

public class PrintMinNumber {
    public static void main(String[] args){
        int[] numbers = {3, 32, 321};
        System.out.println(new Solution().PrintMinNumber(numbers));
    }
}
