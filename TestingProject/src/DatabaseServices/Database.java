package DatabaseServices;

import BinaryTree.BinarySearchTree;
import Models.PersonRecord;
import UserInterface.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Database {

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    private BinarySearchTree dataTree;

    public Database() {
        dataTree = new BinarySearchTree();
    }

    public ArrayList<PersonRecord> getAllRecords() {
        CSVReader reader = new CSVReader();
        return reader.getAllDataFromCSVFile();

    }

    public PersonRecord getPersonByLastName(String lastName) {
        PersonRecord  personToReturn = dataTree.getPersonRecordByLastName(lastName);

        if(personToReturn == null) {
            logger.error("The person is NULL!");
            return null;
        }

        logger.debug("Returning person {} with email {}", personToReturn.getFirstName(), personToReturn.getEmail());

        return personToReturn;

    }

    public void fillBinaryTreeWithAllRecords(ArrayList<PersonRecord> records) {

        for(PersonRecord r : records) {
            dataTree.add(r);
        }

        logger.info("Done filling tree");
    }

    public boolean containsPersonByLastName(String lastName) {
        return dataTree.contains(lastName);
    }

    public void insertRecordIntoTree(PersonRecord r) {
        dataTree.add(r);
    }

    public int getNumberOfRecordsInTree() {
        return dataTree.size();
    }

}
