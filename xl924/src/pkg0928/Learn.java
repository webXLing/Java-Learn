package pkg0928;

import java.util.Arrays;

class Array {
    private int[] data;
    private int foot = 0;

    public Array(int len) {
        if (len > 0) {
            this.data = new int[len];
        } else {
            this.data = new int[1];
        }
    }

    public boolean add(int num) {
        if (this.foot < this.data.length) {
            this.data[this.foot++] = num;
            return true;
        } else {
            return false;
        }
    }

    public int[] getData() {
        return this.data;
    }
}

// 排序数据
class SortArray extends Array {
    public SortArray(int len) {
        super(len);
    }

    //    覆写父类的getData
    public int[] getData() {
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}

//翻转数组
class ReversArray extends Array {
    public ReversArray(int len) {
        super(len);
    }

    public int[] getData() {
        int[] arr = super.getData();
        int center = arr.length / 2;
        int head = 0;
        int tail = arr.length - 1;
        for (int i = 0; i < center; i++) {
            int tem = arr[head];
            arr[head] = arr[tail];
            arr[tail] = tem;
            head++;
            tail--;
        }
        return super.getData();
    }

}

public class Learn {
    public static void main(String[] args) {
        ReversArray arr = new ReversArray(3);
        arr.add(10);
        arr.add(5);
        arr.add(4);
//        int [] arr1 = new int []{1,4324,4321,32,43};
//        java.util.Arrays.sort(arr1); // 会修改原数组
//        for (int i = 0; i <arr1.length ; i++) {
//            System.out.println(arr1[i]);
//        }
        int[] tem = arr.getData();
        for (int i = 0; i < tem.length; i++) {
            System.out.println(tem[i]);
        }


    }
}
