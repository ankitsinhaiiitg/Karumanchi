package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By: Ankit Kumar Sinha on 2020-04-16, Thu
 */
public class PowerSet {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    List<List<Integer>> subsets(List<Integer> input){
        backtrack(input,0);
        return ans;
    }

    private void backtrack(List<Integer> input, int n) {

        ans.add(new ArrayList<Integer>(temp));

        for(int i=n;i<input.size();i++){

            System.out.print(n+" "+i+",");
            temp.add(input.get(i));
            backtrack(input,i+1);

            temp.remove(input.get(i));
        }
        System.out.println("End of loop - " + n);
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        List<Integer> integers = Arrays.asList(1,2,3);
        List<List<Integer>> subsets = powerSet.subsets(integers);
    }
}
