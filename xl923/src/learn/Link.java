package learn;

class Node {
    private Node next;
    private String data;

    public Node(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}

// Node 节点 处理逻辑
class Process {
    private Node root;

    public void add(Node node) {

    }

}

public class Link {
    public static void main(String ags[]) {
        Node root = new Node("头节点");
        Node data1 = new Node("data1");
        Node data2 = new Node("data2");
        root.setNext(data1);
        data1.setNext(data2);
        Node curentNode = root;
        print(root);

//        方法一  获取所有数据
//        while (curentNode != null){
//            System.out.println(curentNode.getData());
//            curentNode = curentNode.getNext();
//        }

    }

    //    方法二 获取所有数据
    public static void print(Node currentNode) { //这个 为什么 要加static 因为 他被主方法 调用所以 必须要加static 不需要实例化对象
        if (currentNode == null) return;
        System.out.println(currentNode.getData());
        print(currentNode.getNext());
        return;
    }
}