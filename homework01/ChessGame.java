package Homework01;

import java.util.Arrays;

public class ChessGame {
    private byte[][] chess = new byte[16][16];//标记五子棋盘
    //绘制棋盘
    public void draw(){
        //输出棋盘坐标行
        System.out.print("  ");
        for (int i=0;i<16;i++){
            System.out.print(Integer.toHexString(i)+" ");
        }
        System.out.println();
        //输出棋盘
        for (int i=0;i<chess.length;i++){
            System.out.print(Integer.toHexString(i)+" ");//棋盘坐标列
            for(int j=0;j<chess[i].length;j++){
                //根据数组中值判断输出棋盘填充
                if(0==chess[i][j]){
                    System.out.print("+ ");
                }else if (1==chess[i][j]){
                    System.out.print("○ ");
                }else if(-1==chess[i][j]){
                    System.out.print("● ");
                }
            }
            System.out.println();
        }
    }
    //双方下棋
    public boolean play(int x,int y,byte flag){
        if (chess[x][y]!=0){
            System.out.println("该位置已有棋子,请重新输入：");
            return false;
        }
        chess[x][y]=flag;
        return true;
    }//方法的返回值判断棋子输入是否合理
    //判断输赢
    public boolean isWin(int x,int y){
        int count=1;//计数判断
        //左右方向
        for(int i=y-1;i>y-5&&i>=0;i--){
            if(chess[x][i]==chess[x][y]){
                count++;
            }else{
                break;
            }
        }//左
        for(int i=y+1;i<y+5&&i<chess[x].length;i++){
            if(chess[x][i]==chess[x][y]){
                count++;
            }else{
                break;
            }
        }//右
        if(count>=5){
            return true;
        }else{
            count=1;
        }
        //上下方向
        for(int i=x-1;i>x-5&&i>=0;i--){
            if(chess[i][y]==chess[x][y]){
                count++;
            }else{
                break;
            }
        }//上
        for(int i=x+1;i<x+5&&i<chess.length;i++){
            if(chess[i][y]==chess[x][y]){
                count++;
            }else{
                break;
            }
        }//下
        if(count>=5){
            return true;
        }else{
            count=1;
        }
        //左上到右下
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){
            if (chess[i][j]==chess[x][y]){
                count++;
            }else {
                break;
            }
        }//左上
        for(int i=x+1,j=y+1;i<chess.length&&j<chess[i].length;i++,j++){
            if (chess[i][j]==chess[x][y]){
                count++;
            }else {
                break;
            }
        }//右下
        if (count>=5){
            return true;
        }else{
            count=1;
        }
        //左下到右上
        for(int i=x-1,j=y+1;i>=0&&j<chess[i].length;i--,j++){
            if (chess[i][j]==chess[x][y]){
                count++;
            }else {
                break;
            }
        }//左下
        for(int i=x+1,j=y-1;i<chess.length&&j>=0;i++,j--){
            if (chess[i][j]==chess[x][y]){
                count++;
            }else {
                break;
            }
        }//右上
        if (count>=5) return true;
        return false;
    }
}
