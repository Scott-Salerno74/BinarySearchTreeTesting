package Testing;

import static org.junit.jupiter.api.Assertions.*;

import BinaryTree.BinarySearchTree;
import Models.PersonRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Binary Search Tree Testing ")
class BinarySearchTreeTest {
    private BinarySearchTree BST = new BinarySearchTree();
    private PersonRecord pR = new PersonRecord("101", "Scott", "Salerno", "sws001@lvc.edu", "G-unit", "Manager", "LVC");
    private PersonRecord pR2 = new PersonRecord("102", "Scott", "Robinson", "swr001@lvc.edu", "Corrections", "SSGT", "LVC");

    /**
     * Practice Tests.
     */
    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println("The BST is empty.");
    }

    @org.junit.jupiter.api.Test
    void size() {
        System.out.println("The Size of The BST was Asked For.");
    }

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("Something was Added to our BST.");
    }

    @org.junit.jupiter.api.Test
    void getPersonRecordByLastName() {
        System.out.println("The BST is being searched for a Last Name.");
    }

        @org.junit.jupiter.api.Test
    void contains() {
        System.out.println("The BST contains all of these nodes.");
    }
    /**
     * This Test tests the Addition Method
     * Update 2/12/19 : Addition is Working
     */
    @Test
    @DisplayName("Addition_Test")
    void test_1() {
        System.out.println("Testing Addition:");
        BST.add(pR);
        System.out.println(pR.getFirstName() + " " + pR.getLastName());
        assertFalse(BST.isEmpty());
        assertNotEquals(BST.getPersonRecordByLastName("Salerno"), BST.getPersonRecordByLastName("Salerno"));
        System.out.println("Addition Works !!!");


    }

    /**
     * This Test is To test the Contains Method
     * Update 2/12/19 Contains Does not show the top most element in our BST
     */

    @Test
    @DisplayName("Contains_Test")
    void test_2(){
        System.out.println("TestingContains:");
        BST.add(pR);
        BST.add(pR2);
        assertTrue(BST.contains("Robinson"),"Robinson is not found in the BST: " + " It is The Newest Node to be added to the Tree");
        assertTrue(BST.contains("Salerno"),"Salerno is not found in the BST: "+ " It is the First Node Placed in the Tree");
        System.out.println("Contains Works !!!");
    }

}