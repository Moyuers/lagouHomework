//编程题1：提示用户输入年月日信息，判断这一天是这一年中的第几天并打印
import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        //建立数组存储普通年份到该月初是一年的第几天
        int[] dayNum = new int[12];
        for(int i=1;i<dayNum.length;i++){
            dayNum[i]=dayNum[i-1]+31;
            if(2==i){
                dayNum[i]-=3;
            } else if(4==i||6==i||9==i||11==i){
                dayNum[i]-=1;
            }
        }
        //提示用户输入年月日
        Scanner s = new Scanner(System.in);
        System.out.println("请输入年份:");
        int year=s.nextInt();
        System.out.println("请输入月份:");
        int month=s.nextInt();
        System.out.println("请输入几号:");
        int day=s.nextInt();
        //判断是否是闰年
        boolean isLeapYear = false;
        if((year%4==0&&year%100!=0)||year%400==0){
            isLeapYear = true;
        }
        //计算第几天并输出
        int days;
        if(true==isLeapYear&&month>=3){
            days=dayNum[month-1]+day+1;
        }else{
            days=dayNum[month-1]+day;
        }
        System.out.println("该日期是这一年中的第"+days+"天");
    }
}
