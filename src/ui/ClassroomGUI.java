package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.Browser;
import model.Career;
import model.Classroom;
import model.Gender;
import model.UserAccount;

public class ClassroomGUI {
	
	private Classroom classroom;
	
	public ClassroomGUI(Classroom classroom1) {
	   	classroom = classroom1;
	}
	
	 @FXML
	   private BorderPane mainPane;
	
	 @FXML
	   private TextField txName;

	 @FXML
	    private Button btnSign;

	 @FXML
	    private Button btnLog;

	 @FXML
	    private PasswordField txPassword;
	 
	  @FXML
	    private TextField txtNameLog;

	  @FXML
	    private TextField txtPhoto;

	  @FXML
	    private Button btnBrowse;

	  @FXML
	    private RadioButton male;

	  @FXML
	    private ToggleGroup genderGp;

	  @FXML
	    private RadioButton female;

	  @FXML
	    private RadioButton other;
	
	  @FXML
	    private CheckBox softEng;

	  @FXML
	    private CheckBox TelEng;

	  @FXML
	    private CheckBox IndEng;

	  @FXML
	    private DatePicker txtBirth;

	  @FXML
	    private ComboBox<String> browsers;

	  @FXML
	    private PasswordField txtPassLog;
	  
	  @FXML
	    private TableView<UserAccount> tvUsersAcc;
	  
	  @FXML
	    private TableColumn<UserAccount, String> colUser;

	  @FXML
	    private TableColumn<UserAccount, Gender> colGen;

	  @FXML
	    private TableColumn<UserAccount, Career> colCar;

	  @FXML
	    private TableColumn<UserAccount, String> colBir;

	  @FXML
	    private TableColumn<UserAccount, Browser> colBro;

	  @FXML
	    private Label labelUser;

	  @FXML
	    private ImageView imageUser;

	  @FXML
	    private Button btnLogOut;
	  
	  @FXML
	  public void initialize() {
	  }
	  
	  @FXML
	  public void loadLogin() throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		  
		  loader.setController(this);
		  Parent addUser = loader.load();
	    	
		  mainPane.getChildren().clear();
		  mainPane.setTop(addUser);
		  
	  } 
	  
	  @FXML
	  public void addUsers(ActionEvent event)throws IOException {
		  Parent loader = FXMLLoader.load(getClass().getResource("account-List.fxml"));
		  mainPane.getChildren().clear();
		  mainPane.setTop(loader);
		  //initializeTableView();
	  }
	  
	  public void initializeTableView() {
		  ObservableList<UserAccount> observableList;
		  observableList = FXCollections.observableArrayList(classroom.getUsers());	
		  
		  tvUsersAcc.setItems(observableList);
		  colUser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("user"));
		  colGen.setCellValueFactory(new PropertyValueFactory<UserAccount, Gender>("gender"));
		  colCar.setCellValueFactory(new PropertyValueFactory<UserAccount, Career>("career"));
		  colBir.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));
		  colBro.setCellValueFactory(new PropertyValueFactory<UserAccount, Browser>("career"));
	  }
	  

	 
}
