public class Stack {
    
        private int maxSize;
        private int[] stackArray;
        private int top;
    
        public Stack(int size) {
            this.maxSize = size;
            this.stackArray = new int[maxSize];
            this.top = -1; // indicates an empty stack
        }
    
        public void push(int value) {
            if (top < maxSize - 1) {
                top++;
                stackArray[top] = value;
            } else {
                System.out.println("Stack is full. Cannot push " + value);
            }
        }
    
        public int pop() {
            if (top >= 0) {
                int value = stackArray[top];
                top--;
                return value;
            } else {
                System.out.println("Stack is empty. Cannot pop.");
                return -1; // or throw an exception
            }
        }
    
        public int peek() {
            if (top >= 0) {
                return stackArray[top];
            } else {
                System.out.println("Stack is empty. Cannot peek.");
                return -1; // or throw an exception
            }
        }
    
        public boolean isEmpty() {
            return (top == -1);
        }


        public boolean isFull() {
            return (top == maxSize - 1);
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            } else {
                System.out.print("Stack (top to bottom): ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stackArray[i] + " ");
                }
                System.out.println();
            }
        }


        public int size() {
            return top + 1;
        }

        public static void main(String[] args) {
            Stack stack = new Stack(5);
    
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
    
            stack.display();
    
            System.out.println("Popped value: " + stack.pop());
            System.out.println("Top value: " + stack.peek());
    
            stack.display();
        }

}
