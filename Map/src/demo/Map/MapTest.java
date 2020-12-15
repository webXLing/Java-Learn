package demo.Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
    计算字符串 中 每个字符出现的次数

    1.通过Scanner 获取用户的 字符串

 */
public class MapTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("清除如一个字符串");
        String str = sc.next();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }

        }
        Set<Character> characters = hashMap.keySet();
        for (Character character : characters) {
            System.out.println(character + "=" + hashMap.get(character));
        }

//        System.out.println(hashMap);

    }
}
