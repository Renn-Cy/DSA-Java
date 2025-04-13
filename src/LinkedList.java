public class LinkedList
{
    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirstPos(int data)
    {
        //create new node
        Node newNode = new Node(data);

        size++;

        if(head == null)
        {
            head = tail = newNode;
            return;
        }

        //new node's next = head
        newNode.next = head;

        //head = new node
        head = newNode;
    }

    public void addLastPos(int data)
    {
        //create new node
        Node newNode = new Node(data);

        size++;

        if(head == null)
        {
            head = tail = newNode;
            return;
        }

        //former tail's next = new node
        tail.next = newNode;

        //tail = new node
        tail = newNode;
    }

    public void add(int indx, int data)
    {
        if(indx == 0)
        {
            addFirstPos(data);
            return;
        }

        Node newNode = new Node(data);

        size++;

        Node temp = head;

        for(int i = 0; i < indx-1; i++)
        {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirstPos()
    {
        if(size == 0)
        {
            System.out.println("LinkedList is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1)
        {
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

    public int removeLastPos()
    {
        if(size == 0)
        {
            System.out.println("LinkedList is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val; 
        }

        Node prev = head;

        for(int i = 0; i < size-2; i++)
        {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void print() // O(n)
    {
        if(head == null)
        {
            System.out.println("LinkedList is empty");
            return;
        }

        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int IterativeSearch(int key)
    {
        Node temp = head;
        int i = 0;

        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }

            temp = temp.next;
            i++;
        }
        
        return -1;
    }

    public int RecursiveSearch(int key)
    {
        return SearchHelper(head, key);
    }

    public int SearchHelper(Node head, int key)
    {
        if(head == null) {return -1;}

        if(head.data == key) {return 0;}

        int indx = SearchHelper(head.next, key);

        if(indx == -1) {return -1;}

        return indx+1;
    }

    public void reverse()
    {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void deleteNthFromEnd(int n)
    {
        //calculate size
        int  sixe = 0;
        Node temp = head;

        while(temp != null)
        {
            temp = temp.next;
            sixe++;
        }

        if(n == sixe)
        {
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sixe-n;
        Node prev = head;

        while(i < iToFind)
        {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }
    
    //Slow-Fast Approach
    public Node midNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome()
    {
        if(head == null || head.next == null) {return true;}

        Node midNode = midNode(head);

        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while(right != null)
        {
            if(left.data != right.data)
            {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isLooped()
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {return true;}
        }

        return false;
    }

    public void unloop()
    {
        Node slow = head;
        Node fast = head;
        boolean isLooped = false;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {isLooped = true;}
        }

        if(!isLooped) {return;}

        slow = head;
        Node prev = null;

        while(slow != fast)
        {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public Node mergeSort(Node head) // O(n logn)
    {
        if(head == null || head.next == null) {return head;}

        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node getMid(Node head)
    {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node merge(Node head1, Node head2)
    {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null)
        {
            if(head1.data <= head2.data)
            {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else
            {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null)
        {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null)
        {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public void zigZag()
    {
        //find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node mid = slow;


        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head; 
        Node right = prev;
        Node nextL, nextR;


        //alt merge: zig-zag merge
        while(left != null && right != null)
        {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextR;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] links)
    {
        LinkedList ll = new LinkedList();

        ll.addLastPos(1);
        ll.addLastPos(2);
        ll.addLastPos(3);
        ll.addLastPos(4);
        ll.addLastPos(5);
        // ll.addLastPos(8);
        // ll.add(2, 6);

        // ll.head = ll.mergeSort(ll.head);
        ll.print();
        ll.zigZag();
        ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.isLooped());
        // ll.reverse();
        // ll.print();

    }
}