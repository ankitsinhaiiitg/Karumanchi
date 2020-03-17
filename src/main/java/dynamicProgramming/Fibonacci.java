package dynamicProgramming;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created By: Ankit Kumar Sinha on 2020-03-16, Mon
 */
public class Fibonacci {

    int n;
    long[] fib = new long[n + 1];

    private long recursiveFibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    private long topDownFibonacci(int n) {

        if (n == 0 || n == 1)
            return n;
        if (fib[n] != 0)
            return fib[n];
        fib[n] = topDownFibonacci(n - 1) + topDownFibonacci(n - 2);
        return fib[n];

    }

    private long bottomUpFibonacci(int n) {

        if (n == 0 || n == 1) return n;
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];

    }

    private long improvedBottomUpFibonacci(int n) {
        if (n==0 || n==1) return n;
        long a = 0, b = 1, sum = 0;
        for (int i=2;i<=n;i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();

        Date start = new Date();
        f.n = 40;
        f.fib = new long[f.n + 1];
        long value = f.recursiveFibonacci(f.n);
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("Value -: " + value);
        System.out.println("Time taken by recursive f - " + time);

        start = new Date();
        f.n = 1000;
        f.fib = new long[f.n + 1];
        value = f.topDownFibonacci(f.n);
        end = new Date();
        time = end.getTime() - start.getTime();
        System.out.println("Value -: " + value);
        System.out.println("Time taken by top  down f - " + time);

        start = new Date();
        f.n = 10000;
        f.fib = new long[f.n + 1];
        value = f.bottomUpFibonacci(f.n);
        end = new Date();
        time = end.getTime() - start.getTime();
        System.out.println("Value -: " + value);
        System.out.println("Time taken by bottom up f - " + time);

        start = new Date();
        f.n = 10000;
        f.fib = new long[f.n + 1];
        value = f.improvedBottomUpFibonacci(f.n);
        end = new Date();
        time = end.getTime() - start.getTime();
        System.out.println("Value -: " + value);
        System.out.println("Time taken by improved bottom up f - " + time);

    }


}
