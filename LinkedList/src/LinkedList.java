public class LinkedList {
    public static class Node{
       int data;
       Node next;

       public Node(int data){
          this.data = data;
          this.next = null;
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

     //new node next = head
      newNode.next = head; //linking

      //head becomes new Node
      head = newNode;
    }

 
    public void addLast(int data){           //tc=O(1)
      Node newNode = new Node(data);
      size++;
      
        if(head == null){
          head = tail = newNode;
          return;
       }
     tail.next = newNode; 
     tail = newNode;
    }
    public void print() {         //TC O(n)
      if(head == null) {
        System.out.println("LL is null ");
        return;
       }
       Node temp = head;
       while(temp != null){
         System.out.print(temp.data + "->");
         temp = temp.next;
       }
       System.out.println("null" );
    }
    public void AddinIndex(int idx, int data){
      if(idx == 0){
        addFirst(data);
        return;
       }
       Node newNode = new Node(data);
       size++;
       Node temp = head;
       int i = 0;

       while (i < idx-1){
         temp = temp.next;
         i++;
       }
       newNode.next = temp.next;
       temp.next = newNode;
     }
     public int removeFirst(){
      if(size==0){
        System.out.println("ll is null");
        return Integer.MIN_VALUE;
       }else if(size == 1){
         int val = head.data;
         head = tail = null;
         size = 0;
         return val;
       }
       int val = head.data;
       head = head.next;
       size--;
       return val;
     }

     public int removeLast(){
       if(size==0){
        System.out.println("ll is null");
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
        size--;
        return val;
     }

     public int itrSearch(int key){
      Node temp = head;
      int i = 0;
      while(temp != null){
        if(temp.data == key){
         return i+1; 
         }
         temp = temp.next;
         i++;
       }
       //key not found
       return -1;
     }

     

     public int helper(Node head, int key){      // TC = O(n)
       if(head == null){
       return -1; 
       }
       if(head.data == key){
        return 0;
       }
       int idx = helper(head.next, key);
       if(idx == -1){
         return-1;
       }
       return idx+1;
     }
     public int recursiveSearch(int key){
       return helper(head, key);
     }

     public void Reverse(){
       Node prev = null;
       Node curr = tail = head;
       Node next;

       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }
       head = prev;
     }

     public Node Mid(Node head){
      Node slow = head;
      Node fast = head;

      while(fast !=null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
       }
       return slow;//midNode
     }


     public boolean CheckPaliandrome(){
        if(head == null || head.next == null){
           return true;
         }
         Node midNode = Mid(head);

         Node prev = null;
       Node curr = midNode;
       Node next;

       while(curr != null){
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
       }

       Node right = prev;
       Node left = head;


        while(right != null){
          if(left.data != right.data){
             return false;
           }
           left = left.next;
           right = right.next;
         }
         return true;

     }

     public static boolean isLooped(){
       Node slow = head;
       Node fast = head;

       while(fast != null && fast.next != null){
        slow = slow.next;
        slow = slow.next.next;
        if(slow == fast){
          return true;
         }

       }
       return false;
     }
    
      public static void removeLoop(){
        Node slow = head;
        Node fast = head;
        boolean loop = false;
       while(fast != null && fast.next != null){
        slow = slow.next;
        slow = slow.next.next;
        if(slow == fast){
          loop = true;
          break;
         }
       }
       if (loop == false){
        return;
       }
       slow = head;
       Node prev = null;
       while(slow != fast){
        prev = fast;
        slow = slow.next;
        fast = fast.next;
       }
       prev.next = null; 
      }

      public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
  
        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }
        return slow;
       }
       public Node merge(Node head1, Node head2){
         Node mergedll = new Node(-1);
         Node temp = mergedll;
  
         while (head1 != null && head2 != null){ 
          if(head1.data <= head2.data){
           temp.next = head1;
           head1 = head1.next;
           temp = temp.next;
         } else{
          temp.next = head2;
          head2 = head2.next;
          temp = temp.next;
         }
        }  
        while (head1 != null) {
          temp.next = head1;
          head1 = head1.next;
          temp = temp.next;
          
        }
        while (head2!= null) {
          temp.next = head1;
          head2 = head2.next;
          temp = temp.next;
          
        }
        return mergedll.next;
  
       }
  
      public  Node MergeSort(Node head){
          if(head == null || head.next == null){
            return head;
           }
  
          Node mid = getMid(head);
          Node rightHead = mid.next;
          mid.next = null;
          Node newLeft = MergeSort(head);
          Node newRight = MergeSort(rightHead);
  
  
          return merge(newLeft, newRight);
      
       }

       public void ZigZag(){
         Node slow = head;
         Node fast = head.next;
         while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;

         }
         Node mid = slow;

         Node curr = mid.next;
         mid.next = null;
         Node prev = null;
         Node next;
         while(curr != null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
         }
         Node left = head;
         Node right = prev;
         Node nextL,nextR;

         while(left != null && right != null){
          nextL = left.next;
          left.next = right;
          nextR = right.next;
          right.next = nextL;

          left = nextL;
          right = nextR;
         }
       }


    
     public static void main(String args[]){
      LinkedList l1 = new LinkedList();
      l1.addFirst(5);
      l1.addFirst(9);
      l1.addFirst(2);
      l1.addFirst(7);
      l1.addFirst(6);
      l1.addFirst(3);
         
     l1.print();
     l1.ZigZag();
     l1.print();
     }
}
