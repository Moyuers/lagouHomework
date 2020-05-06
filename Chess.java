//使用二维数组和循环实现五子棋游戏棋盘的绘制
import java.util.Arrays;

public class Chess {
    public static void main(String[] args) {
        //建立字符数组存放棋盘
        char[][] chess = new char[17][17];
        for(int i=0;i<chess.length;i++){
            Arrays.fill(chess[i],'+');
        }//先全部用+填充
        chess[0][0]=' ';
        //第一行与第一列内容填写
        for(int i=1;i<chess.length;i++){
            if(i<=10){
                chess[0][i]=(char)('0'+i-1);
                chess[i][0]=(char)('0'+i-1);
            }else{
                chess[0][i]=(char)('a'+i-11);
                chess[i][0]=(char)('a'+i-11);
            }
        }
        //遍历输出
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess[i].length;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }
}
