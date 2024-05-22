class customQueue {
    queueNode front, rear;
    int size;

    public customQueue(){
        this.front = this.rear = null;
        this.size = 0;
    }

    boolean isEmpty(){
        return this.front == null;
    }

    void enqueue(Node data){
        queueNode newNode = new queueNode(data);
        if(isEmpty()){
            this.front = this.rear = newNode;
            this.size++;
            return;
        }
        this.size++;
        this.rear.setNext(newNode);
        this.rear = newNode;
        
    }

    Node dequeue(){
        if(isEmpty()){
            return null;
        }
        queueNode temp = this.front;
        this.front = this.front.getNext();
        size--;
        if(this.front == null){
            this.rear = null;
        }
        return temp.getData();
    }

    int size(){
        return this.size;
    }

    Node peek(){
        if(isEmpty()){
            return null;
        }
        return this.front.getData();
    }
}
