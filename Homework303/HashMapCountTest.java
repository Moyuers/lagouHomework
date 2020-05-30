package Homework303;

import java.util.HashMap;

public class HashMapCountTest {
    public static void main(String[] args) {
        HashMap<String,Integer> count=new HashMap<>();
        String str="123,456,789,123,456";
        String strS[]=str.split(",");//切割字符串
        for(int i=0;i<strS.length;i++){
            if (!count.containsKey(strS[i])){
                count.put(strS[i],1);
            }else {
                count.put(strS[i],count.get(strS[i])+1);
            }
        }
        System.out.println(count);
        count.forEach((i,s) -> System.out.println(i+"出现了"+s+"次"));
    }
}
