package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vinod on 2/4/18.
 */
public class LinkedList {

    Node head;
    Node left;

    public static LinkedList listPal = new LinkedList();

    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {

        int searchKey = 15;

        LinkedList lst = new LinkedList();

        for (int i = 2; i < 9; i++) {
            addNode(i, lst);
        }

        System.out.println("Length of the Linked list before operations " + getLength(lst));
        System.out.println("Length of the Linked list before operations recursive " + getLength(lst.head));
        System.out.println(lst.toString());
        deleteNode(6, "position", lst);
        deleteNode(16, "key", lst);
        System.out.println("Length of the Linked list after operations " + getLength(lst));
        System.out.println("Length of the Linked list after operations recursive" + getLength(lst.head));
        System.out.println(lst.toString());

        System.out.println("Searching for key " + searchKey + " and " + search(searchKey, lst));
        System.out.println("Searching for key " + searchKey + " recursively and output is " + search(searchKey, lst.head));


        swap(1, 15, lst);
        System.out.println("Swapped linked list " + lst);

        System.out.println("Nth node is :- " + getNthNode(7, lst));
        System.out.println("Nth node recursively is:-" + getNthNode(7, lst.head));
        System.out.println("Middle of the linked list is:- " + getMiddle(lst));
        System.out.println("Get middle with 2 pointers :-" + getMiddleWith2pointers(lst));
        System.out.println("Get middle by odd number :-" + getMiddleByOdd(lst));
        System.out.println("N th from end :- " + getNthNodeFromEnd(lst, 2));
        System.out.println("N th from end 2 pointers:- " + getNthFromEndTwoNodes(lst, 2));
       /* deleteLinkedList(lst);
        System.out.println(lst);*/
        System.out.println("Count of the key :- " + getKeyCount(3, lst));

        reverseLinkedList(lst);
        System.out.println("Reversed linked List is :- " + lst);

        reverseLinkedListRecursive(lst.head, null, lst);
        System.out.println("Reverse Linked list recusrsion is:- " + lst);

        //addLoop(lst);
        System.out.println("Current linked list has loop?:- " + detectLoop(lst));

        System.out.println("List after loop is removed " + lst);


        LinkedList lst2 = new LinkedList();

        for (int i = 5; i < 8; i++) {
            addNode(i, lst2);
        }

//        System.out.println("Merge recursive:- " + mergeTwoRecursive(lst.head, lst2.head));
        System.out.println("Merged in place:-" + mergeTwoInPlace(lst.head, lst2.head));
//        mergeTwo(lst,lst2);


        /****PALINDROME******************/
        listPal.head = createPalindrome(lst);
        System.out.println("Result of palindrome :- " + checkPalindrome(listPal));
        System.out.println("Original pal:- " + listPal);

        System.out.println(checkPalindromeRecursive(listPal.head));
        /******************END*********/


        /*****************INTERSECTION***************/
        LinkedList l1Interserct = new LinkedList();
        LinkedList l2Intersect = new LinkedList();
        for (int i = 1; i < 6; i++) {
            addNode(i, l1Interserct);
        }

        for (int i = 4; i < 6; i++) {
            addNode(i, l2Intersect);
        }

        Node n1Head = l1Interserct.head;
        Node n2Head = l2Intersect.head;
        while (l2Intersect.head.next != null) {
            l2Intersect.head = l2Intersect.head.next;
        }
        int i = 0;
        while (i < 4) {
            l1Interserct.head = l1Interserct.head.next;
            i++;
        }
        l2Intersect.head.next = l1Interserct.head;

        l1Interserct.head = n1Head;
        l2Intersect.head = n2Head;

        System.out.println("Intersection of 2 nodes is :- " + findIntersection(l1Interserct, l2Intersect));
        /*********************END******************/


        /*****************PRINT REVERSE RECURSIVE*******************/
        LinkedList lstPrintRev = new LinkedList();
        for (i = 4; i < 6; i++) {
            addNode(i, lstPrintRev);
        }
        printReverseRecursive(l1Interserct.head);
        /********************END************************************/


        /*********************REMOVE DUPLICATES FROM SORTED********************/
        LinkedList dupSortedList = new LinkedList();


        List<Integer> dupList = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};
        for (int j = 1; j < 2; j++) {
            addNodeWithDup(j, dupSortedList,dupList);
        }
        dupSortedList.head = removeDuplicateFromSorted(dupSortedList.head);
        System.out.println("Duplicate removed list :- "+dupSortedList);
        /*********************************END**********************************/


