package StrToInt;
//将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
//输入描述:输入一个字符串,包括数字字母符号,可以为空
//输出描述:如果是合法的数值表达则返回该数字，否则返回0

class Solution{
    public int StrToInt(String str){
        boolean isInvalid = false;
        int res = 0;
        int symbol = 1;
        char[] ch = str.toCharArray();
        if(ch == null || ch.length == 0){
            isInvalid = true;
            return 0;
        }
        if(ch[0] == '-')
            symbol = -1;
        for(int i = (ch[0] == '+' || ch[0] == '-') ? 1 : 0; i < ch.length; i ++){
            if(!(ch[i] >= '0' && ch[i] <= '9')){
                isInvalid = true;
                return 0;
            }
            res = (res << 1) + (res << 3) + (ch[i] & 0xf);
            if(symbol == 1 && res > Integer.MAX_VALUE || symbol == -1 && res < Integer.MIN_VALUE){
                isInvalid = true;
                return 0;
            }
        }
        return res * symbol;
    }

}

class StrToInt {
    public static void main(String[] args){
        System.out.println(new Solution().StrToInt("+12345"));
    }
}
