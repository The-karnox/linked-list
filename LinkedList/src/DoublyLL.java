import java.util.*;
public class LL2 {
    public static class Node{
        int data;
        Node next;
        Node prev;
 
        public Node(int data){
           this.data = data;
           this.next = null;
           this.prev = null;
      }
 
      }
      public static Node head;
      public static Node tail;
      public static int size;

      public void addFirst(int data){      // TC = O(1)
        //creationm of node
         Node newNode = new Node(data);
          size++;
         if(head == null){
           head = tail = newNode;
           return;
          }

          newNode.next = head;
          head.prev = newNode;
          head = newNode;
        
         }
         public void addLast(int data){      // TC = O(1)
            //creationm of node
             Node newNode = new Node(data);
              size++;
             if(head == null){
               head = tail = newNode;
               return;
              }
    
              tail.next = newNode;
              tail.prev = newNode;
              tail = newNode;
            
             }
         public void print() {         //TC O(n)
            
             
             Node temp = head;
             while(temp != null){
               System.out.print(temp.data + "<->");
               temp = temp.next;
             }
             System.out.println("null" );
          }

          public int removeFirst(){
            if(head == null){
             System.out.println("DLL is empty");
             return Integer.MIN_VALUE;
             }
            if(size==1){
                int val = head.data;
                head = tail = null;
                size--;
                return val;
            }
            int val = head.data;
               head = head.next;
                head.prev = null;
                size--;
                return val;
        }
        public int removeLast(){
          if(head == null){
           System.out.println("dll is null");
           return Integer.MIN_VALUE;
          }else if (size == 1){
           int val = head.data;
           head = tail = null;
           size = 0;
           return val;
          }
          //prev = i= size-2
          Node prev = head;
          for(int i=0;i<size-2; i++){
             prev = prev.next;
           }
           int val = prev.next.data;
           prev.next=null;
           tail = prev;
           tail.next = null;
           size--;
           return val;
        }
        public void reverse(){
          Node curr = head;
          Node prev = null;
          Node next;

          while(curr != null){
           next = curr.next;
           curr.next = prev;
           curr.prev = next;

           prev = curr;
           curr = next;

           }
           head = prev;
          }
         

    public static void main(String args[]){
      LL2 dll = new LL2();
      dll.addFirst(3);
      dll.addFirst(2);
      dll.addFirst(1);
      dll.addLast(8);

     

      dll.print();
      dll.removeLast();
      dll.reverse();
      dll.print();
      System.out.println(dll.size);
     }

    

    
    }

