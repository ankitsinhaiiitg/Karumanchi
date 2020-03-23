package dynamicProgramming;

/**
 * Created By: Ankit Kumar Sinha on 2020-03-17, Tue
 */
public class LongestCommonSubsequence {
    static int i = 0;

    private String findLCSRecursion(String a, String b) {
        i++;
        if (a.length() == 0 || b.length() == 0)
            return "";

        if (a.charAt(0) == b.charAt(0))
            return a.charAt(0) + findLCSRecursion(a.substring(1), b.substring(1));


        String s1 = findLCSRecursion(a, b.substring(1));
        String s2 = findLCSRecursion(a.substring(1), b);
        return s1.length() >= s2.length() ? s1 : s2;
    }

    //TOP-DOWN
    private String findLCSMemoization(String a, String b) {
    int[][] Table = new int[a.length()+1][b.length()+1];

    for(int i=0; i<a.length();i++)
        for (int j=0;j<b.length();j++) {
            if(a.charAt(i)==b.charAt(j))
                Table[i+1][j+1] = Table[i][j] + 1;
            else
                Table[i+1][j+1] = Math.max(Table[i][j+1],Table[i+1][j]);
        }
        for(int i=0; i<a.length();i++){
            for (int j=0;j<b.length();j++)
                System.out.print(Table[i][j] + "\t");
                System.out.println("");
            }


                StringBuilder s = new StringBuilder();
        for(int x = a.length(), y = b.length(); (x != 0) && (y != 0);) {
            if(Table[x][y]==Table[x-1][y])
                x--;
            else if(Table[x][y]==Table[x][y-1])
                 y--;
            else {
                assert a.charAt(x-1) == b.charAt(y-1);
                s.append(a.charAt(x-1));
                x--;
                y--;
            }
        }
        return s.reverse().toString();
    }


    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String lcsRecursion = lcs.findLCSRecursion("abcbdab", "bdcaba");
        System.out.println(lcsRecursion);
        System.out.println("Number of times recursion function is called - " + i);
        System.out.println(lcs.findLCSMemoization("abcbdab", "bdcaba"));
    }


}
