package dynamicProgramming;

/**
 * Created By: Ankit Kumar Sinha on 2020-04-04, Sat
 */
public class Knapsack0_1 {

    public static void main(String[] args) {
        int val[] = new int[]{10, 6, 12};
        int wt[] = new int[]{2, 1, 3};
        int  W = 5;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));


    }

    static int max(int a, int b) { return (a > b)? a : b; }

    static int findVal(int[][] K, int i, int j){
        if (i<0 || j<0)
            return 0;
        else
            return K[i][j];
    }

    static void println(int[][] K, int n, int W){
        for(int i=0;i<=n;i++) {
            for (int w = 0; w <= W; w++)
                System.out.print(K[i][w] + " ");
            System.out.println();
        }
        System.out.println();
    }


    private static int knapSack(int W, int[] wt, int[] val, int n) {

        int i,w;
        int K[][] = new int[n+1][W+1];

        for(i=0;i<=n;i++)
            for(w=0;w<=W;w++){
                if(i==0 || w==0)
                    K[i][w]=0;
                else if (wt[i-1]<w)
                    K[i][w] = max( val[i-1] + findVal(K,i-1,w-wt[i-1]), K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];

//                println(K, n, W);
            }
        return K[n][W];
    }


}
