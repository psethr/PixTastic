import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class GUI
{
    private static Stage alertBoxStage, confirmBoxStage;
    private static Scene alertBoxScene, confirmBoxScene, createAccountScene, loginScene, profileScene;
    private static Button alertBoxButton, confirmBoxButtonYes, confirmBoxButtonNo,
            createAccountButton, createAccoutButtonGoBack, loginButton, loginButtonGoBack, profileButtonFollow,
            profileButtonMainFeed;
    private static Label alertBoxLabel, confirmBoxLabel, createAccountTitleLabel, createAccountInfo1Label, 
            createAccountInfo2Label, loginLabelTitle, loginLabelUsername, loginLabelName, profileLabelTitle,
            profileLabelInfo, profileLabelFeed, profileLabelAlreadyFollow;
    private static VBox alertBoxVBox, confirmBoxVBox, createAccountVBoxTop, createAccountVBoxBottom,
            createAccountVBoxCenter, loginVBoxLeft, loginVBoxRight, loginVBoxBottom, profileVBox, profileVBoxTop,
            profileVBoxFeed;
    private static HBox confirmBoxHBox, createAccountHBoxBottom, createAccountHBoxCenter, loginHBoxCenter,
            loginHBoxBottom, profileHBox, profileHBox2;
    private static TextField createAccountTextFieldUsername, createAccountTextFieldName, createAccountTextFieldLocation,
            createAccountTextFieldProfilePic, createAccountTextFieldBiography, loginTextFieldUsername, loginTextFieldName;
    private static BorderPane createAccountBorderPane, loginBorderPane;
    
    private static ScrollPane profileScrollPane, profileScrollPane2;
    
    private static boolean comfirmBoxAnswer;
    public static RegisteredUser userLoggedIn;
    
    public static Stage window;
    public static Scene startPage;
    public static Button closeButton, loginButtonMain, createAccount, guest;
    public static Label title1, title2, titleSlogan, author;
    public static HBox centerMenu, bottomMenu, topMenu1;
    public static VBox topMenu;
    public static BorderPane borderPane;
   
    
    public static void startProgram(Stage window)
    {
        GUI.window = window;
        window.setTitle("PixTastic");
        window.setOnCloseRequest(e -> {
            e.consume();
            exitProgram();
        });
        title1 = new Label("Pix");
        title1.setFont(Font.font("Arial Black", 80));
        title2 = new Label("Tastic");
        title2.setFont(Font.font("Arial Black", 80));
        title2.setTextFill(Color.DARKRED);
        titleSlogan = new Label("\"A pix is worth a thousand words\"");
        titleSlogan.setFont(Font.font("Brush Script MT", 45));
        author = new Label("Created By: Seth Perts, Rachel Mooney, Tiffany Lower");
        author.setTextFill(Color.BLUE);
        closeButton = new Button();
        closeButton.setText("Close Program");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
                {
                    exitProgram();
                }
        });
        loginButtonMain = new Button("Login");
        loginButtonMain.setFont(Font.font("Arial", 30));
        loginButtonMain.setOnAction(e -> {
            GUI.Login();
        });
        createAccount = new Button("Create an\nAccount");
        createAccount.setFont(Font.font("Arial", 30));
        createAccount.setTextAlignment(TextAlignment.CENTER);
        createAccount.setOnAction(e -> {
            GUI.CreateAccount();
        });
        guest = new Button("Guest");
        guest.setFont(Font.font("Arial", 30));
        
        topMenu1 = new HBox();
        topMenu1.setAlignment(Pos.CENTER_LEFT);
        topMenu1.getChildren().addAll(title1, title2);
        topMenu = new VBox();
        topMenu.setAlignment(Pos.CENTER_LEFT);
        topMenu.setPadding(new Insets(10));
        topMenu.getChildren().addAll(topMenu1, titleSlogan);
        centerMenu = new HBox();
        centerMenu.setAlignment(Pos.CENTER);
        centerMenu.setSpacing(50);
        centerMenu.getChildren().addAll(loginButtonMain, createAccount, guest);
        bottomMenu = new HBox();
        bottomMenu.setPadding(new Insets(10));
        bottomMenu.setAlignment(Pos.BOTTOM_RIGHT);
        bottomMenu.setSpacing(575);
        bottomMenu.getChildren().addAll(author, closeButton);
        borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setBottom(bottomMenu);
        
        startPage = new Scene(borderPane, 1000, 900);
        
        window.setScene(startPage);
        window.show();
    }
    
    public static void exitProgram()
    {
        Boolean answer = GUI.ConfirmBox("Exit Program", "Are you sure you want to exit the program?");
        if (answer == true)
        {
            GUI.window.close();
        }
    }
    
    public static void AlertBox(String title, String message)
    {
        alertBoxStage = new Stage();
        alertBoxStage.initModality(Modality.APPLICATION_MODAL);
        alertBoxStage.setTitle(title);
        alertBoxStage.setMinWidth(350);
        
        alertBoxLabel = new Label(message);
        
        alertBoxButton = new Button("OK");
        alertBoxButton.setOnAction(e -> alertBoxStage.close());
        
        alertBoxVBox = new VBox(10);
        alertBoxVBox.setAlignment(Pos.CENTER);
        alertBoxVBox.getChildren().addAll(alertBoxLabel, alertBoxButton);
        
        alertBoxScene = new Scene(alertBoxVBox);
        alertBoxStage.setScene(alertBoxScene);
        alertBoxStage.showAndWait();
    }
    
    public static boolean ConfirmBox(String title, String message)
    {
        confirmBoxStage = new Stage();
        confirmBoxStage.initModality(Modality.APPLICATION_MODAL);
        confirmBoxStage.setTitle(title);
        confirmBoxStage.setMinWidth(350);
        
        confirmBoxLabel = new Label(message);
        
        confirmBoxButtonYes = new Button("Yes");
        confirmBoxButtonYes.setMinWidth(50);
        confirmBoxButtonYes.setOnAction(e -> {
            comfirmBoxAnswer = true;
            confirmBoxStage.close();
        });
        confirmBoxButtonNo = new Button("No");
        confirmBoxButtonNo.setMinWidth(50);
        confirmBoxButtonNo.setOnAction(e -> {
            comfirmBoxAnswer = false;
            confirmBoxStage.close();
        });
        
        confirmBoxHBox = new HBox(25);
        confirmBoxHBox.setAlignment(Pos.CENTER);
        confirmBoxHBox.getChildren().addAll(confirmBoxButtonYes, confirmBoxButtonNo);
        
        confirmBoxVBox = new VBox(10);
        confirmBoxVBox.setAlignment(Pos.CENTER);
        confirmBoxVBox.getChildren().addAll(confirmBoxLabel, confirmBoxHBox);
        
        confirmBoxScene = new Scene(confirmBoxVBox);
        
        confirmBoxStage.setScene(confirmBoxScene);
        confirmBoxStage.showAndWait();
        
        return comfirmBoxAnswer;
    }
    
    public static void CreateAccount()
    {
        createAccountTitleLabel = new Label("Create Your Account");
        createAccountTitleLabel.setFont(Font.font("arial", 40));
        createAccountTitleLabel.setAlignment(Pos.CENTER_LEFT);
        createAccountInfo1Label = new Label("Please enter the following information:");
        createAccountInfo1Label.setFont(Font.font("arial", 20));
        createAccountInfo2Label = new Label("Login Username: \n\n\n"
                + "Your Name: \n\n\nLocation: \n\n\nPersonal Profile Picture File Pathway: \n\n\n"
                + "Biography: ");
        createAccountInfo2Label.setFont(Font.font("arial", 15));
        
        createAccoutButtonGoBack = new Button("Go Back");
        createAccoutButtonGoBack.setOnAction(e -> {
            startProgram(window);
        });
        createAccountButton = new Button("Create Account");
        createAccountButton.setOnAction(e -> {
            RegisteredUser user = new RegisteredUser(createAccountTextFieldUsername.getText(),
                                                    createAccountTextFieldName.getText(),
                                                    createAccountTextFieldLocation.getText(),
                                                    createAccountTextFieldProfilePic.getText(),
                                                    createAccountTextFieldBiography.getText(),
                                                    true);
            PixTastic.registeredUserAL.add(user);
            Profile(PixTastic.registeredUserAL.get(0));
        });
        createAccountTextFieldUsername = new TextField();
        createAccountTextFieldUsername.setMinWidth(350);
        createAccountTextFieldUsername.setPromptText("What others will see you as");
        createAccountTextFieldName = new TextField();
        createAccountTextFieldName.setPromptText("Your actual name");
        createAccountTextFieldLocation = new TextField();
        createAccountTextFieldLocation.setPromptText("e.g. Virginia");
        createAccountTextFieldProfilePic = new TextField();
        createAccountTextFieldProfilePic.setPromptText("e.g. C:\\\\Windows\\Folder");
        createAccountTextFieldBiography = new TextField();
        createAccountTextFieldBiography.setPromptText("Enter multiple sentences about yourself");
        
        createAccountVBoxCenter = new VBox(25);
        createAccountVBoxCenter.setAlignment(Pos.CENTER);
        createAccountVBoxCenter.getChildren().addAll(createAccountTextFieldUsername, createAccountTextFieldName,
                createAccountTextFieldLocation, createAccountTextFieldProfilePic, createAccountTextFieldBiography);
        
        createAccountHBoxBottom = new HBox(400);
        createAccountHBoxBottom.setAlignment(Pos.CENTER);
        createAccountHBoxBottom.getChildren().addAll(createAccoutButtonGoBack, createAccountButton);
        createAccountHBoxCenter = new HBox(250);
        createAccountHBoxCenter.setAlignment(Pos.CENTER);
        createAccountHBoxCenter.getChildren().addAll(createAccountInfo2Label, createAccountVBoxCenter);
        
        createAccountVBoxTop = new VBox(150);
        createAccountVBoxTop.setPadding(new Insets(10));
        createAccountVBoxTop.setAlignment(Pos.CENTER_LEFT);
        createAccountVBoxTop.getChildren().addAll(createAccountTitleLabel, createAccountInfo1Label);
        createAccountVBoxBottom = new VBox(50);
        createAccountVBoxBottom.getChildren().addAll(createAccountHBoxBottom, GUI.bottomMenu);
        
        
        createAccountBorderPane = new BorderPane();
        createAccountBorderPane.setTop(createAccountVBoxTop);
        createAccountBorderPane.setCenter(createAccountHBoxCenter);
        createAccountBorderPane.setBottom(createAccountVBoxBottom);
        
        createAccountScene = new Scene(createAccountBorderPane, 1000, 900);
        
        GUI.window.setScene(createAccountScene);
        GUI.window.show();
    }
    
    public static void Login()
    {
        loginLabelTitle = new Label("Enter Login Information");
        loginLabelTitle.setAlignment(Pos.CENTER_LEFT);
        loginLabelTitle.setFont(Font.font("arial", 40));
        loginLabelTitle.setPadding(new Insets(10));
        loginLabelUsername = new Label("Username");
        loginLabelUsername.setFont(Font.font("arial", 20));
        loginLabelName = new Label("Name");
        loginLabelName.setFont(Font.font("arial", 20));
        
        loginButton = new Button("Login");
        loginButtonGoBack = new Button("Go Back");
        loginButtonGoBack.setOnAction(e -> {
            startProgram(window);
        });
        
        loginTextFieldUsername = new TextField();
        loginTextFieldUsername.setPromptText("e.g. seth77");
        loginTextFieldName = new TextField();
        loginTextFieldName.setPromptText("e.g. Seth Perts");
        
        loginVBoxLeft = new VBox(40);
        loginVBoxLeft.setAlignment(Pos.CENTER_LEFT);
        loginVBoxLeft.getChildren().addAll(loginLabelName, loginLabelUsername);
        loginVBoxRight = new VBox(40);
        loginVBoxRight.setAlignment(Pos.CENTER_LEFT);
        loginVBoxRight.getChildren().addAll(loginTextFieldName, loginTextFieldUsername);
        
        loginHBoxCenter = new HBox(100);
        loginHBoxCenter.setAlignment(Pos.CENTER);
        loginHBoxCenter.getChildren().addAll(loginVBoxLeft, loginVBoxRight);
        loginHBoxBottom = new HBox(400);
        loginHBoxBottom.setAlignment(Pos.CENTER);
        loginHBoxBottom.getChildren().addAll(loginButtonGoBack, loginButton);
        
        loginVBoxBottom = new VBox(50);
        loginVBoxBottom.getChildren().addAll(loginHBoxBottom, GUI.bottomMenu);
        
        loginBorderPane = new BorderPane();
        loginBorderPane.setTop(loginLabelTitle);
        loginBorderPane.setCenter(loginHBoxCenter);
        loginBorderPane.setBottom(loginVBoxBottom);
        
        loginScene = new Scene(loginBorderPane, 1000, 900);
        
        GUI.window.setScene(loginScene);
        GUI.window.show();
    }
    
    public static void Profile(RegisteredUser user)
    {
        profileLabelTitle = new Label(user.getUsername()+"'s Profile");
        profileLabelTitle.setFont(Font.font("arial", 40));
        System.out.println(user.getBio());
        profileLabelInfo = new Label("Name:\t\t\t\t\t"+user.getName()+"\n\nUsername:\t\t\t\t"+user.getUsername()+
                "\n\nLocation:\t\t\t\t\t"+user.getLocation()+"\n\nBiography:\t\t\t\t"+user.getBio());
        profileLabelInfo.setFont(Font.font("arial", 30));
        profileLabelFeed = new Label("Personal Feed");
        profileLabelFeed.setFont(Font.font("arial", 30));
        profileLabelAlreadyFollow = new Label("You Are Following this User!");
        profileLabelAlreadyFollow.setFont(Font.font("arial", 25));
        profileLabelAlreadyFollow.setVisible(false);
        
        profileButtonFollow = new Button("Follow This Person?");
        profileButtonMainFeed = new Button("Go to Main Feed");
        if (userLoggedIn.getAlFollowing().contains(user))
        {
            profileLabelAlreadyFollow.setVisible(true);
            profileButtonFollow.setVisible(false);
        }
        
        if (userLoggedIn.equals(user))
        {
            profileButtonFollow.setVisible(false);
        }
        
        profileButtonFollow.setOnAction(e -> {
            Follow(user);
            GUI.AlertBox("Success!", "You are now following this user!");
            Profile(user);
            System.out.println(userLoggedIn.toString("follower"));
        });
        
        File pic = new File(user.getProfilePic());
        ImageView image = new ImageView(pic.toURI().toString());
        image.setFitHeight(200);
        image.setFitWidth(200);
        
        profileScrollPane2 = new ScrollPane();
        profileScrollPane2.setContent(profileLabelInfo);
        profileScrollPane = new ScrollPane();
        profileScrollPane.setMaxHeight(400);
        profileVBoxFeed = new VBox(10);
        profileVBoxFeed.setAlignment(Pos.CENTER_RIGHT);
        profileVBoxFeed.setPadding(new Insets(10));
        int ct = 0;
        for (Picture ele : user.getArraylist())
        {
            int len = user.getArraylist().size();
            File f = new File(ele.getFPath());
            ImageView photo = new ImageView(f.toURI().toString());
            photo.setFitHeight(400);
            photo.setFitWidth(400);
            photo.setOnMouseClicked(e -> PicturePost(user, ele));
            profileVBoxFeed.getChildren().add(photo);
            ct++;
        }
        profileScrollPane.setContent(profileVBoxFeed);
        System.out.println(profileVBoxFeed.toString());
        
        profileHBox2 = new HBox(25);
        profileHBox2.setAlignment(Pos.CENTER_RIGHT);
        profileHBox2.getChildren().addAll(profileButtonMainFeed, profileLabelAlreadyFollow, profileButtonFollow);
        
        profileVBoxTop = new VBox(50);
        profileVBoxTop.setAlignment(Pos.CENTER_LEFT);
        profileVBoxTop.getChildren().addAll(profileLabelTitle, profileScrollPane2, profileHBox2, profileLabelFeed);
        
        profileHBox = new HBox(10);
        profileHBox.setAlignment(Pos.TOP_LEFT);
        profileHBox.getChildren().addAll(profileVBoxTop, image);
        
//        profileHBox2 = new HBox(100);
//        profileHBox2.setAlignment(Pos.CENTER_RIGHT);
//        profileHBox2.getChildren().addAll(profileLabelAlreadyFollow, profileButtonFollow);
        
        profileVBox = new VBox(10);
        profileVBox.setPadding(new Insets(10));
        profileVBox.getChildren().addAll(profileHBox, profileScrollPane, bottomMenu);
        
        profileScene = new Scene(profileVBox, 1000, 900);
        GUI.window.setScene(profileScene);
    }
    
    public static void PicturePost(RegisteredUser user, Picture pic)
    {
        
    }
    
    public static void Follow(RegisteredUser user)
    {
        GUI.userLoggedIn.addFollower(user);
    }
}