import sun.text.normalizer.Trie;
import sun.text.normalizer.TrieIterator;

/***
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 *
 * Name:   
 * Student Number: 
 * Uottawa Email: 
 *
 *
 */

public class MyTrie {

    private TreeNode root = null;

    private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
    public MyTrie() {
        root = new TreeNode(null, null, null, false);
        numNodes = 1;
    }

    // Method to be implemented by you. See handout part 1A
    public boolean insert(String s) {

        TreeNode currentNode = root;

        boolean neverTouched = true;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if ('0' == currentChar) { // We need to go left or make a left child
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(new TreeNode(currentNode, null, null, false)
                    );
                    neverTouched = false;
                    numNodes++;
                }
                currentNode = currentNode.getLeftChild();

            } else if ('1' == currentChar) { // we need to go right or make a right child
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(new TreeNode(currentNode, null, null, false)
                    );
                    neverTouched = false;
                    numNodes++;
                }
                currentNode = currentNode.getRightChild();
            }

            if (i == s.length() - 1 && neverTouched && currentNode.getIsUsed()) {
                return false;
            }
        }
        currentNode.setIsUsed(true);
        return true;
    }

    // Method to be implemented by you. See handout part 1A
    public boolean search(String s) {
        // **** method code to be added in this class *****
        // now we just have a dummy that prints  message and returns true.
        TreeNode currentNode = root;
        boolean answer = false;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if ('0' == currentChar) { // We need to go left or make a left child
                if (currentNode.getLeftChild() == null) {
                    return false;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            } else if ('1' == currentChar) { // we need to go right or make a right child
                if (currentNode.getRightChild() == null) {
                    return false;
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }
        return currentNode.getIsUsed();
    }


    // Method to be implemented by you. See handout part 1A
    public void printStringsInLexicoOrder() {
        printStringsInLexicoOrder(root, "");
    }

    public void printStringsInLexicoOrder(TreeNode root, String str) {
        if (root.getIsUsed()) {
            System.out.print(str + ",");
        }
        if (root.getLeftChild() != null) {
            printStringsInLexicoOrder(root.getLeftChild(), str + "0");
        }
        if (root.getRightChild() != null) {
            printStringsInLexicoOrder(root.getRightChild(), str + "1");
        }
    }


    // the following method that calls its recursive counterpart
    // prints the tree and its boolean values at nodes in
    // in-order traversal order

    public void printInOrder() { // not to be changed
        printInOrder(root);
    }

    private void printInOrder(TreeNode N) { // not to be changed
        System.out.print("(");
        if (N != null) {
            printInOrder(N.getLeftChild());
            System.out.print(N.getIsUsed());
            printInOrder(N.getRightChild());

        }
        System.out.print(")");
    }


    public TreeNode root() { // not to be changed
        return root;
    }

    public int numNodes() { // not to be changed
        return numNodes;
    }


}
