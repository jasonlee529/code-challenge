package cn.lee.base;

public class ArrayReverse {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for(int i=2;i<6;i++){
            Node n = new Node(i);
            cur.next(n);
            cur=n;
        }
//        head = head.next(new Node(2));
//        head = head.next(new Node(3));
//        head = head.next(new Node(4));
//        head = head.next(new Node(5));
//        while (head !=null) {
//            System.out.println(head);
//            head = head.next();
//        }
        System.out.println("back");
        Node nHead = back(head);
        while (nHead !=null) {
            System.out.println(nHead);
            nHead = nHead.next();
        }
    }

    private static Node back(Node head) {
        if (null == head || null == head.next())
            return head;
        Node pre = head;
        Node cur = head.next();
        while (cur.hasNext()) {
            Node tmp = cur.next();
            cur.next(pre);
            pre = cur;
            cur = tmp;
        }
        cur.next(pre);
        head.next(null);
        return cur;
    }


}

class Node {
    int v;
    Node n;

    Node(int v) {
        this.v = v;
        n=null;
    }
    public Node next(){
        return n;
    }
    public Node next(Node next) {
        this.n = next;
        return n;
    }

    public boolean hasNext() {
        return this.n != null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.v);
    }
}