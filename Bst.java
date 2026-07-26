class Bst{
       

   public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static Node insert(Node root, int data){
        if(root == null){
            return new Node(data); 
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right); 
        }
    }  

    public static void inrange(Node root, int low, int high){
        if(root == null){
            return;
        }
        if(root.data >= low && root.data <= high){
            inrange(root.left, low, high);
            System.out.print(root.data + " ");
            inrange(root.right, low, high);
        } else if(root.data < low){
            inrange(root.right, low, high);
        } else {
            inrange(root.left, low, high);
        }
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(key < root.data){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }


     public static Node findMin(Node root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static boolean delete(Node root, int key){

       
        if(root == null){
            return false;
        }

        if(key < root.data){

            return delete(root.left, key);

        } 
        else if(key > root.data){

            return delete(root.right, key);

        } else {

            if(root.left == null && root.right == null){      // Node to be deleted found
                root = null; // Case 1: No child

            } else if(root.left == null){

                root = root.right; // Case 2: One child (right) 

            } else if(root.right == null){

                root = root.left; // Case 2: One child (left)

            } else {

                // Case 3: Two children
                Node successor = findMin(root.right);  // Find the in-order successor (smallest in the right subtree)
                root.data = successor.data; // Replace with successor's data
                delete(root.right, successor.data); // Delete the successor

            }
            return true;
        }
    }

    public static void main(String[] args) {
        int val[] = {5, 3, 7, 2, 4, 6, 8};
        Node root = null;
        for(int v : val){
            root = insert(root, v);
        }

             inorder(root);

        System.out.println();
        int key = 4;    
        if(search(root, key)){
            System.out.println("Found " + key);
        } else {
            System.out.println(key + " not found in the BST");
        } 

        int deleteKey = 3;
        if(delete(root, deleteKey)){
            System.out.println("Deleted " + deleteKey);
        } else {
            System.out.println(deleteKey + " not found in the BST");
        }
         inorder(root);
    }
        
}