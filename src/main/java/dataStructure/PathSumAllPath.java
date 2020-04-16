package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created By: Ankit Kumar Sinha on 2020-04-14, Tue
 */
public class PathSumAllPath {



      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum1(root,sum,1);
    }


    public List<List<Integer>> pathSum1(TreeNode root, int sum, int size) {
        if(root==null)
            return null;

        if(root.left==null && root.right==null && root.val==sum){
            List<String> strings = Arrays.asList(new String[100]);
            List<Integer> i = new ArrayList<Integer>(size);
            i.add(size-1,sum);
            List<List<Integer>> j  = new ArrayList<>();
            j.add(i);
            return j;
        }
        List<List<Integer>> l = null,r = null;
        if(root.left!=null){
            l = pathSum1(root.left,sum-root.val, size+1);
            if(l!=null)
                for(List<Integer> i : l)
                    i.add(size,root.val);
        }
        if(root.right!=null){
            r = pathSum1(root.right,sum-root.val, size+1);
            if(r!=null)
                for(List<Integer> i : r)
                    i.add(size,root.val);
        }

        if(l==null && r==null)
            return null;
        if(l!=null && r!=null){
            l.addAll(r);
            return l;
        }
        if(r==null)
            return l;
        return r;
    }
}

