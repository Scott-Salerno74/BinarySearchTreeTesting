package MockingTests;

import DatabaseServices.Database;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoTest {

    @Mock
    Database databaseMock;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testQuery() {

    }

}
