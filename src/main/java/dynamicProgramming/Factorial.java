package dynamicProgramming;

/**
 * Created By: Ankit Kumar Sinha on 2020-03-16, Mon
 */



public class Factorial {

//    This is recursive but not an example of DP as there are sub-problems but not repeating sub-problems
    private long recursiveFact(int n) {
        if (n<=1) return 1;
        return n*recursiveFact(n-1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        long value = factorial.recursiveFact(20);
        System.out.println("Value :- " +  value);
    }
}
