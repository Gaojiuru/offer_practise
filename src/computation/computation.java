package computation;
//进位实现加减乘除

class Solution{
    public int add(int a, int b){
        int sum;
        int carry;
        do{
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while(b != 0);
        return a;
    }

    public int minus(int a, int b){
        int B = ~(b - 1);
        return add(a, B);
    }

    public int multiply(int a, int b){
        int i = 0;
        int res = 0;
        while(b != 0){
            if((b & 1) == 1){
                res += (a << i);
                b = b >> 1;
                i ++;
            }
            else{
                b = b >> 1;
                i ++;
            }
        }
        return res;
    }

    public int sub(int a, int b){
        int res = -1;
        if(a < b)
            return 0;
        else
            res = sub(minus(a, b), b) + 1;
        return res;
    }
}

public class computation {
    public static void main(String[] args){
        int a = 4;
        int b = 2;
        Solution s = new Solution();
        System.out.println(s.add(a, b) + "\t" + s.minus(a, b) + "\t" + s.multiply(a, b) + "\t" + s.sub(a, b));
    }
}
