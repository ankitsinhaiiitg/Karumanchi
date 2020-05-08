package dataStructure;

/**
 * Created By: Ankit Kumar Sinha on 2020-05-03, Sun
 */
public class LinkedListPartition {
//  Definition for singly-linked list.
 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

//      Input: head = 1->4->3->2->5->2, x = 3
//      Output: 1->2->2->4->3->5
    public static ListNode partition(ListNode head, int x) {
        ListNode pointer = new ListNode(0);
        pointer.next = head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            if(curr.val<=x){
                //delete current pointer
                if(curr == head){
                    //when head is smaller than x
                    pointer = head;
                    prev = curr;
                    curr = curr.next;
                } else {
                    //when not head is smaller x
                    //first time
                    //second time
                    //delete
                    prev.next = curr.next;

                    //insert
                    if(pointer.next == head)
                        head = curr;

                    pointer.next = curr;
                    curr.next = pointer.next;

                    pointer = curr;
                    curr = prev.next;
                }


            } else {
                prev = curr;
                curr = curr.next;
            }

        }

        return head;

    }

    public static void main(String[] args) {
        ListNode head  = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);

        System.out.println(partition(head.next,3));


    }
}

