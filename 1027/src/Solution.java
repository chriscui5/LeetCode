import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:yixiaolan
 * @date:Created in 2020/10/28
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> occur=new HashMap<Integer, Integer>();
        for (int x:arr){
            occur.put(x,occur.getOrDefault(x,0)+1);
        }
        Set<Integer> times=new HashSet<Integer>();
        for (Map.Entry<Integer,Integer> x: occur.entrySet()){
            times.add(x.getValue());
        }
        return times.size()==occur.size();
    }
}
