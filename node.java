class Node {

    private char c;
    private int freq;
    private Node left;
    private Node right;

    public Node(){
        this.c = '\0';
        this.freq = 0;
        this.left = null;
        this.right = null;
    
    }

    Node(char c, int freq) {
        this.c = c;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    Node(char c, int freq, Node left, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(){
        this.right = right;
    }
}