
//E/17/219
//Nawarathna K.G.I.S.
//CO322 - Lab on Trees
//Task 2

//implementation of min heap function
class MinHeap {
    
    private int[] Heap;
    private int size;
    private int maxSize;

    // Intializing front as static with unity (aka root node)
    private static final int FRONT = 0;

    //constructor of this class
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize];
    }

    // Returns the position of the parent at the current pos
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Returns the position of the left child at the current pos
    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    // Returns the position of the right child at the current pos
    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    //check if the current pos is a leaf
    private boolean isLeaf(int pos) {
        // If 1) the pos is on the bottom level and 2) the pos is valid
        if (pos > size / 2 - 1 && pos <= size - 1) {
            return true;
        }
        return false;
    }

    //for swapping
    private void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    //to hapify the node at pos
    private void minHeapify(int pos) {

        //when the pos is not a leaf
        if (!isLeaf(pos)) {

            //in the case of at least one of children is bigger than the node
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

                // right child is the larger
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } 

                //left child is the larger
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        Heap[size] = element;
        int current = size;

        
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Prints all the content of the heap
    public void print() {

        for (int i = 0; i < size / 2; i++) {
            System.out.println("PARENT : " + Heap[i] + "   LEFT CHILD : " + Heap[2 * i + 1] + "   RIGHT CHILD : "
                    + Heap[2 * i + 2]);
        }
    }

    // Removes and returns the minimum element 
    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size - 1];
        minHeapify(FRONT);  
        size--;
        return popped;
    }

    public static void main(String[] args) {
        
        MinHeap minHeap = new MinHeap(15);

        //inserting values
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        
        //removing front and printing
        System.out.println("\nNew heap after removing, "+minHeap.remove());
        minHeap.print();
        
        //removing front and printing
        System.out.println("\nNew heap after removing, "+minHeap.remove());
        minHeap.print();
    }
}