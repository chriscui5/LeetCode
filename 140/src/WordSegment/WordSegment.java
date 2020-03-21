package WordSegment;

import java.util.*;

public class WordSegment {
    private Map<String, Double> word_prob;
    private String word_list;
    private List<Integer> word;
    public WordSegment(){
        word_prob=new HashMap<>();
        word_list= "";
        word =new ArrayList<Integer>();
    }
   /* {"北京":0.03,"的":0.08,"天":0.005,"气":0.005,"天气":0.06,
   "真":0.04,"好":0.05,"真好":0.04,"啊":0.01,"真好啊":0.02,
            "今":0.01,"今天":0.07,"课程":0.06,"内容":0.06,"有":0.05,"很":0.03,"很有":0.04,"意思":0.06,
            "有意思":0.005,"课":0.01,
            "程":0.005,"经常":0.08,"意见":0.08,"意":0.01,"见":0.005,"有意见":0.02,"分歧":0.04,"分":0.02, "歧":0.005}*/

    public static void main(String[] args){

        WordSegment ws = new WordSegment();

        ws.word_list="今天天气真好";

        for (int i=0;i<ws.word_list.length();i++){
            ws.word.add(-1);
        }

        ws.word_prob.put("北京",0.03);
        ws.word_prob.put("的",0.08);
        ws.word_prob.put("天",0.005);
        ws.word_prob.put("气",0.005);
        ws.word_prob.put("天气",0.06);
        ws.word_prob.put("真",0.04);
        ws.word_prob.put("好",0.05);
        ws.word_prob.put("真好",0.04);
        ws.word_prob.put("啊",0.01);
        ws.word_prob.put("真好啊",0.02);
        ws.word_prob.put("今",0.01);
        ws.word_prob.put("今天",0.07);
        ws.word_prob.put("课程",0.06);
        ws.word_prob.put("内容",0.06);
        ws.word_prob.put("有",0.05);
        ws.word_prob.put("很",0.03);
        ws.word_prob.put("很有",0.04);
        ws.word_prob.put("意思",0.06);
        ws.word_prob.put("有意思",0.005);
        ws.word_prob.put("课",0.01);
        ws.word_prob.put("程",0.005);
        ws.word_prob.put("经常",0.08);
        ws.word_prob.put("意见",0.08);
        ws.word_prob.put("意",0.01);
        ws.word_prob.put("见",0.005);
        ws.word_prob.put("有意见",0.02);
        ws.word_prob.put("分歧",0.04);
        ws.word_prob.put("分",0.02);
        ws.word_prob.put( "歧",0.005);


    }
    public void segWord(int begin,int end){
        if(begin>end){
            return;
        }
        else{
            for (int i=0;i<=3;i++){

                if(findWord(word_list.substring(begin,begin+i))){

                }
            }
        }

    }
    public boolean findWord(String str){
        Double value;
        value=word_prob.get(str);
        if(value != null) {
            return  true;
        }
        return false;
    }
    public void printWordSegment(){

        for (int i=0;i<word_list.length();i++){
            if(word_list.indexOf(i)==-1&&i!=0){
                System.out.println(",");
            }
            System.out.println(word_list.indexOf(i));
        }
        System.out.println("\n");

    }
}
