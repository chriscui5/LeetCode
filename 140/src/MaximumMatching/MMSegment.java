package MaximumMatching;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
public class MMSegment {

    private String request;
    private int MAX_LENGTH = 5;
    private static Set<String> dictionary;

    public void getDictionary() {
        dictionary = new HashSet<String>();
        String dicpath = "data/worddict2.txt";
        String line = null;

        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dicpath),"gbk"));
            try {
                while(((line = br.readLine())!=null)) {
                    String[] str = line.split("\\s+");
                    line = str[1];
                    dictionary.add(line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addWord(String str) {
        dictionary.add(str);
    }

    public List<String> leftMax() {

        List<String> results = new ArrayList<String>();
        String input = request;

        while( input.length() > 0 ) {

            String subSeq;
            if( input.length() < MAX_LENGTH)
                subSeq = input;
            else
                subSeq = input.substring(0, MAX_LENGTH);

            while( subSeq.length() > 0 ) {
                if( dictionary.contains(subSeq) || subSeq.length() == 1) {
                    results.add(subSeq);
                    input = input.substring(subSeq.length());
                    break;
                } else {
                    subSeq = subSeq.substring(0, subSeq.length() - 1);
                }
            }

        }
        return results;
    }
    public List<String> rightMax() {

        Stack<String> store=new Stack<String>();
        List<String> results = new ArrayList<String>();
        String input = request;

        while( input.length() > 0 ) {

            String subSeq;
            if( input.length() < MAX_LENGTH)
                subSeq = input;
            else
                subSeq = input.substring(input.length() - MAX_LENGTH);

            while( subSeq.length() > 0 ) {
                if( dictionary.contains(subSeq) || subSeq.length() == 1) {
                    store.add(subSeq);
                    input = input.substring(0, input.length() - subSeq.length());
                    break;
                } else {
                    subSeq = subSeq.substring(1);
                }
            }
        }
        int size = store.size();
        for( int i = 0; i < size; i ++) {
            results.add(store.pop());
        }

        return results;
    }

    public List<String> segment() {
        List<String> fmm = this.leftMax();
        List<String> bmm = this.rightMax();

        if( fmm.size() != bmm.size()) {
            if ( fmm.size() > bmm.size())
                return bmm;
            else
                return fmm;
        }

        else {
            int fmmSingle = 0, bmmSingle = 0;
            boolean isEqual = true;
            for( int i = 0; i < bmm.size(); i ++) {
                if( !fmm.get(i).equals(bmm.get(i))) {
                    isEqual = false;
                }
                if( fmm.get(i).length() == 1)
                    fmmSingle ++;
                if( bmm.get(i).length() == 1)
                    bmmSingle ++;
            }

            if ( isEqual ) {
                return fmm;
            } else if ( fmmSingle > bmmSingle)
                return bmm;
            else
                return fmm;
        }
    }

    public void test(String str) {
        request = str;
        System.out.println(this.segment());
    }

    public static void main(String[] args) {
        MMSegment f = new MMSegment();
        f.getDictionary();
        f.test("研究生命科学");
        f.test("研究生命令本科生");
        f.test("我从马上下来");
        f.test("北京大学生喝进口红酒");
        f.test("美军中将竟公然说");
        f.test("阿美首脑会议将讨论巴以和平等问题");
        f.addWord("巴以和平");
        System.out.println("---------------------------");
        System.out.println("向字典中添加'巴以和平'后");
        f.test("阿美首脑会议将讨论巴以和平等问题");
        f.test("我不想吃东西");
    }

}
