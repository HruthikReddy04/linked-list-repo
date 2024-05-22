
public class DoublyLL {
    // It is encapsulated so that in future we can make ir private.data is binded
    // with methods.providing methods in the main class that manage how nodes are
    // created, linked, and modified, thereby preventing misuse.Keeping the Node
    // class within the main class can enhance code readability by showing that the
    // Node is closely related to the main class.
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    private int size;

    public void insertStart(int data) {
        Node temp = head;
        if (temp == null) {
            head = new Node(data);
            size++;
            return;
        }

        Node newNode = new Node(data);
        size++;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    public void insertEnd(int data) {
        Node temp = head;

        if (temp == null) {
            head = new Node(data);
            size++;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(data);
        size++;
        temp.next = newNode; // Connecting node to tail node
        newNode.prev = temp;

    }

    public void insertAtPos(int data, int pos) {
        if (pos == 0) {
            insertStart(data);
            return;
        }
        if (pos == size) {
            insertEnd(data);
        }
        int count = 0;
        Node prev = head;

        while (count < pos - 1) {
            prev = prev.next;
            count++;
        }

        Node then = prev.next;
        Node newNode = new Node(data);

        newNode.next = then;
        newNode.prev = prev;

        prev.next = newNode;
        then.prev = newNode;

    }

    public void deleteStart() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        head = head.next;

        head.prev = null;

    }

    public void deleteEnd() {

        Node temp = head;

        if (temp == null || temp.next == null) {
            head = null;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp = null;
    }

    public void deleteAtPos(int pos) {
        Node temp = head;

        if (temp == null) {
            return;
        }

        int count = 0;

        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }

        if (temp.prev == null) {
            deleteStart();
            return;
        }

        temp.prev.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

    }

    public void display() {
        Node temp = head;
        System.out.print("NULL <- ");
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String args[]) {
        DoublyLL ll = new DoublyLL(); // This encapsulates Node class(data + methods)

        for (int i = 0; i < 3; i++) {
            ll.insertStart(i);
            ll.insertEnd(i + 1);
        }

        // System.out.println(ll.size);
        // ll.deleteStart();
        // ll.deleteEnd();
        // ll.deleteAtPos(2);
        // l.deleteAtPos(0);
        // ll.deleteAtPos(4);
        ll.insertAtPos(5, 3);

        ll.display();
    }
}
