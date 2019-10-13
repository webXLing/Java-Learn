package demo3;

import java.util.ArrayList;
import java.util.List;

public class Arr {
    public static void main(String[] args) {
        // 多态写法
        // 左边是接口名 右边是实现类名称
        List<String> list = new ArrayList<>();
        List<String> res = setList(list);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<String> setList(List<String> list){
        list.add("1");
        list.add("加油");
        list.add("XL");
        return list;
    }
}
