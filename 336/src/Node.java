import java.util.ArrayList;
import java.util.List;

/**
 * @author:yixiaolan
 * @date:Created in 2020/8/7
 * @description:
 * @version:1.0
 */
public class Node {
    public Node[] children;

    public List<Integer> words;

    public List<Integer> suffixs;

    public Node() {
        this.children = new Node[26];
        this.words = new ArrayList<>();
        this.suffixs = new ArrayList<>();
    }

}
