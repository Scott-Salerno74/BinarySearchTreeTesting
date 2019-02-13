package DatabaseServices;

import BinaryTree.BinarySearchTree;
import BinaryTree.Node;
import Models.PersonRecord;
import UserInterface.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;



public class Database {

    static final Logger logger = LogManager.getLogger(Main.class.getName());



    //private ArrayList<PersonRecord> data;
    private BinarySearchTree dataTree;

    public Database() {
        dataTree = new BinarySearchTree();

        //add records to tree
    }

    public ArrayList<PersonRecord> getAllRecords() {
        CSVReader reader = new CSVReader();
        return reader.getAllDataFromCSVFile();

    }

    public PersonRecord getPersonByLastName(String lastName) {
        PersonRecord  personToReturn = dataTree.getPersonRecordByLastName(lastName);

        if(personToReturn == null) {
            System.out.println("NULL FROM SEARCH!!!");
            return null;
        }


        logger.debug("Logging in person {} with email {}", personToReturn.getFirstName(), personToReturn.getEmail());



        return personToReturn;

    }

    public void fillBinaryTreeWithAllRecords(ArrayList<PersonRecord> records) {

        for(PersonRecord r : records) {
            //System.out.println("Adding " + r.getLastname() + " to the tree");

            dataTree.add(r);
        }

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
