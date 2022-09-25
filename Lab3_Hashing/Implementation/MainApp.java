class MainApp{

    public static void main(String [] args){

        //Testing the hashtable class
        testHashTable();
    
        System.out.println();

        //Testing the linked hash table class
        testLinkedHashTable();
        
        
    }

    public static void testLinkedHashTable(){

        System.out.println("Testing Liked Hash Table");
        
        //hash table with 13 elements
        LinkedHashTable hashTable = new LinkedHashTable(13);

        //inserting some values to the hash table
        hashTable.insert(4, "value 4");
        hashTable.insert(17, "value 17");
        hashTable.insert(222, "value 222");
        hashTable.insert(0, "value 0");
        hashTable.insert(50, "value 50");
        hashTable.insert(51, "value 51");
        hashTable.insert(52, "value 52");
        hashTable.insert(53, "value 53");
        hashTable.insert(54, "value 54");
        hashTable.insert(55, "value 55");
        hashTable.insert(56, "value 56");
        hashTable.insert(57, "value 57");
        hashTable.insert(58, "value 58");

        //printing the values in the hash table
        hashTable.printList();

        //printing the current size of the hash table
        System.out.println(hashTable.getCurrentSize());
 
        //removing all the inserted values 
        hashTable.remove(17);
        hashTable.remove(222);
        hashTable.remove(0);
        hashTable.remove(50);
        hashTable.remove(51);
        hashTable.remove(52);
        hashTable.remove(53);
        hashTable.remove(54);
        hashTable.remove(55);
        hashTable.remove(56);
        hashTable.remove(57);
        hashTable.remove(58);
        hashTable.remove(4);
        
        
        if(hashTable.isEmpty()){
            System.out.println("All the values of the hash table have been removed!");
        }else{
            System.out.println("Remaing elements");
            hashTable.printList();
        }
    }

    public static void testHashTable(){

        System.out.println("Testing Hash Table");

        
        //hash table with 13 elements
        HashTable hashTable = new HashTable(13);

        //inserting some values to the hash table
        hashTable.insert(4, "value 4");
        hashTable.insert(17, "value 17");
        hashTable.insert(222, "value 222");
        hashTable.insert(0, "value 0");
        hashTable.insert(50, "value 50");
        hashTable.insert(51, "value 51");
        hashTable.insert(52, "value 52");
        hashTable.insert(53, "value 53");
        hashTable.insert(54, "value 54");
        hashTable.insert(55, "value 55");
        hashTable.insert(56, "value 56");
        hashTable.insert(57, "value 57");
        hashTable.insert(58, "value 58");

        //printing the values in the hash table
        hashTable.printList();

        //printing the current size of the hash table
        System.out.println(hashTable.getCurrentSize());
 
        //removing all the inserted values 
        hashTable.remove(17);
        hashTable.remove(222);
        hashTable.remove(0);
        hashTable.remove(50);
        hashTable.remove(51);
        hashTable.remove(52);
        hashTable.remove(53);
        hashTable.remove(54);
        hashTable.remove(55);
        hashTable.remove(56);
        hashTable.remove(57);
        hashTable.remove(58);
        hashTable.remove(4);
        
        
        if(hashTable.isEmpty()){
            System.out.println("All the values of the hash table have been removed!");
        }else{
            System.out.println("Remaing elements");
            
            hashTable.printList();
        }
    }
}