package Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;


@DisplayName("Node Testing")
class NodeTest {

    @Test
    @DisplayName("getSize Testing")
    void getSize() {
        System.out.println("The Size was returned");
        Assertions.fail("The Node is incomplete");
    }
}