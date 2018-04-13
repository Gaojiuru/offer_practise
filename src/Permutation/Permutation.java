package Permutation;
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

import java.util.ArrayList;
import java.util.Collections;

class Solution{
    public ArrayList<String> Permutation(String str){
        ArrayList<String> result = new ArrayList<>();
        char[] ch = str.toCharArray();
        PermutationHelper(result, 0, ch);
        Collections.sort(result);
        return result;
    }

    private void PermutationHelper(ArrayList<String> res, int k, char[] ch){
        if(k == ch.length - 1)
            res.add(String.valueOf(ch));

        for (int i = k; i < ch.length; i++) {
            if (i != k && ch[k] == ch[i])
                continue;
            //System.out.println(k + "\t" + i);
            swap(ch, i, k);
            PermutationHelper(res, k + 1, ch);
            swap(ch, i, k);
        }
    }

    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}

public class Permutation {
    public static void main(String[] args){
        String str = "aba";
        ArrayList<String> res = new Solution().Permutation(str);
        for (String s: res)
            System.out.println(s);
    }
}
