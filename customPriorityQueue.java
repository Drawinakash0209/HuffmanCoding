class ListNode{
    Node data;
    ListNode next;

    public ListNode(Node data){
        this.data = data;
        this.next = null;
    }
}


class customPriorityQueue {

    private ListNode head;
    private int size;

    public customPriorityQueue(){
        head = null;
        size = 0;
    }

    public void add(Node node){
        ListNode newNode = new ListNode(node);
        if (head == null || head.data.getFreq() > node.getFreq()) {
            newNode.next = head;
            head = newNode;
        }
        else{
            ListNode temp = head;
            while (temp.next != null && temp.next.data.getFreq() < node.getFreq()) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public Node poll(){
        if (head == null) {
            return null;
        }
        Node temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public Node peek(){
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    
}
