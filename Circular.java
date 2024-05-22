public class Circular {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    // private int size;

    public void insertStart(int data) {
        Node tail = head;
        Node newNode = new Node(data);

        if (tail == null) {
            newNode.next = newNode;
            head = newNode;
            return;
        }

        while (tail.next != head) {
            tail = tail.next;
        }

        // tail.next = head;

        newNode.next = head;
        tail.next = newNode;
        head = newNode;

    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        Node tail = head;

        if (tail == null) {
            insertStart(data);
            return;
        }

        while (tail.next != head) {
            tail = tail.next;
        }

        tail.next = newNode;
        newNode.next = head;

    }

    public void deleteStart() {
        Node tail = head;

        while (tail.next != head) {
            tail = tail.next;
        }

        tail.next = head.next;
        head = tail.next;
    }

    public void delete(int pos) {
        if (pos == 0) {
            deleteStart();
        }
        Node btail = head;
        int count = 0;

        while (count < pos - 1) {
            btail = btail.next;
            count++;
        }

        btail.next = btail.next.next;
    }

    public void display() {
        Node tail = head;

        do {
            System.out.print(tail.data + " -> ");
            tail = tail.next;
        } while (tail != head);
    }

    public static void main(String args[]) {
        Circular cl = new Circular();
        cl.insertStart(1);
        cl.insertEnd(2);
        cl.insertStart(3);
        cl.insertEnd(4);

        cl.deleteStart();
        cl.delete(1);
        cl.display();

    }
}
