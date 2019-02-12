package BinaryTree;

import Models.PersonRecord;

public class Node {

    private int size; // number of nodes in the tree rooted at this node

    PersonRecord value;
    Node left;
    Node right;

    public Node(PersonRecord value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public int getSize() {
        return this.size;
    }

}
