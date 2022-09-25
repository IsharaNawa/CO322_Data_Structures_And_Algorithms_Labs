//E17219
//K.G.I.S.Nawarathna

//importing nessesary libraries
import java.util.LinkedList;
import java.util.Arrays;

//class for the hash table with chining
public class LinkedHashTable {

    //arrays of liked lists to store values with the same hash value
    private LinkedList<Entry>[] linkedEntrylist;

    //stores the number of rows in the hash table and number of values in the hash table
    private int capacity, currentSize;

    //liked hashtable is declared the the capacity
    public LinkedHashTable(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        linkedEntrylist = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            linkedEntrylist[i] = new LinkedList<Entry>();
        }
    }

    //clearing the whole hash table
    public void clear() {
        this.currentSize = 0;
        linkedEntrylist = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            linkedEntrylist[i] = new LinkedList<Entry>();
        }
    }

    //getting the number of items in the hash table
    public int getCurrentSize() {
        return currentSize;
    }

    
    //deciding if the hash table is empty or not
    public boolean isEmpty() {
        return currentSize == 0;
    }

    //deciding if the hash table contains a key
    public boolean containsKey(int key) {
        return get(key) != null;
    }

    //initializing the hashing function
    private int hash(int key) {
        return key % capacity;
    }

    //adding a node to the hash table
    public void insert(int key, String value) {
        if (currentSize == capacity)    // If the hashtable is full...
            return;
        Entry entryToInsert = new Entry(key, value);
        int h = hash(key);
        LinkedList<Entry> column = linkedEntrylist[h];

        // To handle duplicate entries
        for (Entry entry : column) {
            if (entry.getKey() == key) {
                System.out.println("Key " + key + " already exists!");
                return;
            }
        }
        column.add(entryToInsert);
        currentSize++;
    }

    //getting a value from the hash table based on the key
    public String get(int key) {
        int h = hash(key);
        LinkedList<Entry> column = linkedEntrylist[h];
        for (Entry entry : column) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return null;
    }

    //removing an entry from the hash table
    public void remove(int key) {
        int h = hash(key);
        LinkedList<Entry> row = linkedEntrylist[h];
        row.removeIf(entry -> entry.getKey() == key);
        currentSize--;
    }

    //printing the hash table
    public void printList() {
        Arrays.stream(linkedEntrylist).forEach(column -> {
            if (column != null) {
                column.forEach(entry -> {
                    if (entry != null) {
                        System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
                    }
                });
            }
        });
    }
}