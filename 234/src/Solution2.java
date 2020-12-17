import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/27
 * @description:
 * @version:1.0
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        Stack<ListNode> reverse = new Stack<ListNode>();
        while (slow!=null){
            reverse.push(slow);
            slow=slow.next;
        }
        fast=head;
        while (!reverse.isEmpty()){
            slow=reverse.pop();
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
        }
        return true;


    }
}

