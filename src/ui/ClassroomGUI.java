package ui;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Browser;
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
	    private PasswordField txPassword;
	 
	  @FXML
	    private TextField txtNameLog;

	  @FXML
	    private TextField txtPhoto;

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
	    private TableColumn<UserAccount, String> colCar;

	  @FXML
	    private TableColumn<UserAccount, String> colBir;

	  @FXML
	    private TableColumn<UserAccount, Browser> colBro;

	   @FXML
	    private ImageView image;

	  @FXML
	   private Label labMessUs;
	  
	   @FXML
	    private Label userLog;
	  
	  @FXML
	  public void loadLogin() throws IOException {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		  
		  loader.setController(this);
		  Parent addUser = loader.load();
	    	
		  mainPane.getChildren().clear();
		  mainPane.setTop(addUser);
		  
	  } 
	  
	  @FXML
	  public void loginUsers(ActionEvent event)throws IOException {
		 
		  if(!txName.getText().equals("") && !txPassword.getText().equals("")) {
				  
			  if(!classroom.searchUser(txName.getText(), txPassword.getText())){
				  
				  FXMLLoader loader = new FXMLLoader(getClass().getResource("account-List.fxml"));
					  
				  loader.setController(this);
				  Parent loginUser = loader.load();
					  
				  mainPane.getChildren().clear();
				  mainPane.setTop(loginUser);
				  userLog.setText(txName.getText());
				  Image imageView = new Image(classroom.searchImage(txName.getText(), txPassword.getText()));
				  image.setImage(imageView);
				  
				  initializeTableView();
				  
			  }else
				  showAlert();
		  }else
			  showAlert();
	  }
	  
	  public void initializeTableView() {
		  ObservableList<UserAccount> observableList;
		  observableList = FXCollections.observableArrayList(classroom.getAccounts());	
		  
		  tvUsersAcc.setItems(observableList);
		  colUser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("name"));
		  colGen.setCellValueFactory(new PropertyValueFactory<UserAccount, Gender>("gender"));
		  colCar.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));
		  colBir.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));
		  colBro.setCellValueFactory(new PropertyValueFactory<UserAccount, Browser>("browser"));
	  }
	  
	  @FXML
	  public void singUpUsers(ActionEvent event)throws IOException{
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
		  
		  loader.setController(this);
		  Parent singUpUser = loader.load();
		  
		  mainPane.getChildren().clear();
		  mainPane.setTop(singUpUser);
		  
		  browsers.setPromptText("Select your favorite browser");
		  browsers.getItems().addAll("Google","Opera","Opera GX","Mozilla","Microsoft Edge");
	  }
	  
	  @FXML
	  public void logout(ActionEvent event)throws IOException{
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		  
		  loader.setController(this);
		  Parent logoutUs = loader.load(); 
		  
		  mainPane.getChildren().clear();
		  mainPane.setTop(logoutUs);;
	  }
	  
	  @FXML
	  public void outRegister(ActionEvent event)throws IOException{
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		  
		  loader.setController(this);
		  Parent logoutOfRe = loader.load(); 
		  
		  mainPane.getChildren().clear();
		  mainPane.setTop(logoutOfRe);;
	  }
	  
	  @FXML
	  public void showAlert() {
		  
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("ERROR");
		  alert.setHeaderText("Invalid User or Password");
		  alert.setContentText("Your Username or Password is incorrect, please try again ");
			  
		  alert.showAndWait();  
	    }
	  
	  @FXML
	  public void chooseImage(ActionEvent event)throws IOException {
		  FileChooser fileChooser = new FileChooser();
		  fileChooser.setTitle("Open Resource File");
		  File file = fileChooser.showOpenDialog(null);
		  txtPhoto.appendText(file.getAbsolutePath());
       }
	  
	  @FXML
	  public void createUser(ActionEvent event) throws IOException{
		  
		  if(!txtNameLog.getText().equals("") && !txtPassLog.getText().equals("") && !txtPhoto.getText().equals("") && (male.isSelected() || female.isSelected() 
				  || other.isSelected()) && (softEng.isSelected() || TelEng.isSelected() || IndEng.isSelected()) && txtBirth.getValue() != null && browsers.getValue() != null) { 
			 
				labMessUs.setText("User has been created succesfully");
				
				File images = new File(txtPhoto.getText());
				String link = images.toURI().toString();
				
				classroom.addUsers(txtNameLog.getText(), txtPassLog.getText(), link, txtBirth.getValue().toString(), genders(), careers(), browser());
		  }
		  else {
			  
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("ERROR");
			 alert.setHeaderText("You must fill all the fields");
			 alert.setContentText(null);
			 alert.showAndWait();
		 }
	  }
	  
	  public Gender genders() {
		  Gender gender = null;
		  
		  if(male.isSelected()) {
			  gender = Gender.MALE;
		  }
		  
		  else if(female.isSelected()) {
			  gender = Gender.FEMALE;
		  }
		  
		  else if(other.isSelected()) {
			  gender = Gender.OTHER;
		  }
		  
		  return gender;
	  }
	  
	  public String careers() {
		  String career = "";
		  
		  if(softEng.isSelected()) {
			  career = "Software Engeenering ";
		  }
		  
		  if(TelEng.isSelected()) {
			  career += "Telematic Engeenering ";
		  }
		  
		  if(IndEng.isSelected()) {
			  career += "Industrial Engeenering";
		  }
		  return career;
	  }
	  
	  public Browser browser() {
		  Browser browserSelect = null;
		  
		  if(browsers.getValue().equals("Google")) {
			  browserSelect = Browser.GOOGLE;
		  }
		  else if(browsers.getValue().equals("Opera")) {
			  browserSelect = Browser.OPERA;
		  }
		  else if(browsers.getValue().equals("Opera GX")) {
			  browserSelect = Browser.OPERA_GX;
		  }
		  else if(browsers.getValue().equals("Mozilla")) {
			  browserSelect = Browser.MOZILLA;
		  }
		  else if(browsers.getValue().equals("Microsoft Edge")) {
			  browserSelect = Browser.MICROSOFT_EDGE;
		  }
		  
		  return browserSelect;
	  }
	  
	 
}
