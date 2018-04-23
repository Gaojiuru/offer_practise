package sqrt;

class Solution{
    public double sqrt(double m){
        if(m < 0)
            return Double.NaN;
        double err = 1e-15;
        double t = m;
        while(Math.abs(m - t * t) > err)
            t = (m / t + t) / 2.0;
        System.out.println(t);
        return t;
    }
}

public class sqrt {
    public static void main(String[] args){
        double m = 4;
        double i = 0;
        while((i * i) <= m)
            i += 0.1;
        for(int j = 0; j < 10; j ++)
            i = (m / i + i) / 2.0;
        System.out.println(i);
        new Solution().sqrt(m);
    }
}
