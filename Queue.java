public class Queue {
    static class SimpleQueue {
        private int[] arr;
        private int size;
        private int rear = -1;
        private int front = -1;

        SimpleQueue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear+1)% size == front;
        }

        public void enqueue(int val) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++ ; 
            arr[rear] = val;
        }

         public int dequeue() {
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            int val = arr[0]; // store the front element to return
            // shift left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--; 
            return val;
        }

        public int peek() {
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
    }

}

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
