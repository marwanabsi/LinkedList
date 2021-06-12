import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.print.Collation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Drive extends Application {

	// LinkedList StudentData = new LinkedList();
	LinkedList StudentDataFile = new LinkedList();
	LinkedList StudentDataFile2 = new LinkedList();
	// LinkedList sortList = new LinkedList();

	public static void main(String[] args) throws FileNotFoundException {
		Application.launch(args);
		

	}

	private File studentFile;

	@Override
	public void start(Stage wind1) throws Exception {

		BorderPane ms = new BorderPane(); // Menu Secne
		BorderPane bp = new BorderPane(); // Add new Student
		BorderPane fs = new BorderPane(); // First Scence
		BorderPane ds = new BorderPane(); // Delete Student
		BorderPane ss = new BorderPane(); // Search Student
		BorderPane dms = new BorderPane(); // Display the mode
		BorderPane as = new BorderPane(); // abouve search and percentage
		
		Scene scene0 = new Scene(fs, 350, 450);
		Scene scene1 = new Scene(ms, 350, 450);
		Scene scene2 = new Scene(bp, 350, 450);
		Scene scene3 = new Scene(ds, 350, 450);
		Scene scene4 = new Scene(ss, 350, 450);
		Scene scene5 = new Scene(dms, 350, 450);
		Scene scene6 = new Scene(as, 350, 450);

		// scene0.setFill(Color.WHEAT);

		Label TopLabelws = new Label("Pleace Choouse An Option");
		TopLabelws.setFont(new Font(25));
		ms.setTop(TopLabelws);
		ms.setAlignment(TopLabelws, Pos.CENTER);

		Label TopLabelfs = new Label(
				"Welcome to Tawjihi records program " + "\n" + " Please choouse Student Location File");
		TopLabelfs.setFont(new Font(20));
		fs.setTop(TopLabelfs);
		fs.setAlignment(TopLabelfs, Pos.CENTER);

		Label TopLabel = new Label("Add new Twjehe Student record");
		TopLabel.setFont(new Font(20));
		bp.setTop(TopLabel);
		bp.setAlignment(TopLabel, Pos.CENTER);

		Label TopLabelds = new Label("Delete Student records");
		TopLabelds.setFont(new Font(20));
		ds.setTop(TopLabelds);
		ds.setAlignment(TopLabelds, Pos.CENTER);

		Label TopLabelss = new Label("Search Student records");
		TopLabelss.setFont(new Font(20));
		ss.setTop(TopLabelss);
		ss.setAlignment(TopLabelss, Pos.CENTER);

		// Desktop desktop = Desktop.getDesktop();

		FileChooser fileChooser;
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text File ", "*txt"),
				new ExtensionFilter("Exil File ", "*.csv"));

		Button browse = new Button("Browes");

		Button addNewButton = new Button("Add new Tawjihi record");
		Button deletButton = new Button("Delete a Tawjihi record");
		Button searchButton = new Button("    search for a specific   \n      Tawjihi record");
		Button topTenButton = new Button("  The top 10 students ");
		Button avergButton = new Button("        average       ");
		Button midelButton = new Button("Middle of the set of numbers");
		Button aboveButton = new Button("number and percentage of students");

		Button addButton = new Button("Add");
		Button printButton = new Button("Print List");
		Button menub= new Button("Back");
		
		Button deleteRecordButton = new Button("Delete");
		Button searchRecordButton = new Button("Search");
		Button searchabouv = new Button("Search");
		
		
		

		browse.setOnAction(e -> {
			studentFile = fileChooser.showOpenDialog(wind1);

			if (studentFile.exists()) {
				Scanner in;
				try {

					in = new Scanner(studentFile);
					String[] t;
					while (in.hasNext()) {
						t = in.nextLine().trim().split(",");
						if (t.length == 3) {
							Student student = new Student(Integer.parseInt(t[0].trim()), t[1],
									Double.parseDouble(t[2].trim()));
							if(t[1].trim().equals("Scientific")) {
								StudentDataFile.InsertionSorted(student);}
								else
									StudentDataFile2.InsertionSorted(student);

						}
					}
					wind1.setScene(scene1);

				} catch (FileNotFoundException e1) {
					System.out.println(e1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					StudentDataFile.print();
				}

			}

		});

//		HBox controlBox = new HBox();
//		controlBox.getChildren().addAll(addButton, printButton,menub);
//		controlBox.setSpacing(10);
//		controlBox.setAlignment(Pos.CENTER);
//		bp.setBottom(controlBox);
//		bp.setAlignment(controlBox, Pos.CENTER);

		VBox controlBox1 = new VBox();
		controlBox1.getChildren().addAll(addNewButton, deletButton, searchButton, topTenButton, avergButton,
				midelButton,aboveButton);
		controlBox1.setSpacing(10);
		controlBox1.setAlignment(Pos.CENTER);
		ms.setCenter(controlBox1);
		ms.setAlignment(controlBox1, Pos.CENTER);
		
		// Welcome grid
		GridPane gp2 = new GridPane();
		gp2.setVgap(15);
		gp2.setHgap(5);

		gp2.add(new Label("Choose Lucation "), 0, 0);
		gp2.add(browse, 1, 1);

		ComboBox<String> Lucation = new ComboBox<String>();
		Lucation.getItems().addAll("WestBank", "Gaza");
		gp2.add(Lucation, 1, 0);
		Lucation.getSelectionModel().select(1);
		fs.setCenter(gp2);
		gp2.setAlignment(Pos.CENTER);
		gp2.add(menub,2,5);
		
		
		// abouve grid
		GridPane gpas = new GridPane();
		gpas.setVgap(15);
		gpas.setHgap(5);

		gpas.add(new Label("Enter a grade "), 0, 0);
		TextField seatNumberas = new TextField();
		gpas.add(seatNumberas, 1, 0);
		gpas.add(searchabouv, 1, 1);
		as.setBottom(menub);
		as.setCenter(gpas);
		gpas.setAlignment(Pos.CENTER);
		gpas.add(menub,2,5);
		
		
		

		// Search grid
		GridPane gpss = new GridPane();
		gpss.setVgap(15);
		gpss.setHgap(5);

		gpss.add(new Label("Student Seat Number "), 0, 0);
		TextField seatNumberdss = new TextField();
		gpss.add(seatNumberdss, 1, 0);
		gpss.add(searchRecordButton, 1, 1);

		ss.setCenter(gpss);
		gpss.setAlignment(Pos.CENTER);
		ss.setBottom(menub);
		gpss.add(menub,2,5);



		// Delet grid
		GridPane gpds = new GridPane();
		gpds.setVgap(5);
		gpds.setHgap(5);

		gpds.add(new Label("Student Seat Number "), 0, 0);
		TextField seatNumberds = new TextField();
		gpds.add(seatNumberds, 1, 0);
		gpds.add(deleteRecordButton, 1, 1);
		gpds.add(menub,2,5);
		ds.setCenter(gpds);
		gpds.setAlignment(Pos.CENTER);
		
		

		// Add grid
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(5);

		// Label
		gp.add(new Label("Seat Number "), 0, 0); // label
		gp.add(new Label("AVG "), 0, 2);
		gp.add(new Label("Branchs "), 0, 1);

		// Text FIld
		TextField seatNumber = new TextField();
		TextField AVG = new TextField();
		gp.add(seatNumber, 1, 0);
		gp.add(AVG, 1, 2);
		gp.add(addButton,1,3);
		gp.add(printButton,2,3);

		gp.add(menub,2,5);

		// Combo Box
		ComboBox<String> Branchs = new ComboBox<String>();
		Branchs.getItems().addAll("Literary", "Scientific");
		gp.add(Branchs, 1, 1);
		Branchs.getSelectionModel().select(1);

		bp.setCenter(gp);
		gp.setAlignment(Pos.CENTER);

		// Defult Stage
		wind1.setScene(scene0);
		wind1.setTitle("Twjeheee");
		wind1.show();

		// Bottons Actions

		addButton.setOnAction(e -> {
			Student newStudent = new Student(Integer.parseInt(seatNumber.getText().trim()),
					Branchs.getSelectionModel().getSelectedItem(), Double.parseDouble(AVG.getText().trim()));
			if(Branchs.getSelectionModel().getSelectedItem().trim().equals("Scientific")) {
			StudentDataFile.InsertionSorted(newStudent);}
			else
				StudentDataFile2.InsertionSorted(newStudent);

		});

		printButton.setOnAction(e -> {
			if(Lucation.getSelectionModel().getSelectedItem().equals("Gaza")) {
				System.out.println("Student at Gaza");
			}
			if(Lucation.getSelectionModel().getSelectedItem().equals("WestBank")) {
				System.out.println("Student at WestBank");
			}
			
			StudentDataFile.print();
			System.out.println("Lib students");
			StudentDataFile2.print();

		});

		addNewButton.setOnAction(e -> {
			wind1.setScene(scene2);
		});

		deletButton.setOnAction(e -> {
			wind1.setScene(scene3);
			gpds.add(menub,2,5);


		});

		deleteRecordButton.setOnAction(e -> {
			Student nStudent = new Student(Integer.parseInt(seatNumberds.getText().trim()), "Defult", 00);
			StudentDataFile.delete(nStudent);
			StudentDataFile.print();
			StudentDataFile2.delete(nStudent);
			StudentDataFile2.print();

		});

		searchButton.setOnAction(e -> {
			ss.setBottom(menub);
			wind1.setScene(scene4);

		});
		
		
		
		searchRecordButton.setOnAction(e -> {
			
			Student nStudentss = new Student(Integer.parseInt(seatNumberdss.getText().trim()), "Defult", 00);
			StudentDataFile.search(nStudentss);
			StudentDataFile2.search(nStudentss);

		});

		topTenButton.setOnAction(e -> {
			if(Lucation.getSelectionModel().getSelectedItem().equals("Gaza")) {
				System.out.println("Student at Gaza");
			}
			if(Lucation.getSelectionModel().getSelectedItem().equals("WestBank")) {
				System.out.println("Student at WestBank");
			}
			System.out.println("Top 10 Scientific");
			StudentDataFile.sortListByAvg();
			StudentDataFile.printReverse(StudentDataFile.first);
			System.out.println("Top 10 Literary");
			StudentDataFile2.sortListByAvg();
			StudentDataFile2.printReverse(StudentDataFile2.first);
		});

		avergButton.setOnAction(e -> {
			if(Lucation.getSelectionModel().getSelectedItem().equals("Gaza")) {
				System.out.println("Student at Gaza");
			}
			if(Lucation.getSelectionModel().getSelectedItem().equals("WestBank")) {
				System.out.println("Student at WestBank");
			}
			StudentDataFile.avareg();
			StudentDataFile2.avareg();
		});

		midelButton.setOnAction(e -> {
			if(Lucation.getSelectionModel().getSelectedItem().equals("Gaza")) {
				System.out.println("Student at Gaza");
			}
			if(Lucation.getSelectionModel().getSelectedItem().equals("WestBank")) {
				System.out.println("Student at WestBank");
			}
			System.out.println("Scientific Students");
			StudentDataFile.midelSeatNumber(StudentDataFile.first);
			System.out.println("Literary Students");
			StudentDataFile2.midelSeatNumber(StudentDataFile2.first);
		});
		
		aboveButton.setOnAction(e ->{
			as.setBottom(menub);
			wind1.setScene(scene6);
		});
		
		searchabouv.setOnAction(e ->{
			if(Lucation.getSelectionModel().getSelectedItem().equals("Gaza")) {
				System.out.println("Student at Gaza");
			}
			if(Lucation.getSelectionModel().getSelectedItem().equals("WestBank")) {
				System.out.println("Student at WestBank");
			}
			
			Student nStudentas = new Student(0, "Defult",Double.parseDouble(seatNumberas.getText().trim()));
			System.out.println("Scientific Students");
			StudentDataFile.sortListByAvg();
			StudentDataFile.Size();
			StudentDataFile.searchabove(nStudentas);
			
			System.out.println("\n"+"Literary Students");
			StudentDataFile2.sortListByAvg();
			StudentDataFile2.Size();
			StudentDataFile2.searchabove(nStudentas);
		});
		menub.setOnAction(e ->{
			wind1.setScene(scene1);
		});
		
		
		
	}

}

// Marwan Issa  1170704