package Testing;

import BinaryTree.BinarySearchTree;
import BinaryTree.Node;
import Models.PersonRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;


@DisplayName("Node Testing")
class NodeTest {
    private BinarySearchTree BST = new BinarySearchTree();
    private PersonRecord record = new PersonRecord("101","Bruce","Wayne","notBatMan@batcave.com","Wayne Enterprises","President","Wayne Tech");
    private PersonRecord record2 = new PersonRecord("102","Peter","Parker","spidey_shots76@marvel.com","Daily Bugle","Photographer","Empire State");
    private Node n = new Node(record2);
    /**
     * Testing if the Size of Tree is same as size of Node
     * Created my own Node So it Must have been Zero with no branches.
     * Need a way to access Node root from BinarySearchTree.
     */

    @Test
    @DisplayName("getSize Testing")
    void getSize() {
        BST.add(record);
        BST.add(record2);
        assertSame(0,n.getSize());
        System.out.println("The Size was returned");

    }
}