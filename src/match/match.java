package match;
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

class Solution{
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return Helper(str, strIndex, pattern, patternIndex);
    }

    private boolean Helper(char[] str, int strIndex, char[] pattern, int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length)
            return true;
        if(strIndex != str.length && patternIndex == pattern.length)
            return false;
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if(strIndex != str.length && pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' && strIndex != str.length)
                return Helper(str, strIndex, pattern, patternIndex + 2) || Helper(str, strIndex + 1, pattern, patternIndex + 2)
                        || Helper(str, strIndex + 1, pattern, patternIndex);
            else
                return Helper(str, strIndex, pattern, patternIndex + 2);
        }
        if(strIndex != str.length && pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' && strIndex != str.length)
            return Helper(str, strIndex + 1, pattern, patternIndex + 1);
        else
            return false;
    }
}

public class match {
    public static void main(String[] args){
        String str = "aaa";
        String pattern = "a*a";
        System.out.print(new Solution().match(str.toCharArray(), pattern.toCharArray()));
    }
}
