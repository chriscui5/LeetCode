import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:yixiaolan
 * @date:Created in 2020/12/11
 * @description:
 * @version:1.0
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        //两种权力被禁止
        //禁止一名参议员的权利
        //宣布胜利
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();

        for (int i = 0 ; i<n ; i++){
            if(senate.charAt(i) == 'D'){
                dire.offer(i);
            }
            else {
                radiant.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()){
            int radiantIndex = radiant.poll();
            int direIndex = dire.poll();

            //Radiant(天辉)和 Dire(夜魇)
            if(direIndex>radiantIndex){
                radiant.add(radiantIndex+n);
            }
            else {
                dire.add(direIndex+n);
            }
        }
        return !radiant.isEmpty()? "Radiant" : "Dire";
    }
}
