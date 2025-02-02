package LinkedList;

class CircularLL {
    Node head;

    private class Node {
        Node next;
        Node prev;
        int data;
        Node (int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    CircularLL () {
        this.head = null;
    }
    void append(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            node.next = head;
            node.prev = head;
        }
        else {
            Node temp = head;
            while (temp.next != head) temp = temp.next;
            node.next = head;
            node.prev = temp;
            temp.next = node;
            head.prev = node;
        }
    }
    void display () {
        Node temp = head;
        while (temp.next != head.next){
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
    }
    void insertFirst (int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        head = node;
    }
    public static void main(String[] args) {
        CircularLL LL = new CircularLL();
        LL.append(1);
        LL.append(2);
        LL.append(3);
        LL.append(4);
        LL.display();
        LL.insertFirst(0);
        LL.display();
    }
}

