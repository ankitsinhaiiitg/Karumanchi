package dynamicProgramming;

/**
 * Created By: Ankit Kumar Sinha on 2020-03-23, Mon
 */
public class Problem1 {
//    `T(0)=T(1)=2
//    T(n) = 2*T(1)*T(0) + 2*T(2)*T(1) .......
    private static int numberOfRecursiveCall =0;
    private long solutionRecursive(int n) {
        numberOfRecursiveCall++;
        int sum = 0;
        if(n==0 || n==1)
            return 2;
        for(int i=1;i<n;i++)
            sum += 2*solutionRecursive(i)*solutionRecursive(i-1);
        return sum;
    }


    private long solutionDP(int n) {
        numberOfRecursiveCall++;
        long[] val = new long[n+1];
        long sum = 0;
        val[0] = val[1]=2;
//        for ()

        val[n]=sum;
        return sum;

    }


    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        for(int i=0;i<10;i++) {
            numberOfRecursiveCall=0;
            System.out.println("For i = " + i + " -- " + problem1.solutionRecursive(i));
            System.out.println("Number of recursive call without dp:-" + numberOfRecursiveCall);

            System.out.println("For i = " + i + " -- " + problem1.solutionDP(i));
        }
    }

}
