package UserInterface;
import DatabaseServices.CSVReader;
import DatabaseServices.Database;
import Models.PersonRecord;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

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
                        "First Name",
                        "Last Name",
                        "E-mail",
                        "Company",
                        "Job Title",
                        "University"
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


        //grid.setGridLinesVisible(true);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);



        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                userTextField.clear();
                searchFilter.getSelectionModel().clearSelection();
                searchFilter.getSelectionModel().selectFirst();
                userTextField.setPromptText("John...");

            }
        });

///////////////

        final TableView table = new TableView();

        final Label label = new Label("Search Results");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        final TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn companyCol = new TableColumn("Company");
        TableColumn jobTitleCol = new TableColumn("Job Title");
        TableColumn universityCol =  new TableColumn("Uni");

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


        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Search button pressed");
                String searchText = userTextField.getText();
                //PersonRecord personToSearch = db.getPersonByLastName(searchText));
                System.out.println("User is seraching for " + searchText );
                PersonRecord found = db.getPersonByLastName(searchText);
                System.out.println(found.getFirstName());

                //firstNameCol.setCellFactory(found.getFirstName());
/*
                table.getColumns().set(0, found.getFirstName());
                table.getColumns().set(1, found.getLastName());
                table.getColumns().set(2, found.getCompany());
                table.getColumns().set(3, found.getEmail());
                table.getColumns().set(4, found.getJobTitle());
                table.getColumns().set(5, found.getUniversity());
*/


            }
        });


        ///////////////

        searchFilter.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int selectedIndex = searchFilter.getSelectionModel().getSelectedIndex();
                //String choice = (String) searchFilter.getItems().get(selectedIndex);

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


                // first name, last name, e-mail, company, job title, university

                // userTextField.setPromptText("");



            }
        });

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


        insert.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {

                 System.out.println("Inserting...");
                 firstNameTextField.clear();
                 lastNameTextField.clear();
                 emailTextField.clear();
                 companyTextField.clear();
                 jobTitleTextField.clear();
                 universityTextField.clear();

             }
         });

        /*
        firstNameTextField.setMaxWidth(100);
        companyTextField.setMaxWidth(100);
        lastNameTextField.setMaxWidth(100);


        Label add = new Label("Add a record...");
        grid.add(add, 1, 14);

        //insertBox.getChildren().addAll(firstNameTextField, lastNameTextField, emailTextField, companyTextField, jobTitleTextField, universityTextField);

        //grid.add(insertBox, 1, 16);

        grid.add(firstNameTextField, 1, 16);
        grid.add(lastNameTextField, 2, 16);
        grid.add(emailTextField, 3, 16);
        grid.add(companyTextField, 1, 17);
        grid.add(jobTitleTextField, 2, 17);
        grid.add(universityTextField, 3, 17);
        */
/////

       // grid.add(add, 1,8);

        /*

        Label firstNameLabel = new Label("First name");
        grid.add(firstNameLabel, 2, 15 );
        grid.add(firstNameTextField, 2, 15);
        grid.add(lastNameTextField, 3, 15);
        grid.add(emailTextField, 4, 15);
        grid.add(companyTextField, 5, 15);
        grid.add(jobTitleTextField, 6, 15);
        grid.add(universityTextField, 7, 15);

*/

        Scene scene = new Scene(grid, 750, 600);
        primaryStage.setScene(scene);
    }


    public static void main(String[] args) {

        db = new Database();
        CSVReader reader = new CSVReader();
        ArrayList<PersonRecord> records = reader.getAllDataFromCSVFile();
        //System.out.println(records.size());
        db.fillBinaryTreeWithAllRecords(records);
        System.out.println(db.getNumberOfRecordsInTree());

        //PersonRecord found = db.getPersonByLastName("Fumagallito");

        boolean found = db.containsPersonByLastName("Plank");

        if(found)
            System.out.println("Found the person");
        else
            System.out.println("did not find the person");

        PersonRecord p1 = db.getPersonByLastName("Plank");
        System.out.println(p1.getFirstName());

        PersonRecord p2 = db.getPersonByLastName("Golt");
        System.out.println(p2.getFirstName());

        PersonRecord p3 = db.getPersonByLastName("Irnis");
        System.out.println(p3.getFirstName());

        System.out.println("done");

        launch(args);
    }
}
