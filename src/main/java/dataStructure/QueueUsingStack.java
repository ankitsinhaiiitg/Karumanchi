package dataStructure;

import java.util.Stack;

/**
 * Created By: Ankit Kumar Sinha on 2020-04-05, Sun
 */
public class QueueUsingStack {


        Stack<Integer> i = new Stack<Integer>();
        Stack<Integer> j = new Stack<Integer>();
        /** Initialize your data structure here. */
        public QueueUsingStack() {


        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(i.empty())
                i.add(x);
            else{
                while(!i.empty())
                    j.add(i.pop());
                i.add(x);
                while(j.empty())
                    i.add(j.pop());
            }



        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return j.pop();
        }

        /** Get the front element. */
        public int peek() {
            return j.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return j.empty();
        }

    public static void main(String[] args) {

  QueueUsingStack obj = new QueueUsingStack();
  obj.push(3);
  obj.push(2);
  int param_2 = obj.pop();
  int param_3 = obj.peek();
  boolean param_4 = obj.empty();
    }

}
