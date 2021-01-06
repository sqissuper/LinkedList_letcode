class Node{
    public int val;
    public Node next;

    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkList {
    //打印链表
    public void disPlay(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    //删除重复节点
    public Node removeDupNode(){
        if(this.head == null){
            return null;
        }
        Node newHead = new Node(0);
        Node cur = this.head;
        Node prev = newHead;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
            prev.next = null;
        }
        return newHead.next;
    }

    //链表分割
    public Node SplitList(int x){
        if(this.head == null){
            return null;
        }
        Node Fs = null;
        Node Fe = null;
        Node Ss = null;
        Node Se = null;
        Node cur = this.head;
        while(cur != null){
            if(cur.val < x){
                if(Fs == null){
                    Fs = cur;
                    Fe = cur;
                }else{
                    Fe.next = cur;
                    Fe = Fe.next;
                }

            }else{
                if(Ss == null){
                    Ss = cur;
                    Se = cur;
                }else{
                    Se.next = cur;
                    Se = Se.next;
                }
            }
            cur = cur.next;
        }
        if(Fs == null){
            return Ss;
        }
        if(Ss != null){
            Se.next = null;
        }
        Fe.next = Ss;
        return Fs;
    }

    //找倒数第K个值
    public Node finBotK(int k){
        if(this.head == null || k < 0){
            return null;
        }
        Node fast = this.head;
        while(k - 1 != 0){
            fast = fast.next;
            k--;
        }
        Node slow = this.head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //找中间节点
    public Node finMidNode(){
        Node fast = this.head;
        Node slow = this.head;
        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node head;//头节点
    //创造链表
    public void createList(){
        this.head = new Node(1);
        Node nod2 = new Node(2);
        Node nod3 = new Node(4);
        Node nod4 = new Node(3);
        Node nod5 = new Node(6);
        Node nod6 = new Node(8);
        this.head.next = nod2;
        nod2.next = nod3;
        nod3.next = nod4;
        nod4.next = nod5;
        nod5.next = nod6;
    }


    //删除链表所有
//    public ListNode removeElements(ListNode head, int val) {
//
//        if(head == null){
//
//            return null;
//
//        }
//
//        ListNode newHead = new ListNode(0);
//
//        ListNode prev = newHead;
//
//        ListNode cur = head;
//
//        while(cur != null){
//
//            if(cur.val == val){
//
//                prev.next = cur.next;
//
//            }else{
//
//                prev.next = cur;
//
//                prev = prev.next;
//
//            }
//
//            cur = cur.next;
//
//
//
//        }
//
//        return newHead.next;
//
//    }
    //反转单链表
//    public ListNode reverseList(ListNode head) {
//
//        ListNode prev = null;
//
//        ListNode newHead = null;
//
//        ListNode cur = head;
//
//        while(cur != null){
//
//            ListNode curNext = cur.next;
//
//            if(curNext == null){
//
//                newHead = cur;
//
//            }
//
//            cur.next = prev;
//
//            prev = cur;
//
//            cur = curNext;
//
//        }
//
//        return newHead;
//
//
//
//    }


//    合并有序链表
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//        ListNode newHead = new ListNode(0);
//
//        ListNode tmp = newHead;
//
//        while(l1 != null && l2 != null){
//
//            if(l1.val < l2.val){
//
//                tmp.next = l1;
//
//                l1 = l1.next;
//
//            }else{
//
//                tmp.next = l2;
//
//                l2 = l2.next;
//
//            }
//
//            tmp = tmp.next;
//
//        }
//
//        if(l1 == null){
//
//            tmp.next = l2;
//
//        }
//
//        if(l2 == null){
//
//            tmp.next = l1;
//
//        }
//
//        return newHead.next;
//
//    }



    public static void main(String[] args) {
        MyLinkList myList = new MyLinkList();
        myList.createList();
        myList.disPlay();
        System.out.println();
//        Node ret = myList.removeDupNode();
//        while(ret != null){
//            System.out.print(ret.val + " ");
//            ret = ret.next;
//        }
//        Node ret = myList.SplitList(5);
//        while(ret != null){
//            System.out.print(ret.val + " ");
//            ret = ret.next;
//        }
//        Node ret = myList.finBotK(3);
//        System.out.println(ret.val);
        Node ret = myList.finMidNode();
        System.out.println(ret.val);
    }
}
