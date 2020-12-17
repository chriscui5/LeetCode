import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:yixiaolan
 * @date:Created in 2020/8/27
 * @description:
 * @version:1.0
 */
public class Solution {


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();

        Map<Character, String> phoneMap = new HashMap<Character, String>() {};


        if (digits.length() == 0) {
            return combinations;
        }

       phoneMap.put('2', "abc");
       phoneMap.put('3', "def");
       phoneMap.put('4', "ghi");
       phoneMap.put('5', "jkl");
       phoneMap.put('6', "mno");
       phoneMap.put('7', "pqrs");
       phoneMap.put('8', "tuv");
       phoneMap.put('9', "wxyz");

       if (digits.length() == 0) {
           return combinations;
       }

       backtrack(digits,0,new StringBuffer());

       return combinations;
    }

    public void backtrack(String digits, int index, StringBuffer combination){
        if(index==combination.length()){
            combinations.add(combination.toString());
        }
        else {
            char digit = digits.charAt(index);

            String letters = phoneMap.get(digit);

            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) {

                combination.append(letters.charAt(i));
                backtrack(digits, index + 1, combination);
                combination.deleteCharAt(index);

            }
        }
    }
}
