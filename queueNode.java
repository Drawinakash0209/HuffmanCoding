class queueNode {
    private Node data;
    private queueNode next;

    public queueNode(){
        this.data = null;
        this.next = null;
    }

    public queueNode(Node data){
        this.data = data;
        this.next = null;
    }

    public Node getData(){
        return data;
    }

    public void setData(Node data){
        this.data = data;
    }

    public queueNode getNext(){
        return next;
    }

    public void setNext(queueNode next){
        this.next = next;
    }

    
    
}
