import java.util.HashMap;


class huffmancoding {
    
    static void huffcode(String inputString){

        if (inputString == null || inputString.length() == 0) {
            return;      
        }

        System.out.println("Input String: " + inputString);

        //custom hashmap
        MyHashMap<Character, Integer> charCountMap = new MyHashMap<Character, Integer>();

        for(char c : inputString.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }



        //Custom priority queue
       customPriorityQueue cq = new customPriorityQueue();

    

        for(var c: charCountMap.entrySet()){
            cq.add(new Node(c.getkey(), c.getvalue()));
        }


        System.out.println("CQ PEEK: " + cq.peek().getFreq() + "\n");

        charCountMap.display();
        customQueue q1 = new customQueue();
        customQueue q2 = new customQueue();

        // while (!q.isEmpty()) {
        //     q1.enqueue(q.poll());
        // }

        while (!cq.isEmpty()) {
            q1.enqueue(cq.poll());
            
        }

        while (q1.size() + q2.size() > 1) {
            Node left = getMinFreqNode(q1, q2);
            Node right = getMinFreqNode(q1, q2);
            Node newNode = new Node('$', left.getFreq() + right.getFreq(), left, right);
            q2.enqueue(newNode);
            
        }

        Node root = q2.peek();

        System.out.println("Total number of Charachters and the root is: ");
        System.out.println(root.getFreq());

        HashMap<Character, String> huffmanCode = new HashMap<>();

        encodeData(root, "", huffmanCode);

        System.out.println("Huffman Codes of the characthers are: " + huffmanCode + "\n");

        StringBuilder encodedData = new StringBuilder();

        for(char c : inputString.toCharArray()){
            encodedData.append(huffmanCode.get(c));
        }
        System.out.println("Encoded Data: " + encodedData + "\n");
        System.out.println("Decoded Data: ");
        int index = -1;

        while (index < encodedData.length() - 1) {
            index = decodeData(root, index, encodedData);
        }

    }


    static Node getMinFreqNode(customQueue q1, customQueue q2){
       if (q1.isEmpty()) {
        return q2.dequeue();        
       }
       if (q2.isEmpty()) {
        return q1.dequeue();         
       }
       return q1.peek().getFreq() < q2.peek().getFreq() ? q1.dequeue() : q2.dequeue();
    }



    public static void encodeData(Node root, String str, HashMap<Character, String> huffmanCode){
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            if (str.length() > 0) {
                huffmanCode.put(root.getC(), str);                
            }
            else{
                huffmanCode.put(root.getC(), "1");
            }
        }
        encodeData(root.getLeft(), str+"0", huffmanCode);
        encodeData(root.getRight(), str+"1", huffmanCode);
    }



    public static int decodeData(Node root, int index, StringBuilder encodedData){
        if (root == null) {
            return index;            
        }
        if (isLeaf(root)) {
            System.out.print(root.getC());
            return index;
        }
        index++;
        if (encodedData.charAt(index) == '0') {
            root = root.getLeft();
        }
        else{
            root = root.getRight();    
        }

        index = decodeData(root, index, encodedData);

        return index;
    }

    public static boolean isLeaf(Node root){
        return root.getLeft() == null && root.getRight() == null;
    }    
}
