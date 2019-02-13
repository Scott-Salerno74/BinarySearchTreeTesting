package UserInterface;
import DatabaseServices.CSVReader;
import DatabaseServices.Database;
import Models.PersonRecord;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class Main extends Application {

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    Stage stage;
    static Database db;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        primaryStage.setTitle("JavaFX Welcome");

        primaryStage.show();

        GridPane grid = new GridPane();
        // Changes the default position of the grid from top left of the scene to the center
        grid.setAlignment(Pos.CENTER_LEFT);
        // Manage the spacing between rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        // Manages the space around the edges of the grid pane
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");

        // can replace this with a style sheet
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        // Add to column 0, row 0. Set the column span to 2 and the row span to 1
        grid.add(scenetitle, 0, 0, 2, 1);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Last Name"
                );

        final ComboBox searchFilter = new ComboBox(options);
        searchFilter.getSelectionModel().selectFirst();

        grid.add(searchFilter, 1, 1);

        final TextField userTextField = new TextField();
        userTextField.setPromptText("John...");
        userTextField.setId("textField");
        // Add a text field to the grid pane at column 1, row 1
        grid.add(userTextField, 0, 1);
   
        Button searchBtn = new Button("Search");
        Button clearBtn = new Button("Clear");

        //Create an HBox layout with spacing of 10 pixels.  The HBox pane sets an alignment for the button that is different from the alignment applied to the other controls in the grid pane
        HBox hbBtn = new HBox(10);

        // Position a node at the bottom of the space vertically and at the right edge of the space horizontally
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);

        // Add button as a child of HBox pane
        hbBtn.getChildren().addAll(searchBtn, clearBtn);
        // Add the HBox pane to the grid in column 1, row 4
        grid.add(hbBtn, 0, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        final TableView table = new TableView();
        table.setMinHeight(150);

        final Label label = new Label("Search Results");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        final TableColumn<PersonRecord, String> firstNameCol = new TableColumn<PersonRecord, String>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));

        final TableColumn<PersonRecord, String> lastNameCol = new TableColumn<PersonRecord, String>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

        final TableColumn<PersonRecord, String> emailCol = new TableColumn<PersonRecord, String>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));

        final TableColumn<PersonRecord, String> companyCol = new TableColumn<PersonRecord, String>("Company");
        companyCol.setCellValueFactory(new PropertyValueFactory("company"));

        final TableColumn<PersonRecord, String> jobTitleCol = new TableColumn<PersonRecord, String>("Job Title");
        jobTitleCol.setCellValueFactory(new PropertyValueFactory("jobTitle"));

        final TableColumn<PersonRecord, String> universityCol =  new TableColumn<PersonRecord, String>("Uni");
        universityCol.setCellValueFactory(new PropertyValueFactory("university"));

        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, companyCol, jobTitleCol, universityCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        grid.add(vbox, 0, 5);

        Button clearTableBtn = new Button("Clear Table");
        HBox hbBtn2 = new HBox(10);

        hbBtn2.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn2.getChildren().addAll(clearTableBtn);

        grid.add(hbBtn2, 0, 6);


        final TextField firstNameTextField = new TextField();
        final TextField lastNameTextField = new TextField();
        final TextField emailTextField = new TextField();
        final TextField companyTextField = new TextField();
        final TextField jobTitleTextField = new TextField();
        final TextField universityTextField = new TextField();

        firstNameTextField.setPromptText("First name...");
        lastNameTextField.setPromptText("Last name...");
        emailTextField.setPromptText("Email...");
        companyTextField.setPromptText("Company...");
        jobTitleTextField.setPromptText("Job Title...");
        universityTextField.setPromptText("University...");

        firstNameTextField.setMaxWidth(100);
        lastNameTextField.setMaxWidth(100);
        emailTextField.setMaxWidth(100);
        companyTextField.setMaxWidth(100);
        jobTitleTextField.setMaxWidth(100);
        universityTextField.setMaxWidth(100);

        HBox row1 = new HBox();
        HBox row2 = new HBox();
        row1.getChildren().addAll(firstNameTextField, lastNameTextField, emailTextField);
        row2.getChildren().addAll(companyTextField, jobTitleTextField, universityTextField);
        grid.addRow(16, row1);
        grid.addRow(17, row2);

        Button insert = new Button("Insert");
        HBox insertBox = new HBox(10);
        insertBox.setAlignment(Pos.BOTTOM_LEFT);
        insertBox.getChildren().add(insert);
        grid.addRow(18, insertBox);

        /*
        final TextField deleteUserTextField = new TextField();
        deleteUserTextField.setPromptText("Delete user by last name...");
        deleteUserTextField.setMaxWidth(300);
        HBox deleteUserRow = new HBox(10);
        deleteUserRow.getChildren().add(deleteUserTextField);
        grid.addRow(19, deleteUserRow);
        Button delete = new Button("Delete");
        HBox deleteBox = new HBox(100);
        deleteBox.setAlignment(Pos.BOTTOM_LEFT);
        deleteBox.getChildren().add(delete);
        grid.addRow(20, deleteBox);
        */

        //---------------------- EVENT HANDLERS -------------------------------

        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                userTextField.clear();
                searchFilter.getSelectionModel().clearSelection();
                searchFilter.getSelectionModel().selectFirst();
                userTextField.setPromptText("John...");

            }
        });


        clearTableBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                table.getItems().clear();
            }
        });


        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Search button pressed");
                String searchText = userTextField.getText();
                logger.info("User is searching for {} ", searchText);

                PersonRecord found = db.getPersonByLastName(searchText);

                if(found == null) {

                    table.getItems().add(new PersonRecord("DNE", "DNE", "DNE", "DNE", "DNE", "DNE", "DNE"));

                } else {
                    System.out.println(found.getFirstName());
                    System.out.println(found.toString());

                    userTextField.clear();
                    searchFilter.getSelectionModel().select(1);

                    table.getItems().add(found);
                }




            }
        });

        searchFilter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int selectedIndex = searchFilter.getSelectionModel().getSelectedIndex();

                String choice = "";

                switch(selectedIndex) {
                    case 0:
                        choice = "First Name";
                        userTextField.setPromptText("John...");
                        break;
                    case 1:
                        choice = "Last Name";
                        userTextField.setPromptText("Phillips...");
                        break;
                    case 2:
                        choice = "E-Mail";
                        userTextField.setPromptText("johndoe@gmail.com...");
                        break;
                    case 3:
                        choice = "Company";
                        userTextField.setPromptText("Communist News Network...");
                        break;
                    case 4:
                        choice = "Job Title";
                        userTextField.setPromptText("Russian Spy...");
                        break;
                    case 5:
                        choice = "University";
                        userTextField.setPromptText("Lebanon Valley College...");
                        break;
                }

                System.out.println(choice);
            }
        });

        insert.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {

                 String id = Integer.toString(db.getNumberOfRecordsInTree() + 1);
                 String firstName = firstNameTextField.getText();
                 String lastName = lastNameTextField.getText();
                 String email = emailTextField.getText();
                 String company = companyTextField.getText();
                 String jobTitle= jobTitleTextField.getText();
                 String university = universityTextField.getText();

                 PersonRecord toAdd = new PersonRecord(id, firstName, lastName, email, company, jobTitle, university);
                 logger.info("Inserting record into tree: {} ", toAdd.toString());

                 firstNameTextField.clear();
                 lastNameTextField.clear();
                 emailTextField.clear();
                 companyTextField.clear();
                 jobTitleTextField.clear();
                 universityTextField.clear();

                 db.insertRecordIntoTree(toAdd);

             }
         });

        Scene scene = new Scene(grid, 750, 600);
        primaryStage.setScene(scene);
    }


    public static void main(String[] args) {

        db = new Database();
        CSVReader reader = new CSVReader();
        ArrayList<PersonRecord> records = reader.getAllDataFromCSVFile();
        db.fillBinaryTreeWithAllRecords(records);

        logger.debug("Binary Tree has {} entries", db.getNumberOfRecordsInTree());

        PersonRecord foundError = db.getPersonByLastName("Fumagallito");

        if(foundError == null) {
            logger.debug("Object is NULL");
        }

        boolean found = db.containsPersonByLastName("Plank");

        if(found)
            logger.info("Found the person");
        else {
            logger.error("Did not find person!");
        }

        PersonRecord p1 = db.getPersonByLastName("Plank");
        logger.info("Got person {} from company {}", p1.getFirstName(), p1.getCompany());

        PersonRecord p2 = db.getPersonByLastName("Golt");
        logger.info("Got person {} from university {}", p2.getFirstName(), p2.getUniversity());

        PersonRecord p3 = db.getPersonByLastName("Irnis");
        logger.info("Got in person {} with ID {}", p3.getFirstName(), p3.getId());

        System.out.println("done");

        launch(args);
    }
}
