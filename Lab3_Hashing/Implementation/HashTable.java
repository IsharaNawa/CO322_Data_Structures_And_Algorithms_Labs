//E17219
//K.G.I.S.Nawarathna

//importing nessesary libraries
import java.util.Arrays;

//class for the hash table with double hashing
public class HashTable {
    
    private Entry[] entryList;      //storing the entry list
    private int capacity;           //storinng the capacity of the table
    private int currentSize;        //storing the current size of the table

    //initializing the table with the capacity
    public HashTable(int capacity){
        this.capacity=capacity;
        this.entryList = new Entry[capacity];
        this.currentSize = 0;
    }

    //clearing all the elements in the table
    public void clearAll(){
        this.entryList = new Entry[capacity];
        this.currentSize = 0;
    }

    //getting the number of items that are filled in the table
    public int getCurrentSize(){
        return this.currentSize;
    }

    //deciding if the hash table is full or not
    public boolean isFull(){
        return this.currentSize==this.capacity;
    }

    //deciding if the hash table is empty or not
    public boolean isEmpty(){
        return this.currentSize==0;
    }

    //deciding if a certian key is in the hash table or not
    public boolean containsKey(int key){
        return get(key) != null;
    }

    //primary hash function
    public int hash1(int key){
        return key % this.capacity;
    }

    //secondary hash function
    public int hash2(int key,int iteration){
        return iteration*(1+key%(this.capacity-1));
    }

    //adding a key value pair to the hash table
    public void insert(int key,String value){

        if (this.isFull()) return;

        int h1 = hash1(key);
        int iteration = 1;

        while(entryList[h1]!=null){
            h1 = (h1 + hash2(key,iteration)) % this.capacity;
            iteration++;

            if(iteration>1000) return;
        }


        entryList[h1] = new Entry(key,value);
        currentSize += 1;

    }

    //getting the entry list
    public Entry[] getEntryList(){
        return this.entryList;
    }

    //getting a certain value based on the key from the hash table
    public String get(int key) {
		int h1 = hash1(key);
		int initial=h1;
		int iteration = 1;
		
		while(true){
			if(entryList[h1]!=null) {
				if(entryList[h1].getKey()==key) {
					return entryList[h1].getValue();
				}
			}
			h1 = (h1+hash2(key,iteration))%capacity;

            if(h1==initial) {
				return null;
			}
			iteration++;
		}
	}

    //removing a value from the hash table based on the key
    public void remove(int key){

        if(!containsKey(key)) return;

        int h1 = hash1(key);

        Entry readEntry = entryList[h1];

        int iteration = 1;

        while(readEntry!=null && readEntry.getKey() != key){
            h1 = (h1 + hash2(key,iteration)) % this.capacity;
            readEntry = entryList[h1];
            iteration++;
        }

        entryList[h1] = null;

        currentSize -= 1;

    }

    //priniting the whole hash table
    public void printList(){
        Arrays.stream(entryList).forEach(entry ->{
            if(entry!=null){
                System.out.println("key : "+entry.getKey() + " value : "+entry.getValue());
            }
        });
    }
}
