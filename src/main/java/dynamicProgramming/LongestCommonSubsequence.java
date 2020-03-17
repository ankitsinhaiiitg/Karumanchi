package dynamicProgramming;

/**
 * Created By: Ankit Kumar Sinha on 2020-03-17, Tue
 */
public class LongestCommonSubsequence {

    String findLCSRecursion(String a, String b){
        if(a.length()==0 || b.length()==0)
            return "";

        if(a.charAt(0) == b.charAt(0))
            return a.charAt(0) + findLCSRecursion(a.substring(1),b.substring(1));


        String s1 = findLCSRecursion(a, b.substring(1));
        String s2 = findLCSRecursion(a.substring(1), b);
        return s1.length()>=s2.length()? s1:s2;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String lcsRecursion = lcs.findLCSRecursion("abcbdab", "bdcaba");
        System.out.println(lcsRecursion);
    }

}
