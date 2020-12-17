/**
 * @author:yixiaolan
 * @date:Created in 2020/10/20
 * @description:
 * @version:1.0
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode new_head=new ListNode(0,head);
        ListNode first=head;
        ListNode second=new_head;

        for(int i=0;i<n;i++){
            first=first.next;
        }
        while (first!=null){
           first=first.next;
           second=second.next;
        }
        second.next=second.next.next;
        return new_head.next;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
