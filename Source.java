class Node<T> {
    T val;
    Node<T> next;
    
    public Node(T val) {
      this.val = val;
      this.next = null;
    }
  }
  
  class Source {
    public static <T> Node<T> reverseList(Node<T> head) {
      /*
       * This method takes in the head of a linked list and reverses the
       * order of the nodes in the linked list in place.
       * 
       * Returns the new head of the reversed linked list
       */
      
      Node<T> prev_node = null;       // to have a node to point to previous
      Node<T> next_node = null;       // to hold the next node
      Node<T> current_node = head;    // to hold current node

      while(current_node != null){  // while current node isn't null
        next_node = current_node.next;    // make the next node the one after current node
        current_node.next = prev_node;    // make one after current the previous (reverse)
        prev_node = current_node;         // make the previous node the current
        current_node = next_node;         // make current node the next node 
      }

      // to exit while loop, the current node has to be null. 
      // The previous node is tail at end of loop (start of new list)
      head = prev_node;   

      return head; // return head of reversed list
    }
    
    public static void main(String[] args) {
        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");
    
        x.next = y; // x -> y
  

        // Printing solution
        Node<String> head = Source.reverseList(x);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;            
        }

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // a -> b -> c -> d -> e -> f

        Node<String> newHead = reverseList(a); // f -> e -> d -> c -> b -> a

        while (newHead != null) {
          System.out.println(newHead.val);
          newHead = newHead.next;
        }
    }
  }