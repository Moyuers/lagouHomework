//3.实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。 其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。 其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
import java.util.Arrays;
import java.util.Random;

public class PrizeNum {
    public static void main(String[] args) {
        Random ra = new Random();
        int[] prizeNum = new int[7];//前6个元素是红球，最后一个元素是蓝球
        for(int i=0;i<prizeNum.length-1;i++){
            prizeNum[i]=ra.nextInt(32)+1;
        }//生成红球号码
        prizeNum[prizeNum.length-1]=ra.nextInt(15)+1;//生成蓝球号码
        //输出中奖号码
        System.out.print("中奖号码为：");
        System.out.println(Arrays.toString(prizeNum));
    }
}
