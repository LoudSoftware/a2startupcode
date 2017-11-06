/***
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 *
 * Name:   
 * Student Number: 
 * Uottawa Email: 
 *
 *
 */
public class MyCompressedTrie {

    private TreeNodeWithData root;

    private int numNodes;

    public MyCompressedTrie() { // simple constructor (empty trie consisting of root only)
        root = new TreeNodeWithData(null, null, null, false, null);
        numNodes = 1;
    }


    // to be implemented by you see handout Part 2A
    // Constructor that receives a regular trie and creates this
    // instance that is a compressed trie
    //
    public MyCompressedTrie(MyTrie trie) {
        this();
        System.out.println("MyCompressedTrie(MyTrie) not implemented! Read comment in function!");

        /* Did not have time to complete this part however I can explain teh general process

        We need to make it so that each internal node must have two child nodes.
        If a parent has two child nodes,then since we actually need to have two diverging branches, we don't need to compress them.

        This means that generally if a parent has one child, it can be compressed. To do so, we would merge the 2 nodes and record the merge between their values.
         */

    }


    // Method to be implemented by you. See handout part 2A
    public void printStringsInLexicoOrder() {
        printStringsInLexicoOrder(root, "");
    }

    public void printStringsInLexicoOrder(TreeNodeWithData root, String str) {
        if (root.getData() != null) {
            System.out.print(str + ",");
        }
        if (root.getLeftChild() != null) {
            printStringsInLexicoOrder((TreeNodeWithData) root.getLeftChild(), str + "0");
        }
        if (root.getRightChild() != null) {
            printStringsInLexicoOrder((TreeNodeWithData) root.getRightChild(), str + "1");
        }
    }


    // the following method that calls its recursive counterpart
    // prints the tree and its data values at nodes in
    // in-order traversal order
    public void printInOrder() { // not to be changed
        printInOrder(root);
    }


    private void printInOrder(TreeNode N) { // not to be changed
        System.out.print("(");
        if (N != null) {
            printInOrder(N.getLeftChild());
            System.out.print(((TreeNodeWithData) N).getData());
            printInOrder(N.getRightChild());

        }
        System.out.print(")");
    }


    public int numNodes() {
        return numNodes;
    }


}
