package LinkedList;


/**
 * Created by vinod on 10/4/18.
 */
public class LinkedList1 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList1 l1 = new LinkedList1();
        for (int i = 1; i < 7; i++) {
            if (i == 5)
                continue;
            l1.addNode(i, list);
        }

        for(int i=2;i<9;i+=2){
            l1.addNode(i,list1);
        }

//        l1.swapPairWiseElementsItr(list);
//        System.out.println("Pairwise element swap iterative:- " + list);
//
//        l1.swapPairWiseRecursive(list.head);
//        System.out.println("Pairwise element swap recursive:- " + list);
//
//        list.head = l1.pairWiseSwapNodes(list);
//        System.out.println("Pairwise swap nodes :- " + list);
//
//        l1.moveLastToFirst(list);
//        System.out.println("Moved last to first :- " + list);


        LinkedList intersectionOfsortedLinkedLists =  l1.createIntersectionOfsortedLinkedLists(list.head, list1.head);
        System.out.println("Intersection of two lists :- "+intersectionOfsortedLinkedLists);
        System.out.println("Intersection of two lists :- "+l1.createIntersectionIfTwoRecursive(list.head,list1.head));


        /**
         * ALTERNATE NODE DELETION
         */
        LinkedList listDel = new LinkedList();
        for (int i = 1; i < 12; i ++) {
            l1.addNode(i, listDel);
        }
//        l1.deleteAlternate(listDel);
        System.out.println("Alternate Deleted Nodes :- " + listDel);
        System.out.println("Alternate delete Nodes recursive :- "+ l1.deleteAlternateRecursive(listDel.head));
        /**
         * ALTERNATE NODE DELETION
         */

        /*****Split Alternate***/
        LinkedList listAlternating = new LinkedList();
        listAlternating.head = new LinkedList.Node(0,null);
        listAlternating.head.next = new LinkedList.Node(1,null);
        listAlternating.head.next.next = new LinkedList.Node(0,null);
        listAlternating.head.next.next.next = new LinkedList.Node(1,null);
        listAlternating.head.next.next.next.next = new LinkedList.Node(0,null);
        listAlternating.head.next.next.next.next.next = new LinkedList.Node(1,null);
//        listAlternating.head.next.next.next.next.next.next = new LinkedList.Node(0,null);

        LinkedList split2 = l1.alternatingSplit(listAlternating);

        System.out.println("Split 1:- " + listAlternating);
        System.out.println("Split 2:- " + split2);

        /******SPLIT alternate****/
    }


    private  void addNode(int data, LinkedList lst) {
        if (lst.head == null) {
            lst.head = new LinkedList.Node(data, null);
        } else {
            LinkedList.Node node = lst.head;
            while (node.next != null) {
                node = node.next;
            }
            LinkedList.Node newNode = new LinkedList.Node(data, null);
            node.next = newNode;
        }
    }

    /**
     * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
     * @param list
     * @return
     */
    private LinkedList.Node pairWiseSwapNodes(LinkedList list) {
        //Eg. : 1->2->3->4->5
        //Answer:- 2->1->4->3->5


        LinkedList.Node prev = list.head; //Prev start at head
        LinkedList.Node newHead = null;
        LinkedList.Node next = null; //Next will point at next of prev


        if (prev == null || prev.next == null)
            return list.head;
        else {
            next = prev.next;
            newHead = next;
        }

        LinkedList.Node pTemp = null;
        while (prev != null && next != null) {
            LinkedList.Node temp = next.next;

            prev.next = temp;
            next.next = prev;

            if (pTemp != null) {
                pTemp.next = next;
            }

            pTemp = prev;
            prev = temp;
            if (temp != null)
                next = temp.next;
        }

        return newHead;
    }

    /**
     * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
     * @param list
     */
    private void swapPairWiseElementsItr(LinkedList list) {

        LinkedList.Node node = list.head;

        if (node == null || node.next == null)
            return;

        while (node != null && node.next != null) {
            int temp = node.next.data;
            node.next.data = node.data;
            node.data = temp;

            node = node.next.next;
        }
    }

    /**
     * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
     * @param node
     */
    private void swapPairWiseRecursive(LinkedList.Node node){

        if(node == null || node.next == null)
            return;

        int temp = node.data;
        node.data = node.next.data;
        node.next.data = temp;
        swapPairWiseRecursive(node.next.next);
    }


    /**
     * https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
     * @param list
     */
    private void moveLastToFirst(LinkedList list){
        LinkedList.Node head = list.head;

        if (head == null)
            return;

        LinkedList.Node prev = null;
        while (head.next != null){
            prev = head;
            head = head.next;
        }
        prev.next = null;

        head.next = list.head;
        list.head = head;
    }


    private LinkedList createIntersectionOfsortedLinkedLists(LinkedList.Node node1, LinkedList.Node node2) {
        LinkedList interSection = new LinkedList();
        LinkedList.Node node = null;

        if (node1 == null || node2 == null)
            return null;

        while (node1 != null && node2 != null) {
            if (node1.data == node2.data) {
                LinkedList.Node newNode = new LinkedList.Node(node1.data, null);
                if (interSection.head == null) {
                    node = newNode;
                    interSection.head = newNode;
                }
                node.next = newNode;
                node = node.next;
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.data < node2.data)
                node1 = node1.next;
            else if (node1.data > node2.data)
                node2 = node2.next;
        }
        return interSection;
    }

    private LinkedList.Node createIntersectionIfTwoRecursive(LinkedList.Node node1, LinkedList.Node node2) {

        if (node1 == null || node2 == null)
            return null;

        if (node1.data < node2.data)
            return createIntersectionIfTwoRecursive(node1.next, node2);

        if (node2.data < node1.data)
            return createIntersectionIfTwoRecursive(node1, node2.next);

        LinkedList.Node node = new LinkedList.Node(node1.data, null);
        node.next = createIntersectionIfTwoRecursive(node1.next, node2.next);

        return node;
    }

    /**
     * @link https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
     * @param list
     */
    private void deleteAlternate(LinkedList list) {
        LinkedList.Node p1 = list.head;

        if (p1 == null || p1.next == null)
            return;
        LinkedList.Node a1 = p1.next;

        while (p1 != null && a1 != null) {
            p1.next = a1.next;
            p1 = p1.next;

            if (p1 != null)
                a1 = p1.next;
        }
    }

    /**
     * https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
     * https://ide.geeksforgeeks.org/B5bStfff7I
     * @param node
     * @return
     */
    private LinkedList.Node deleteAlternateRecursive(LinkedList.Node node) {

        if (node == null)
            return null;

        if (node.next == null)
            return node;

        node.next = deleteAlternateRecursive(node.next.next);

        return node;
    }


    /**
     * https://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
     * https://ide.geeksforgeeks.org/YcOwiZDjPQ
     * @param list
     * @return
     */
    private LinkedList alternatingSplit(LinkedList list){
        LinkedList.Node p1 = list.head;

        if (p1 == null)
            return null;

        LinkedList.Node a1 = p1.next;

        LinkedList altList = new LinkedList();
        altList.head = a1;

        while (p1 != null && a1 != null) {
            p1.next = a1.next;
            p1 = p1.next;

            if (p1 != null)
                a1.next = p1.next;
            else
                a1.next = p1;

            a1 = a1.next;
        }
        return altList;
    }
}
