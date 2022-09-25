//E/17/219
//Nawarathna K.G.I.S.
//CO322 - Lab on Trees
//Task 1

public class AVLTree {
    public class Node {
        int key;                    //key of the node
        int height;                 //heigh of the node
        Node left;                  //for left sub tree
        Node right;                 //for right sub tree

        Node(int key) {             //constructor
            this.key = key;
            this.height = 1;    // Height is initialized as 1
        }
    }

    //AVL trees

    private Node root;

    // getting the left most node(leaf)
    private Node leftmostChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private void updateHeight(Node n) {
        // getting the height of the given node
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        // Since initial height is taken as 1, if it's a leaf returns 0
        return n == null ? 0 : n.height;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    // Rotating the tree to the right(single)
    //returns the root of the new subtree
    private Node rotateRight(Node y) {
        //rotating operation
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;

        //updating heights
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Rotating the tree to the left(single)
    //returns the root of the new subtree
    private Node rotateLeft(Node y) {
       
        //rotating operation
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;

        //updating heights
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    // Keep the AVL tree balanced at any change in its nodes
    private Node rebalance(Node z) {

        updateHeight(z);
        int balance = getBalance(z);

        if (balance > 1) { // tree is heavy on right
            if (height(z.right.right) > height(z.right.left)) {     //checking the heavey side if outmost right or inside right
                z = rotateLeft(z);      //incase of the outmost right
            } else { // Double rotation in case of the inside right
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } 
        
        else if (balance < -1) { // tree is heavy on right
            if (height(z.left.left) > height(z.left.right)) {       //checking the heavey side if outmost left or inside left
                z = rotateRight(z);     //incase of the outmost left
            } else { // Double rotation in case of the inside left
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }

        return z;
    }

    //part 1 
    
    // Inserting a new node to the AVL tree
    private Node insert(Node node, int key) {
        
        if (node == null) {                 //if the node is null create the new node with the given key
            return new Node(key);
        } else if (node.key > key) {        //if the current key is bigger than the given key, go to left
            node.left = insert(node.left, key);
        } else if (node.key < key) {        //if the current key is smaller than the given key, go to right
            node.right = insert(node.right, key);
        } else {                            //if the current key is similar to the given key it is a duplicate key
            throw new RuntimeException("duplicate key!");
        }
        return rebalance(node);
    }

    private Node delete(Node node, int key) {
        
        if (node == null) {                 //if the node is null return that node
            return node;
        } else if (node.key > key) {        //if the current key is bigger than the given key, go to left
            node.left = delete(node.left, key);
        } else if (node.key < key) {        //if the current key is smaller than the given key, go to right
            node.right = delete(node.right, key);
        } else {                            //if the current key and the given key is same , the searching node is the current node
            if (node.left == null || node.right == null) {  //checking if there are two children for the current node
                
                node = (node.left == null) ? node.right : node.left;    //replacing the current node with its' left or right child
            } else {
                //if there are two children for the current node
                //replace the current node with the highest value of the left sub tree
                Node leftmostChild = leftmostChild(node.right);
                node.key = leftmostChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;        //returning the deleted node
    }

    //binary searching for a given node using the key
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            // Proceeding to the next iteration,,,
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    //part 2 
    //traversal

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }


    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /*
                 30
                /  \
               20  40
              /  \   \
             10  25  50
        */

        System.out.println("Root of the tree is "+tree.root.key); //root of the tree

        // Tree Traversal Algorithms
        System.out.print("Performing the pre order traversal on the tree : ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.print("Performing the in order traversal on the tree : ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.print("Performing the post order traversal on the tree : ");
        tree.postOrder(tree.root);
        System.out.println();

        //deleting the root
        System.out.println("New root is "+tree.delete(tree.root, 30).key);

        //inorder traversal after deletion
        System.out.print("Performing the in order traversal on the tree after deletion : ");
        tree.inOrder(tree.root);
        System.out.println();

        
    }
}