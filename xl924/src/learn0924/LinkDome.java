package learn0924;
class Node {
    private Node next;
    private String data;
    public Node(String data){
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

    public void addNode(Node newNode){
        if(this.next == null){
            this.next = newNode;
        }else{
            this.next.addNode(newNode);
        }
    }
    // 第一次调用时Link.root
    // 第二次 Node
    public void print(){
        System.out.println(this.data);
        if(this.next != null){
            this.next.print();
        }
    }

}

// Node 节点 处理逻辑
class Link{
    private Node root;

    public void add(String data){
        Node node = new Node(data);
        if(this.root == null ){
            this.root = node;
        }else{
            this.root.addNode(node);
        }

    }

    public void print(){
        if(this.root != null ){
            this.root.print();
        }
    }

}
public class LinkDome {
    public static void main(String[] args) {
        Link link = new Link();
        link.add("nihao");
        link.add("nihao2");
        link.add("nihao3");
        link.add("nihao4");
        link.print();
    }
}
