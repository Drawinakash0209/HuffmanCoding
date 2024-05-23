import java.util.ArrayList;
import java.util.List;
public class MyHashMap <K, V>{

    class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getkey(){
            return key;
        }

        public V getvalue(){
            return value;
        }

        public void setvalue(V value){
            this.value = value;
        }
    }

    private int SIZE = 16;
    Entry<K, V> table[];

    public MyHashMap(){
        table = new Entry[SIZE];       
    }

    public void put(K key, V value){
        int index = key.hashCode() % SIZE;
        Entry<K, V> entry = table[index];

        if(entry == null){
            table[index] = new Entry<K, V>(key, value);
    }else{
        while (entry.next != null){
            if(entry.getkey().equals(key)){
                entry.setvalue(value);
                return;
            }
            entry = entry.next;
            
        }
        if(entry.getkey().equals(key)){
            entry.setvalue(value);
            return;
        }
        entry.next = new Entry<K, V>(key, value);        
    }
}

public V get(K key){
    int index = key.hashCode() % SIZE;
    Entry<K, V> entry = table[index];

   if (entry == null){
       return null;   
   }
    while(entry != null){
         if(entry.getkey().equals(key)){
              return entry.getvalue();
         }
         entry = entry.next;
   }
   return null;
}

public Entry<K, V> remove(K key){
    int index = key.hashCode() % SIZE;
    Entry<K, V> entry = table[index];
    
    if(entry == null){
        return null;
    }

    if(entry.getkey().equals(entry)){
        table[index] = entry.next;
        entry.next = null;
        return entry;
    }

    Entry<K, V> prev = entry;
    entry = entry.next;

    while(entry != null){
        if(entry.getkey().equals(key)){
            prev.next = entry.next;
            entry.next = null;
            return entry;
        }
        prev = entry;
        entry = entry.next;
    }
    return null;
}

public V getOrDefault(K key, V defaultValue) {
    int index = key.hashCode() % SIZE;
    Entry<K, V> entry = table[index];

    if (entry == null) {
        return defaultValue;
    }

    while (entry != null) {
        if (entry.getkey().equals(key)) {
            return entry.getvalue();
        }
        entry = entry.next;
    }
    return defaultValue;
}
//create a method to display the hashmap
public void display(){
    for (int i = 0; i < SIZE; i++) {
        Entry<K, V> entry = table[i];
        while (entry != null) {
            System.out.print("{" + entry.getkey() + "=" + entry.getvalue() + "}" + " ");
            entry = entry.next;
        }
    }
    System.out.println();
}

public int size(){
    return SIZE;}

    public List<Entry<K, V>> entrySet() {
        List<Entry<K, V>> entries = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Entry<K, V> entry = table[i];
            while (entry!= null) {
                entries.add(entry);
                entry = entry.next;
            }
        }
        return entries;
    }

}