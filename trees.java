// import java.util.LinkedList;
// import java.util.Queue;

// class Trees {
//     static class Node {
//         int data;
//         Node left;
//         Node right;

//         Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static int height(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }
     
//     public static void levelorder(Node root){
//         if (root == null) {
//             return;
//         }
//          Queue<Node> queue = new LinkedList<>();
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             int levelSize = queue.size();
//             for (int i = 0; i < levelSize; i++) {
//                 Node current = queue.poll();
//                 System.out.print(current.data + " ");

//                 if (current.left != null) {
//                     queue.add(current.left);
//                 }
//                 if (current.right != null) {
//                     queue.add(current.right);
//                 }
//             }
//             System.out.println();
//         }
//     }

//         int countNodes(Node root) {
//             if (root == null) {
//                 return 0;
//             }
//             int leftCount = countNodes(root.left);
//             int rightCount = countNodes(root.right);
//             return leftCount + rightCount + 1;
//         }
    
//         int sumofnodes(Node root){
//             if (root == null) {
//                 return 0;
//             }
//             int leftSum = sumofnodes(root.left);
//             int rightSum = sumofnodes(root.right);
//             return leftSum + rightSum + root.data;
//         }
     
//        public static int diameter(Node root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         int leftDiameter = diameter(root.left);
//         int rightDiameter = diameter(root.right);
//         return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter)); 
        
//        }

//        // for linear time complexity of diameter, we can use a helper class to store height and diameter together
//          static class TreeInfo {
//           int height;
//           int diameter;
    
//           TreeInfo(int height, int diameter) {
//                 this.height = height;
//                 this.diameter = diameter;
//           }
//         }
//         public static TreeInfo diameterOptimized(Node root) {
//             if (root == null) {
//                 return new TreeInfo(0, 0);
//             }

//             TreeInfo leftInfo = diameterOptimized(root.left); // recursive call for left subtree
//             TreeInfo rightInfo = diameterOptimized(root.right); // recursive call for right subtree

//             int height = Math.max(leftInfo.height, rightInfo.height) + 1; // height of the current node is max of left and right subtree height + 1 for the current node

//             int diameter = Math.max(leftInfo.height + rightInfo.height + 1, Math.max(leftInfo.diameter, rightInfo.diameter));  // diameter of the current node is max of left subtree diameter, right subtree diameter and diameter through the current node (which is left subtree height + right subtree height + 1 for the current node)

//             return new TreeInfo(height, diameter);

//         }
           

//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         System.out.println("Height of the tree is: " + height(root));   
//         System.out.print("Level order traversal of the tree is: ");
//         levelorder(root);
//             System.out.println("Total number of nodes in the tree is: " + new Trees().countNodes(root));        
//         System.out.println("Sum of all nodes in the tree is: " + new Trees().sumofnodes(root));
//         System.out.println("Diameter of the tree is: " + diameter(root));
//         System.out.println("Optimized Diameter of the tree is: " + diameterOptimized(root).diameter);
//     }
// }

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}



class Solution {

   public static boolean isIdentical(Node root , Node subRoot){
    if(root == null && subRoot == null){
        return true;
    }
    if(root == null || subRoot == null || root.data != subRoot.data){
        return false;
    }
    if( root.data == subRoot.data){
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
    return false;
   }

   public static boolean isSubtree(Node root, Node subRoot) {
    if(root == null){
        return false;
    }           

    if(root.data == subRoot.data){
        if(isIdentical(root, subRoot)){
            return true;
        }
    }  
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
}
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
    
