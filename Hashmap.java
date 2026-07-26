class HashMap {

    static class Node {
        int key;
        int value;

        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets = new Node[10];

    private int hash(int key) {
        return key % buckets.length; // eg for key=12, index=2  
    }

    public void put(int key, int value) {
        int index = hash(key); // get the index for the key

        Node head = buckets[index]; // get the head of the linked list at the calculated index

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        // If the key is not found, create a new node and add it to the front of the linked list
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);

        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return -1;
    }


    public void remove(int key) {
        int index = hash(key);

        Node head = buckets[index];
        Node prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    buckets[index] = head.next; // Removing the head of the linked list
                } else {
                    prev.next = head.next; // Bypass the node to be removed
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void clear() {
        buckets = new Node[10]; // Reset the buckets array to clear all entries
    } 

     
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            Node head = buckets[i];
            while (head != null) {
                System.out.println("Key: " + head.key + ", Value: " + head.value);
                head = head.next;
            }
        }
    }


    public void isEmpty() {
        for (Node bucket : buckets) {
            if (bucket != null) {
                System.out.println("HashMap is not empty.");
                return;
            }
        }
        System.out.println("HashMap is empty.");
    }



    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(111, 1);
        hashMap.put(21111, 2);
        System.out.println(hashMap.get(111)); // returns 1
        System.out.println(hashMap.get(21111)); // returns 2
        hashMap.put(21111, 3); // update the existing value
        System.out.println(hashMap.get(21111)); // returns 3
        hashMap.display();
    }
}