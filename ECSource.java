class Node<T> {
  T val;
  Node<T> next;

  public Node(T val) {
    this.val = val;
    this.next = null;
  }
}

class ECSource {
  public static <T> boolean isUnivalueList(Node<T> head) {
    /*
     * This method takes in the head of a linked list and determines whether
     * the linked list contains exactly one unique value. Returns a boolean.
     */
    boolean isUnique = true;    // boolean to return, assumes list contains one unique value
    while (head != null && head.next != null) {   // while head and node next to head aren't null
      if (!head.next.val.equals(head.val)){   // if next value != current value
        isUnique = false;     // there cannot be one value in list if two aren't equal
        break;   
      }
      head = head.next;     // traverse to next node
    }
    return isUnique;
  }

  public static <T> boolean isUnivalueListRecursive(Node<T> head) {
    /*
     * This method takes in the head of a linked list and determines whether
     * the linked list contains exactly one unique value RECURSIVELY. 
     * Returns a boolean.
     */
    boolean isUnique = true;    // boolean to return, assumes list contains one unique value

    if (head.next != null){   // if next node isn't null
      if (!head.next.val.equals(head.val)){   // if next value != current value
          isUnique = false;     // there cannot be one value in list if two aren't equal
          return isUnique; 
      }  
      
      isUnivalueListRecursive(head.next);   // recursively call on next node to compare again

    }
    return isUnique;
  }

  public static void main(String[] args) {
        Node<String> z = new Node<>("z");
        // z

        // Printing solution
        System.out.println((ECSource.isUnivalueList(z)));

        Node<Integer> u = new Node<>(2);
        Node<Integer> v = new Node<>(2);
        Node<Integer> w = new Node<>(2);
        Node<Integer> x = new Node<>(2);
        Node<Integer> y = new Node<>(2);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;

        // 2 -> 2 -> 2 -> 2 -> 2

        System.out.println(ECSource.isUnivalueListRecursive(u)); // true

        Node<Integer> l = new Node<>(2);
        Node<Integer> m = new Node<>(2);
        Node<Integer> n = new Node<>(3);
        Node<Integer> o = new Node<>(3);
        Node<Integer> p = new Node<>(2);

        l.next = m;
        m.next = n;
        n.next = o;
        o.next = p;

        // 2 -> 2 -> 3 -> 3 -> 2

        System.out.println(ECSource.isUnivalueList(l)); // false
    }
}
