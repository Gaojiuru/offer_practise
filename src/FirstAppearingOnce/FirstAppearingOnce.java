package FirstAppearingOnce;

//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
//输出描述:如果当前字符流没有存在出现一次的字符，返回#字符。

import java.util.LinkedHashMap;
import java.util.Map;

class Solution{
    private Map<Character, Integer> map = new LinkedHashMap();
    public void Insert(char ch){
        if(map.containsKey(ch))
            map.put(ch, 0);
        else
            map.put(ch, 1);
    }

    public char FistAppearingOnce(){
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return '#';
    }
}

public class FirstAppearingOnce {
    public static void main(String[] args){
        String str = "google";
        Solution s = new Solution();
        for(int i = 0; i < str.length(); i ++)
            s.Insert(str.charAt(i));
        System.out.println(s.FistAppearingOnce());
    }
}
