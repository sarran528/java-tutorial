public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    LinkedList() {
        head = null;
    }

    public void insertAtBeginning(int val) {
        Node newNode = new Node(val);

        if (head == null)//empty list
            head = newNode;

        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;


        }
        System.out.println();

    }

    public void insertAtPos(int pos, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new IllegalArgumentException();
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteAtPos(int pos) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Deleted attempted on a empty list");
        }

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 1; i <= pos; i++) {
            if (temp == null) {
                throw new IllegalArgumentException("Invalid position: " + pos);
            }
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }


}

