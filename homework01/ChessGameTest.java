package Homework01;

import java.util.Scanner;

public class ChessGameTest {
    public static void main(String[] args) {
        ChessGame cg = new ChessGame();
        cg.draw();
        System.out.println("请双方开始下棋：");
        Scanner s=new Scanner(System.in);
        int x,y;
        byte flag=1;
        while(true){
            if(flag==1){
                System.out.println("白方下棋，输入坐标：");
            }else{
                System.out.println("黑方下棋，输入坐标：");
            }
            while(true){
                x=Integer.parseInt(s.next(),16);
                y=Integer.parseInt(s.next(),16);
                if (cg.play(x,y,flag)==true) break;
            }
            cg.draw();
            boolean win=cg.isWin(x,y);
            if(win==true){
                if(flag==1) System.out.println("白方获胜");
                else if(flag==-1) System.out.println("黑方获胜");
                break;
            }
            flag*=-1;
        }
    }
}
