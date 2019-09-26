package LinkLearn;

class Book{
    private double price;
    private String name;

    public Book (double price,String name){
        this.name = name;
        this.price = price;
    }

    public String getInfo(){
        return "图书名称："+ this.name + "图书的价格："+ this.price;
    }

    public boolean compareTo(Book book){
        if(book == null){
            return false;
        }
        if(this == book){
            return true;
        }
        if(this.name.equals(book.name) && this.price == book.price){
            return true;
        }
        return false;
    }
}

class Link{ // 链表类  外部可见
    private class Node{ // 内部类
        public Book data; // 保存的类型
        private Node next;
        public Node(Book data){
            this.data = data;
        }

        public void addNode(Node newNode){
            if(this.next == null){
                this.next = newNode;
            }else{
                this.next.addNode(newNode);
            }
        }

        public boolean containsNode(Book data){
            if(data.compareTo(this.data)){// 当前节点就是目标节点
                return true;
            }else{
                if(this.next!=null){ // 下个节点 不为空继续查找
                   return this.next.containsNode(data);
                }else{
                    return false; //没有下个节点了
                }
            }
        }

        public Book getNode(int index){
            if(Link.this.foot++ == index){
                return this.data;
            }else{
                return this.next.getNode(index);
            }
        }

        public void setNode(int index,Book data){
            if(Link.this.foot++ == index){
                this.data = data;
            } else{
                  this.next.setNode(index,data);
            }
        }

        public void removeNode(Node prevous,Book data){
           if(data.compareTo(this.data)){ // 该node 节点就是 要删除的节点  该节点的上个节点 指向 该节点的下一个节点
              prevous.next = this.next;
           }else{
               this.next.removeNode(this,data);
           }
        }

        // 第一次 Link.root
        //第二次  Link.root.next
        public void  toArrayNode(){
            Link.this.retArr[Link.this.foot++] = this.data;
            if(this.next!=null){
                this.next.toArrayNode();
            }
        }
    }

    private Node root;
    private int count = 0;
    private int foot;
    private Book [] retArr;

    //增加节点
    public void add(Book data){
        if(data == null)return;
        Node node = new Node(data);
        if(this.root == null){
            this.root = node;
        }else{
            this.root.addNode(node);
        }
        this.count++;
    }

    //    获取长度
    public int size(){
        return this.count;
    }

    //    判断是否为空链表
    public boolean isEmpty(){
        return this.count == 0;
    }

    //    数据查询 是否存在
    public boolean contains(Book data){
        if(data == null || this.root == null) return false;
        return this.root.containsNode(data);
    }

    //  通过索引  查询数据
    public Book get(int index){
        this.foot = 0;
        if(index>this.count){
            return null;
        }else{
           return this.root.getNode(index);
        }
    }

    //  修改数据
    public void set(int index,Book data){
        if(this.count<index+1) return;
        this.foot = 0;
        this.root.setNode(index,data);
    }

    //  删除数据
    public void remove(Book data) {
        if (data == null||this.count==0)return;
        if(this.contains(data)){//含有目标元素
           if(data.equals(this.root.data)){
            //.删除的根节点 根节点指向下个节点 Link关心 根节点
               this.root = this.root.next;
           }else{
               this.root.next.removeNode(this.root,data);
           }
           this.count--;
        }

        
        //.删除的普通节点 当前节点的上个节点的next指向 当前节点的next
    }


    public Book [] toArray(){
        if(this.root == null){
            return null;
        }
        this.foot=0;
        this.retArr = new Book[this.count];
        this.root.toArrayNode();
        return this.retArr;
    }
}
public class LinkDemo {
    public static void main(String[] args) {
        Link link = new Link();
        link.add(new Book(0.0,"node1"));
        link.add(new Book(1,"node1"));
        link.add(new Book(2,"node1"));
        link.add(new Book(4,"node1"));
//        System.out.println(link.size());
//        System.out.println(link.isEmpty());
//        System.out.println(link.contains("nihao3"));
//        System.out.println(link.contains("niha"));
        System.out.println(link.get(3).getInfo());
//        link.set(1,"da");
        System.out.println(link.size());

        System.out.println(link.contains(new Book(1,"node1")));
        for (int i = 0; i < link.toArray().length; i++) {
            System.out.println(link.toArray()[i]);
        }
    }
}
