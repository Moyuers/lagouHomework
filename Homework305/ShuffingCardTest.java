package Homework305;

import java.util.*;

public class ShuffingCardTest {
    public static void main(String[] args) {
        CardType[] ct=CardType.values();//牌类型
        String cardNum[]={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};//牌点数
        Map<Integer,String> card=new LinkedHashMap<>();//存放牌及其大小顺序
        card.put(0,"大王");
        card.put(1,"小王");
        //存放所有牌
        for (int i=2;i<54;i++){
            String value=ct[(i-2)%4]+cardNum[(i-2)/4];
            card.put(i,value);
        }
        //card.forEach((i,s) -> System.out.println("序号"+(i+1)+"的牌是:"+s));//输出已存好的牌
        //编号作为数组并洗牌
        List<Integer> cards=new ArrayList<>();
        for(int i=0;i<54;i++){
            cards.add(i);
        }
        Collections.shuffle(cards);
        //三个玩家和底牌
        List<Integer> player1=new ArrayList<>();
        List<Integer> player2=new ArrayList<>();
        List<Integer> player3=new ArrayList<>();
        List<Integer> end=new ArrayList<>();//底牌
        for(int i=0;i<cards.size();i++){
            Integer getCard=cards.get(i);
            if (i>=cards.size()-3){
                end.add(getCard);
            }else{
                if(i%3==0){
                    player1.add(getCard);
                }else if(i%3==1){
                    player2.add(getCard);
                }else {
                    player3.add(getCard);
                }
            }
        }
        //展示所有玩家的牌和底牌同时排序输出
        System.out.print("玩家一：");
        show(player1,card);
        System.out.print("玩家二：");
        show(player2,card);
        System.out.print("玩家三：");
        show(player3,card);
        System.out.print("底牌：");
        show(end,card);
    }
    //排序并展示各个玩家和底牌方法
    public static void show(List<Integer> l,Map<Integer,String> card){
        Collections.sort(l);
        for(Integer each:l){
            System.out.print(card.get(each)+",");
        }
        System.out.println();
    }
}
