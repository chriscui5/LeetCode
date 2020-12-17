import java.util.*;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/31
 * @description:
 * @version:1.0
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx=new HashMap<Integer, Set<Integer>>();
        nums=new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set= idx.getOrDefault(val,new HashMap<>());
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {

    }

    /** Get a random element from the collection. */
    public int getRandom() {

    }
}
