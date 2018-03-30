package Replace;
//请实现一个函数，把字符串中的每个空格替换成“%20”,时间复杂度为O(n)

public class replace {
    public static void main(String[] args){
        char[] init = {'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        char[] ch = new char[50];
        System.arraycopy(init, 0, ch, 0, init.length);
        if(init == null || ch.length < 0)
            return;
        int originLength = init.length;
        int numberOfBlank = 0;
        int length = ch.length;
        for(int i = 0; i < originLength; i ++){
            if(ch[i] == ' ')
                numberOfBlank ++;
        }
        int newLength = originLength + 2 * numberOfBlank;
        if(length < newLength)
            return;
        int i = newLength - 1;
        int j = originLength - 1;
        while(i > j && j >= 0){
            if(ch[j] == ' '){
                ch[i --] = '0';
                ch[i --] = '2';
                ch[i --] = '%';
            }
            else
                ch[i --] = ch[j];
            j --;
        }

        for(int k = 0; k < ch.length; k ++)
            System.out.print(ch[k]);

    }
}
