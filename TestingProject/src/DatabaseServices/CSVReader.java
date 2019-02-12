package DatabaseServices;

import Models.PersonRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    ArrayList<PersonRecord> people;

    public CSVReader() {
        people = new ArrayList<PersonRecord>();
    }

    public ArrayList<PersonRecord> getAllDataFromCSVFile() {

        String fileForLogan = "/home/logan/BinarySearchTreeTesting/TestingProject/src/DatabaseServices/MOCK_DATA.csv";
        String fileForKurt = "/home/LVC/kdm004/IdeaProjects/BinarySearchTreeTesting/TestingProject/src/DatabaseServices/MOCK_DATA.csv";

        String csvFile = fileForLogan;
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            reader = new BufferedReader(new FileReader(csvFile));

            reader.readLine(); // skip column names

            while ((line = reader.readLine()) != null) {

                // use comma as separator
                String[] person = line.split(cvsSplitBy);

                String id = person[0];
                String firstName = person[1];
                String lastName = person[2];
                String email = person[3];
                String company = person[4];
                String jobTitle = person[5];
                String university = person[6];


                //System.out.println(id + " " + firstName + " " + lastName + " " + email + " " + company + " " + jobTitle + " " + university);

                PersonRecord personToAdd = new PersonRecord(id, firstName, lastName, email, company, jobTitle, university);

                people.add(personToAdd);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }
}
