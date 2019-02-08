package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Binary Search Tree Testing ")
class BinarySearchTreeTest {

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
    @Test
    @DisplayName("Test_1")
    void test_1(){
        System.out.println("First Test");
        Assertions.fail("The Program has Failed");
    }
    @Test
    @DisplayName("Test_2")
    void emptyTest(){
        System.out.println("Second Test");
    }

}