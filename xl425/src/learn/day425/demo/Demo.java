package learn.day425.demo;

import learn.day425.demo.Student; //导包  如果在一个包下  可以不用谢导包语句

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo {
//    public Demo(){
//        Student st = new Student();
//        st.see();
//    }
    public static void main(String[] args) {
        Student st = new Student();
        st.see();
        //冒泡排序
        int [] ns = {1,28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        System.out.println(Arrays.toString(ns));
        for (int j=0 ;j<ns.length;j++){
            for (int i = 0; i < ns.length-j-1; i++) {
                if(ns[j+1]<ns[j]){
                    int temp = ns[j];
                    ns[j]=ns[j+1];
                    ns[j+1]=temp;
                }
            }
        }
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));


        int [][] ns1 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        for (int [] item:
                ns1) {
            System.out.println(item[0]);
        }
        System.out.println(Arrays.toString(ns1));
    }
}
