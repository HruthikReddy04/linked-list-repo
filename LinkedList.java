public class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    private int size;

    LinkedList() {
        this.size = 0;
    }

    public void insertAtStart(int data) {
        Node t = new Node(data);
        size++;

        if (head == null) {
            head = t;
            return;
        }

        t.next = head;
        head = t;

    }

    public void insertAtMiddle(int data, int pos) {
        int count = 0;
        Node temp = head;
        Node newNode = new Node(data);
        size++;
        if (temp == null || pos == 0) {
            insertAtStart(data);
        } else if (temp.next == null) {
            insertAtEnd(data);
        } else {
            while (count < pos - 1) {
                count++;
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public void insertAtEnd(int data) {
        Node t = new Node(data);
        size++;

        if (head == null) {
            head = t;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = t;

    }

    public void deleteFirst() {
        // edge case
        if (head == null) {
            System.out.println("The list is Empty");
            return;
        }

        head = head.next;
        size--;
    }

    public void deleteLast() {
        // edge case
        if (head == null) {
            System.out.println("List is Empty ");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null;
    }

    public boolean iterSearch(int ele) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == ele) {
                return true;
            }
            temp = temp.next;
        }

        return false;

    }

    public boolean recSearch(int ele, Node head) {
        // base case
        if (head == null) {
            return false;
        }

        if (head.data == ele) {
            return true;
        }

        return recSearch(ele, head.next);
        // recursive case
    }

    public void reverse() {
        Node curr = head;
        Node next = curr;
        Node prev = null;

        while (curr != null) { // Updating the next pointer
            next = curr.next;

            // Reversing the pointer
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public void getSize() {
        System.out.println(size);
    }

    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.insertAtStart(1);
        // list.display();
        list.insertAtEnd(2);
        // list.display();
        list.insertAtEnd(3);
        // list.display();
        list.insertAtMiddle(4, 3);
        // list.display();
        list.deleteFirst();
        // list.display();
        list.deleteLast();
        list.display();
        list.getSize();

    }
}