/**
 * @author:yixiaolan
 * @date:Created in 2020/12/10
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int num_of_five = 0;
        int num_of_ten = 0;
        int num_of_twenty = 0;
        for (int bill:bills){
            if(bill == 5){
                num_of_five++;
            }
            else if(bill == 10){
                if(num_of_five == 0){
                    return false;
                }
                num_of_five--;
                num_of_ten++;
            }
            else if(bill == 20){
                if( num_of_ten > 0 || num_of_five>0){
                    num_of_five--;
                    num_of_ten--;
                    num_of_twenty++;
                }
                else if(num_of_five >=3){
                    num_of_five -=3;
                    num_of_twenty++;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
