package Homework302;

import java.util.Scanner;

public class MaxSubStringTest {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入两个字符串(以换行结尾)：");
        String str1=s.nextLine();
        String str2=s.nextLine();
        //字符串长度长的在前方便之后统一
        if (str1.length()<str2.length()){
            String temp=str1;
            str1=str2;
            str2=temp;
        }
        String maxSubString=null;//存放最大子字符串
        te:
        for (int i=str2.length();i>0;i--){
            for(int j=0;j<=str2.length()-i;j++){
                String tempStr=str2.substring(j,j+i);
                if (-1!=str1.indexOf(tempStr)){
                    maxSubString=tempStr;
                    break te;
                }
            }
        }
        if (maxSubString.isEmpty()){
            System.out.println(str1+"和"+str2+"没有最大子字符串");
        }else {
            System.out.println(str1+"和"+str2+"的最大子字符串是："+maxSubString);
        }
    }
}
