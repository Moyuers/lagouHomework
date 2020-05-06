//2.编程找出 1000 以内的所有完数并打印出来。 所谓完数就是一个数恰好等于它的因子之和，如：6=1＋2＋3
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("0~1000中所有完数为：");
        for(int i=2;i<1000;i++){
            int sum=0;//存放该数所有因子的和
            for(int j=1;j<i;j++){
                if(i%j==0){
                    sum+=j;
                }
            }//循环找出所有因子并相加
            if(sum==i){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
