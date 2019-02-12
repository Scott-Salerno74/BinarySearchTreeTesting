package MockingTests;

import DatabaseServices.CSVReader;
import DatabaseServices.Database;
import Models.PersonRecord;
import UserInterface.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MockitoTest {

    @Mock
    Database databaseMock;

    @InjectMocks
    CSVReader reader;


    @Test
    public void test() {

        Database mockedDatabase = mock(Database.class);

        // act of stubbing this method with "Plank" argument
        when(mockedDatabase.getPersonByLastName("Plank")).thenReturn(new PersonRecord("1", "asdf", "Plank", "Asdf", "asdf", "Asdf","asdf"));

        // should return asdf person because of stub
        System.out.println(mockedDatabase.getPersonByLastName("Plank"));

        // should return null because this person was not stubbed
        System.out.println(mockedDatabase.getPersonByLastName("Plasdfl;"));

    }




}