        /*************************REMOVE DUPLICATES UNSORTED*******************/
        //12->11->12->21->41->43->21
        LinkedList dupUnsortedList = new LinkedList();
        dupUnsortedList.head = new Node(12, null);
        dupUnsortedList.head.next = new Node(11, null);
        dupUnsortedList.head.next.next = new Node(12, null);
        dupUnsortedList.head.next.next.next = new Node(21, null);
        dupUnsortedList.head.next.next.next.next = new Node(41, null);
        dupUnsortedList.head.next.next.next.next.next = new Node(43, null);
        dupUnsortedList.head.next.next.next.next.next.next = new Node(43, null);
        dupUnsortedList.head.next.next.next.next.next.next.next = new Node(43, null);
        System.out.println("Duplicate removed unsorted:- " +removeDuplicatesFromUnsorted(dupUnsortedList.head));
        /**************************END*****************************************/

    }

    private static Node createPalindrome(LinkedList lst) {

        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(1, null);
        /*head.next.next.next.next.next = new Node(1, null);
        head.next.next.next.next.next.next = new Node(1, null);
        head.next.next.next.next.next.next.next = new Node(1, null);*/


        return head;
    }

    private static void addLoop(LinkedList lst) {

        Node current = lst.head;
        Node mid = current.next.next.next;

        while (current.next != null) {
            current = current.next;
        }

        current.next = mid;
    }


    private static void deleteNode(int n, String keyPos, LinkedList lst) {

        if (keyPos.equals("key")) {
            Node headNode = lst.head;
            if (headNode.data == n) {
                lst.head = lst.head.next;
                System.out.println("deleted from position " + n);
                return;
            } else {
                while (headNode.next != null) {
                    Node prev = headNode;
                    headNode = headNode.next;
                    if (headNode.data == n) {
                        prev.next = headNode.next;
                        System.out.println("deleted from position " + n);
                        return;
                    }
                }
            }
            System.out.println("Key not found " + n);
        }

        if (keyPos.equals("position")) {

            Node headNode = lst.head;
            int i = 0;
            Node prev = headNode;

            if (n == 0) {
                lst.head = lst.head.next;
                System.out.println("deleted from position " + n);
                return;
            } else {

                while (i < n && headNode != null) {
                    prev = headNode;
                    headNode = headNode.next;
                    i++;
                }
                if (headNode != null) {
                    prev.next = headNode.next;
                    System.out.println("deleted from position " + n);
                    return;
                }
            }
            System.out.println("key not found " + n);
        }
    }

    private static void addNode(int data, LinkedList lst) {
        if (lst.head == null) {
            lst.head = new Node(data, null);
        } else {
            Node node = lst.head;
            while (node.next != null) {
                node = node.next;
            }
            Node newNode = new Node(data, null);
            node.next = newNode;
        }
    }

    private static void addNodeWithDup(int data, LinkedList lst, List<Integer> lesThn) {
        if (lst.head == null) {
            lst.head = new Node(data, null);
        } else {
            Node node = lst.head;
            while (node.next != null) {
                node = node.next;
            }
            if (lesThn.contains(data)) {
                for (int i = 0; i < 3; i++) {
                    Node newNode = new Node(data, null);
                    node.next = newNode;
                    node = newNode;
                }
            } else {
                Node newNode = new Node(data, null);
                node.next = newNode;
            }
        }
    }

    private static int getLength(LinkedList lst) {
        Node node = lst.head;
        if (null == node)
            return 0;
        int i = 1;
        while (node.next != null) {
            i++;
            node = node.next;
        }

        return i;
    }


    private static int getLength(Node lst) {

        if (lst == null)
            return 0;

        return 1 + getLength(lst.next);
    }


    private static String search(int key, LinkedList lst) {
        Node headNode = lst.head;
        int i = 0;
        while (headNode != null) {
            if (headNode.data == key) {
                return "key found at " + i + "th postion";
            }
            headNode = headNode.next;
            i++;
        }
        return "Key not found";
    }

    private static boolean search(int key, Node node) {
        if (node == null)
            return false;

        if (node.data == key)
            return true;

        return search(key, node.next);
    }


    private static void swapNodes(int key1, int key2, LinkedList lst) {


        if (lst.head != null) {
            Node xPrev = null;
            Node x = null;

            Node yPrev = null;
            Node y = null;

            Node current = lst.head;

            boolean xfound = false;
            boolean yfound = false;

            if (key1 == key2)
                return;

            if (current.data == key1) {
                xPrev = null;
                x = current;
                xfound = true;
            }

            if (current.data == key2) {
                yPrev = null;
                y = current;
                yfound = true;
            }

            while (current.next != null) {
                if (current.next.data == key1 && !xfound) {
                    xPrev = current;
                    x = xPrev.next;
                    xfound = true;
                }

                if (current.next.data == key2 && !yfound) {
                    yPrev = current;
                    y = yPrev.next;
                    yfound = true;
                }

                if (xfound && yfound)
                    break;
                current = current.next;
            }


            if (xfound && yfound) {

                if (xPrev == null)
                    lst.head = y;
                else {
                    xPrev.next = y;
                }

                if (yPrev == null)
                    lst.head = x;
                else {
                    yPrev.next = x;
                }

                Node temp = x.next;
                x.next = y.next;
                y.next = temp;

                return;
            }
        }
    }


    private static void swap(int x, int y, LinkedList list) {
        Node current = list.head;

        Node prevX = null;
        Node prevY = null;

        Node currentX = null;
        if (current.data == x) {
            currentX = current;
        }

        Node currentY = null;
        if (current.data == y) {
            currentY = current;
        }

        while (current.next != null) {

            if (currentX == null && current.next.data == x) {
                prevX = current;
                currentX = current.next;
            }

            if (currentY == null && current.next.data == y) {
                prevY = current;
                currentY = current.next;
            }

            if (currentX != null && currentY != null)
                break;

            current = current.next;
        }

        if (currentX == null || currentY == null)
            return;


        if (prevX == null) {
            list.head = currentY;
        } else {
            prevX.next = currentY;
        }

        if (prevY == null) {
            list.head = currentX;
        } else {
            prevY.next = currentX;
        }

        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;

    }


    private static Node getNthNode(int n, LinkedList lst) {
        int i = 0;
        Node current = lst.head;
        while (current != null) {
            if (i == n)
                return current;
            current = current.next;
            i++;
        }
        return null;
    }


    private static Node getNthNode(int n, Node head) {
        if (head == null)
            return null;

        if (n == 0)
            return head;

        return getNthNode(n - 1, head.next);
    }

    private static int getMiddle(LinkedList lst) {
        Node current = lst.head;
        int length = getLength(lst);
        int middle = (length / 2) + 1;
        int i = 1;
        while (i < middle) {
            current = current.next;
            i++;
        }
        return current.data;
    }

    private static int getMiddleWith2pointers(LinkedList lst) {
        Node slow = lst.head;

        if (slow.next == null) {
            return slow.data;
        }
        Node fast = lst.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }


    private static int getMiddleByOdd(LinkedList lst) {
        Node mid = lst.head;
        Node current = lst.head;

        int counter = 0;

        while (current != null) {
            current = current.next;
            if (counter % 2 != 0)
                mid = mid.next;
            counter++;
        }
        return mid.data;
    }


    private static int getNthNodeFromEnd(LinkedList lst, int n) {
        Node current = lst.head;

        for (int i = 0; i < (getLength(lst.head) - n); i++) {
            current = current.next;
        }
        return current.data;
    }

    private static int getNthFromEndTwoNodes(LinkedList lst, int n) {
        Node first = lst.head;
        Node ref = lst.head;

        int i = 0;

        while (first != null && i != n) {
            first = first.next;
            i++;
        }

        while (first != null) {
            first = first.next;
            ref = ref.next;
        }
        return ref.data;
    }


    private static int getKeyCount(int key, LinkedList lst) {
        int count = 0;
        Node current = lst.head;
        while (current != null) {
            if (key == current.data) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    private static void deleteLinkedList(LinkedList lst) {
        Node current = lst.head;

        while (current != null) {
            lst.head = current;
            current = current.next;
            lst.head = null;
        }

    }

    private static void reverseLinkedList(LinkedList list) {
        Node current = list.head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        list.head = prev;
    }

    private static void reverseLinkedListRecursive(Node node, Node prev, LinkedList lst) {

        if (node == null) {
            lst.head = prev;
            return;
        }

        Node next = node.next;
        node.next = prev;
        prev = node;

        reverseLinkedListRecursive(next, prev, lst);
    }


    private static boolean detectLoop(LinkedList list) {

        Node slow = list.head;
        Node fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(list, slow);
                return true;
            }

        }
        return false;
    }


    private static void removeLoop(LinkedList list, Node loopNode) {
        Node node1 = list.head;
        Node node2 = loopNode;

        boolean loopRemoved = false;

        while (!loopRemoved) {

            while (node1.next != node2.next && node2.next != loopNode) {
                node2 = node2.next;
            }

            if (node1.next == node2.next) {
                node2.next = null;
                loopRemoved = true;
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
    }


    private static void mergeTwo(LinkedList l1, LinkedList l2) {
        Node head1 = l1.head;
        Node head2 = l2.head;

        LinkedList l3 = new LinkedList();
        Node newHead = null;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                if (l3.head == null) {
                    l3.head = newHead = new Node(head1.data, null);
                    head1 = head1.next;
                } else {
                    newHead.next = new Node(head1.data, null);
                    ;
                    newHead = newHead.next;
                    head1 = head1.next;
                }
            } else {
                if (l3.head == null) {
                    l3.head = newHead = new Node(head2.data, null);
                    head2 = head2.next;
                } else {
                    newHead.next = new Node(head2.data, null);
                    head2 = head2.next;
                    newHead = newHead.next;
                }
            }
        }

        while (head1 != null) {
            newHead.next = new Node(head1.data, null);
            ;
            head1 = head1.next;
            newHead = newHead.next;
        }

        while (head2 != null) {
            newHead.next = new Node(head2.data, null);
            ;
            newHead = newHead.next;
            head2 = head2.next;
        }
        System.out.println("Sorted merged list :-" + l3);
    }

    private static Node mergeTwoRecursive(Node head1, Node head2) {
        Node result = null;

        if (head1 == null) {
            return head2;
        }
        if (head2 == null)
            return head1;

        if (head1.data < head2.data) {
            result = head1;
            result.next = mergeTwoRecursive(head1.next, head2);
        } else {
            result = head2;
            result.next = mergeTwoRecursive(head1, head2.next);
        }
        return result;
    }


    //TODO: Fix this
    private static Node mergeTwoInPlace(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node p1, p2, n1, n2 = null;
        Node newHead = null;
        if (head1.data < head2.data) {

            p1 = head1;
            p2 = head2;

            n1 = p1.next;

        } else {
            p1 = head2;
            p2 = head1;

            n1 = p1.next;
        }

        newHead = p1;
        if (newHead.next == null) {
            newHead.next = p2;
        } else {

            while (p1 != null && p2 != null) {

                if (p1.data <= p2.data && p2.data <= n1.data) {

                    n2 = p2.next;
                    p1.next = p2;
                    p2.next = n1;

                    p1 = p2;
                    p2 = n2;
                } else {


                    if (n1.next != null) {
                        p1 = p1.next;
                        n1 = n1.next;
                    } else {
                        n1.next = p2;
                        return newHead;
                    }

                }
            }
        }

        return newHead;
    }


    /**
     * @param lst
     * @return
     * @link https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
     */
    private static boolean checkPalindrome(LinkedList lst) {
        boolean palindrome = true;

        Node head = lst.head;
        Node startHead = lst.head;

        Node slow = head;
        Node fast = head;
        Node slowPrev = head;


        Node middle = null;
        Node oddNode = head;

        Node prev = null;
        Node curr = head;
        Node next = head;

        Node secondHalf = null;
        int count = 1;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                count += 2;
            } else {
                count += 1;
            }
        }


        //Terminate first half.
        slowPrev.next = null;

        if (count % 2 != 0) {
            middle = slow;
            slow = slow.next;
        }

        secondHalf = slow;
        curr = secondHalf;
        next = curr;

        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        secondHalf = prev;
        Node palStart = prev;

        palindrome = compareLists(secondHalf, startHead);

        curr = secondHalf;
        next = curr;

        prev = null;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        if (middle != null) {
            slowPrev.next = middle;
            middle.next = secondHalf;
        } else {
            slowPrev.next = secondHalf;
        }


        return palindrome;
    }

    private static boolean compareLists(Node node1, Node node2) {
        Node palStart = node1;
        Node startHead = node2;

        boolean palindrome = true;

        while (palStart != null && startHead != null) {
            if (palStart.data != startHead.data) {
                palindrome = false;
            }
            palStart = palStart.next;
            startHead = startHead.next;
        }

        return palindrome;
    }


    /**
     * @param right
     * @return
     * @link https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
     */
    private static boolean checkPalindromeRecursive(Node right) {
        listPal.left = listPal.head;

        if (right == null)
            return true;

        boolean isPal = checkPalindromeRecursive(right.next);

        if (!isPal)
            return false;

        boolean isPal1 = listPal.left.data == right.data;

        listPal.left = listPal.left.next;

        return isPal1;
    }


    private static int findIntersection(LinkedList l1, LinkedList l2) {

        Node n1 = l1.head;
        Node n2 = l2.head;

        if (n1 == null || n2 == null)
            return 0;


        int length1 = getLength(l1);
        int length2 = getLength(l2);
        int difference = Math.abs(length1 - length2);

        int i = 1;
        if (length1 > length2) {
            while (i <= difference) {
                if (n1 == null)
                    return -1;
                n1 = n1.next;
                i++;
            }
        } else if (length2 > length1) {
            while (i <= difference) {
                n2 = n2.next;
                i++;
            }
        }

        while (n1 != null && n2 != null) {
            if (n1 == n2) {
                return n1.data;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return -1;
    }

    /**
     * @param head
     * @link https://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
     */
    private static void printReverseRecursive(Node head) {
        if (head == null)
            return;

        printReverseRecursive(head.next);
        System.out.println(head.data);
    }

    /**
     * @param head
     * @link https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
     */
    private static Node removeDuplicateFromSorted(Node head) {

        if (head == null || head.next == null)
            return head;

        Node prev = head;
        Node next = head.next;

        while (next != null) {
            if (prev.data == next.data) {
                next = next.next;
                prev.next = next;
            } else {
                prev = next;
                next = next.next;
            }
        }
        return head;
    }


    private static Node removeDuplicatesFromUnsorted(Node head) {
        if (head == null || head.next == null)
            return head;

        Node p1 = head;
        Node p2 = head.next;

        while (p1 != null) {
            Node p2Prev = p1;
            p2 = p1.next;
            while (p2 != null) {
                if (p1.data == p2.data) {
                    p2Prev.next = p2.next;
                } else {
                    p2Prev = p2Prev.next;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return head;
    }



    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                '}';
    }
}

