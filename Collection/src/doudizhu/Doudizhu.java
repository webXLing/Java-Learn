package doudizhu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/*
斗地主综合案例
1.准备牌
2、洗牌
3.发牌
 */
public class Doudizhu {
    public static void main(String[] args) {
        // 1.   准备牌
        //     容器
        ArrayList<String> pokers = new ArrayList<>();

        String[] colors = {"♥", "♣", "♠", "方块"};
        String[] numbers = {"2", "A", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        pokers.add("大王");
        pokers.add("小王");

        for (int i = 0; i < numbers.length; i++) {
            for (int i1 = 0; i1 < colors.length; i1++) {
                pokers.add(colors[i1] + numbers[i]);
//                System.out.println(colors[i1]+numbers[i]);
            }
        }
//        System.out.println(pokers);

        //2 .洗牌  集合的工具类 shuffle
        Collections.shuffle(pokers);
//        System.out.println(pokers);

        //3.发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dp = new ArrayList<>();

        Iterator<String> iterator = pokers.iterator();
        for (int i = 0; i < pokers.size(); i++) {

            String value = pokers.get(i);// 获取牌
            if (i > 50) {
                dp.add(value);
            } else if (i % 3 == 0) {
                player1.add(value);
            } else if (i % 3 == 1) {
                player2.add(value);

            } else if (i % 3 == 2) {
                player3.add(value);
            }

        }
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dp);

    }

}
