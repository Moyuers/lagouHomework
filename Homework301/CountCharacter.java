package Homework301;

public class CountCharacter {
    public static void main(String[] args) {
        int count[]=new int[4];//建立一维数组存放统计数据
        String str="ABCD123!@#$%ab";//需要处理的字符串
        for(int i=0;i<str.length();i++){
            if (Character.isUpperCase(str.charAt(i))){
                count[0]++;
            }else if(Character.isLowerCase(str.charAt(i))){
                count[1]++;
            }else if(Character.isDigit(str.charAt(i))){
                count[2]++;
            }else{
                count[3]++;
            }
        }
        ChararcterType ct[]=ChararcterType.values();
        for (int i=0;i<count.length;i++){
            System.out.println(ct[i]+"的个数是："+count[i]);
        }
    }
}
