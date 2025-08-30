public static class LL{
    private int size;
    private Node head;
    private Node tail ;
     LL(int size){
        this.size = size;
     }

     public class Node{
         int data;
         Node next;
         Node(int data){
             this.data = data;
             this.next = null;
         }
     }

     public void addFirst(int data){

           Node newNode = new Node(data) ;
           if (head == null ) {
               head = newNode ;
               tail = newNode ;
           } else {
               newNode.next = head ;
               head = newNode ;

    }

}


  public void addLast(int data){
      Node newNode = new Node(data) ;

     if (head == null){
        head = newNode ;
        tail = newNode ;
     }
 Node lastNode = head ;

 while(lastNode.next!=null){
    lastNode = lastNode.next ;
 }
 lastNode.next = newNode ;
  }


  public void printAll() {

      Node curr = head;

      while (curr != null) {
          System.out.print(curr.data + " -> ");
          curr = curr.next;
      }
      System.out.println("null");
  }
     public void deleteFirst(){
         if(head == null){
            System.out.print("string is empty");
         }
         else {
            head = head.next ;
         }
      }

      public void deleteLast() {
          if(head == null){
              System.out.print("string is empty");
              return ;
          }


           if(head.next==null){
               head = null ;
               return ;
           }

          Node secondlast = head ;
          Node lastnode = head.next ;
          while(lastnode.next != null){
              lastnode = lastnode.next ;
              secondlast = secondlast.next ;

          }
           secondlast.next = null;
     }


}


  public static void main(String args[]){

   LL list = new LL(10);
   list.addFirst(1);
   list.addFirst(2);
   list.addFirst(3);
   list.addLast(4);
   list.addLast(5);
   list.addLast(6);
   list.printAll();

   list.deleteFirst();
   list.deleteLast();
   list.printAll();

//    list.display();
//    list.reverse();
//    list.display();
//    list.removeDuplicates();
//    list.display();
//    list.sort();
//    list.display();
//    list.remove(4);
//    list.display();
//    list.clear();
//    list.display();


  }

