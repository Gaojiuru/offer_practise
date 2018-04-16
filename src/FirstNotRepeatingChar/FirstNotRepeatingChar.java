package FirstNotRepeatingChar;
//在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置

import java.util.HashMap;
import java.util.Map;

class Solution{
    public int FirstNotRepeatingChar(String str){
        if(str == null || str.length() == 0)
            return -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i ++){
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }

        /*Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }*/

        int i = 0;
        for(; i < str.length(); i ++) {
            if (map.get(str.charAt(i)) == 1)
                break;
        }
        return i;
    }
}

public class FirstNotRepeatingChar {
    public static void main(String[] args){
        System.out.println(new Solution().FirstNotRepeatingChar("abaccdeff"));
    }
}
