class LinkedList {

    // creating a node class to represent each node in the linked list

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // creating a linked list class to perform operations on the linked list

    // head of the linked list
    Node head;

    // method to insert a new node at the end of the linked list
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head; // initially temp points to the head of the linked list

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // display the linked list

    void display() {

        Node temp = head; // temp is just a pointer to traverse the linked list starting from the head

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // store the next node
            current.next = prev; // reverse the current node's pointer

            // update

            prev = current; // move prev to the current node
            current = next; // move to the next node
        }

        head = prev; // update head to the new first node
    }

    public void reverseRecursive() {
        head = reverseRecursive(head); // update head to the new first node after reversing
    }

    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }


    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insertAtEnd(10);
        ll.insertAtEnd(20);
        ll.insertAtEnd(30);

        ll.display();
        ll.insertAtBeginning(5);
        ll.display();
        ll.insertAtPosition(25, 2);
        ll.display();
        // ll.reverse();
        ll.display();
        ll.reverseRecursive();
        ll.display();
    
    }

}

