import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/20
 * @description:
 * @version:1.0
 */
public class Solution {
    public void reorderList(ListNode head){

        if(head==null||head.next==null){
            return;
        }

        Deque<ListNode> stack=new LinkedList<>();
        ListNode p=head;

        while (p!=null){
            stack.push(p);
            p=p.next;
        }

        int n=stack.size();
        int count=(n-1)/2;
        p=head;

        while (count!=0){
            ListNode tmp=stack.pop();
            tmp.next=p.next;
            p.next=tmp;
            p=tmp.next;
            count--;
        }

        stack.pop().next=null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}