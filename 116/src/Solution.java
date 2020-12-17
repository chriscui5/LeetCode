import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/15
 * @description:
 * @version:1.0
 */
public class Solution {
    public Node connect(Node root){
        if(root==null){
            return null;
        }

        Deque<Node> nodeDeque=new LinkedList<Node>();
        nodeDeque.push(root);

        while (!nodeDeque.isEmpty()){
            int size=nodeDeque.size();

            for (int i=0;i<size;i++){
                Node node= nodeDeque.poll();
                if(i<size-1){
                    node.next=nodeDeque.peek();
                }
                if(node.left!=null){
                    nodeDeque.add(node.left);
                }
                if(node.right!=null){
                    nodeDeque.add(node.right);
                }
            }
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
