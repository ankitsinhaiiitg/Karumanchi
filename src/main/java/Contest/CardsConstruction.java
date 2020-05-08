package Contest;

import java.io.*;
import java.util.*;


public class CardsConstruction {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();

        for(int i = 0;i<t;i++) {
            int count = 0;
            int s = sc.nextInt();
            while(s>1) {
                double n = calculateN(s);
                s = s - calculateSum(n);
                count++;
            }
            out.println(count);
        }
        out.close();
    }

    public static int calculateSum(double n){
        double sum;
        sum = (n/2)*(4 + (n-1)*3);
        return (int) sum;
    }

    public static int calculateN(double s){
        double sqrt = Math.sqrt(1 + 24 * s) - 1;
        int v = (int) (sqrt/6);
        return v;
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}