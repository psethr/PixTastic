import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;


public class GUI
{
    
    private static Stage alertBoxStage, confirmBoxStage, entryBoxStage, createPictureStage;
    private static Scene alertBoxScene, confirmBoxScene, entryBoxScene, createAccountScene, loginScene, profileScene, pictureScene,
            createPictureScene, mainFeedScene;
    private static Button alertBoxButton, confirmBoxButtonYes, confirmBoxButtonNo, entryBoxButton,
            createAccountButton, createAccoutButtonGoBack, loginButton, loginButtonGoBack, profileButtonFollow,
            profileButtonMainFeed, profileButtonCreatePicture, pictureButtonLike, pictureButtonComment, createPictureButton, createPictureButtonGoBack,
            mainFeedButtonSearch, mainFeedButtonSortTime, mainFeedButtonSortLikes, mainFeedButtonSortLocation;
    private static Label alertBoxLabel, confirmBoxLabel, entryBoxLabel, createAccountTitleLabel, createAccountInfo1Label, 
            createAccountInfo2Label, loginLabelTitle, loginLabelUsername, loginLabelName, profileLabelTitle,
            profileLabelInfo, profileLabelFeed, profileLabelAlreadyFollow, pictureLabelInfo, pictureLabelInfo2, 
            pictureLabelAlreadyLiked, pictureLabelComments, pictureLabelComments2, pictureLabelCaption, pictureLabelInfo3,
            createPictureLabelTitle, createPictureLabelInfo, createPictureLabelInfo1, mainFeedLabelTitle, mainFeedLabelSort, mainFeedLabelSearch, mainFeedLabelImage;
    private static VBox alertBoxVBox, confirmBoxVBox, entryBoxVBox, createAccountVBoxTop, createAccountVBoxBottom,
            createAccountVBoxCenter, loginVBoxLeft, loginVBoxRight, loginVBoxBottom, profileVBox, profileVBoxTop,
            profileVBoxFeed, pictureVBoxPicCap, pictureVBoxInfoLike, pictureVBox, createPictureVBox, createPictureVBoxTextField,
            mainFeedVBoxImages, mainFeedVBox;
    private static HBox confirmBoxHBox, createAccountHBoxBottom, createAccountHBoxCenter, loginHBoxCenter,
            loginHBoxBottom, profileHBox, profileHBox2, pictureHBoxTop, pictureHBoxUser, pictureHBoxLike, pictureHBoxComment,
            createPictureHBoxInfo, createPictureHBoxButton, mainFeedHBoxTitle, mainFeedHBoxSearch, mainFeedHBoxImage;
    private static TextField entryBoxTextField, createAccountTextFieldUsername, createAccountTextFieldName, createAccountTextFieldLocation,
            createAccountTextFieldProfilePic, createAccountTextFieldBiography, loginTextFieldUsername, loginTextFieldName, createPictureTextFieldFile,
            createPictureTextFieldCaption, createTextFieldHashtag, mainFeedTextFieldSearch;
    private static BorderPane createAccountBorderPane, loginBorderPane;
    private static ScrollPane profileScrollPane, profileScrollPane2, pictureScrollPaneComments, mainFeedScrollPaneImages;
    
    private static boolean comfirmBoxAnswer;
    private static String entryBoxAnswer;
    private static int ct = 0;
    private static boolean other = false;
    public static RegisteredUser userLoggedIn;
    private static boolean time, likes, location = false;
    
    public static Stage window;
    public static Scene startPage;
    public static Button closeButton, loginButtonMain, createAccount, guest;
    public static Label title1, title2, titleSlogan, author;
    public static HBox centerMenu, bottomMenu, topMenu1;
    public static VBox topMenu;
    public static BorderPane borderPane;
    public static ArrayList<Picture> tempAL = new ArrayList<>();
    //public static ArrayList<Picture> arraylistComp = new ArrayList<Picture>();
    
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
        guest.setOnAction(e -> {
            GUI.userLoggedIn = null;
            MainFeed();
        });
        
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
            
            String outfileusers = "C:\\Users\\Seth\\Desktop\\CPSC 240\\User.bin";
            try 
            {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(outfileusers));
                os.writeObject(PixTastic.registeredUserAL);
            }
            catch (EOFException ex) {
               Logger.getLogger(PixTastic.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch (FileNotFoundException ex) {
               Logger.getLogger(PixTastic.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(PixTastic.class.getName()).log(Level.SEVERE, null, ex);
           }
            /*String outfileusers = "C:\\Users\\Seth\\Desktop\\CPSC 240\\User.txt";
             try
             {
                FileWriter outfile = new FileWriter(outfileusers);
                BufferedWriter out = new BufferedWriter(outfile);
               
                for(RegisteredUser u: PixTastic.registeredUserAL)
                { 
                 out.write(u.toCloseString());
                 out.newLine();
                
                }                 
                out.close();
             }
             catch (FileNotFoundException e)
             {
                System.err.println("Error: " + e.getMessage());
             }  
             
             String outfilepictures = "C:\\Users\\Rachel\\Documents\\PixTastic\\Pictures.txt";
             try
             {
                FileWriter outfile = new FileWriter(outfilepictures);
                BufferedWriter out = new BufferedWriter(outfile);
               
                for(Picture p: RegisteredUser.al)
                { 
                 out.write(p.toClosePixString());
                 out.newLine();
                
                }                 
                out.close();
             }
             catch (FileNotFoundException e)
             {
                System.err.println("Error: " + e.getMessage());
             } */ 
            GUI.userLoggedIn = null;
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
    
    public static String EntryBox(String title, String message, String button)
    {
        entryBoxStage = new Stage();
        entryBoxStage.initModality(Modality.APPLICATION_MODAL);
        entryBoxStage.setTitle(title);
        entryBoxStage.setMinWidth(350);
        
        entryBoxLabel = new Label(message);
        
        entryBoxTextField = new TextField();
        entryBoxTextField.setAlignment(Pos.BASELINE_RIGHT);
        entryBoxTextField.setPromptText("Enter comment here");
        
        entryBoxButton = new Button(button);
        entryBoxButton.setOnAction(e -> {
            entryBoxAnswer = entryBoxTextField.getText();
            entryBoxStage.close();
        });
        
        entryBoxVBox = new VBox(20);
        entryBoxVBox.setPadding(new Insets(10));
        entryBoxVBox.setAlignment(Pos.CENTER);
        entryBoxVBox.getChildren().addAll(entryBoxLabel, entryBoxTextField, entryBoxButton);
        
        entryBoxScene = new Scene(entryBoxVBox);
        entryBoxStage.setScene(entryBoxScene);
        entryBoxStage.showAndWait();
        
        return entryBoxAnswer;
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
            GUI.userLoggedIn = user;
            Profile(user);
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
        
        loginButton.setOnAction(e -> {
            int ct = 0;
            for (RegisteredUser ele : PixTastic.registeredUserAL)
            {
                if (ele.getUsername().equals(loginTextFieldUsername.getText()) && ele.getName().equalsIgnoreCase(loginTextFieldName.getText()))
                {
                    ct++;
                    GUI.userLoggedIn = ele;
                    Profile(ele);
                }
            }
            if (ct == 0)
            {
                GUI.AlertBox("Error: Incorrect Info", "The name/username entered isn't valid! Please try again.");
                GUI.Login();
            }
        });
        
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
        profileLabelInfo = new Label("Name:\t\t\t\t\t"+user.getName()+"\n\nUsername:\t\t\t\t"+user.getUsername()+
                "\n\nLocation:\t\t\t\t\t"+user.getLocation()+"\n\nFollowing:\t\t\t\t"+user.toString("follower")+
                "\n\nBiography:\t\t\t\t"+user.getBio());
        profileLabelInfo.setFont(Font.font("arial", 30));
        profileLabelFeed = new Label("Personal Feed");
        profileLabelFeed.setFont(Font.font("arial", 30));
        profileLabelAlreadyFollow = new Label("You Are Following this User!");
        profileLabelAlreadyFollow.setFont(Font.font("arial", 25));
        profileLabelAlreadyFollow.setVisible(false);
        
        profileButtonFollow = new Button("Follow This Person?");
        profileButtonMainFeed = new Button("Go to Main Feed");
        profileButtonMainFeed.setOnAction(e -> {
            MainFeed();
        });
        profileButtonCreatePicture = new Button("Create a New Post");
     
        System.out.println(userLoggedIn.getAlFollowing().contains(user));
            
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
        });
        
        profileButtonCreatePicture.setOnAction(e -> {
            CreatePicture();
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
        for (Picture ele : user.getArraylist())
        {
            File f = new File(ele.getFPath());
            ImageView photo = new ImageView(f.toURI().toString());
            photo.setFitHeight(400);
            photo.setFitWidth(400);
            photo.setOnMouseClicked(e -> PicturePost(ele));
            profileVBoxFeed.getChildren().add(photo);
        }
        profileScrollPane.setContent(profileVBoxFeed);
        
        profileHBox2 = new HBox(25);
        profileHBox2.setAlignment(Pos.CENTER_RIGHT);
        profileHBox2.getChildren().addAll(profileButtonCreatePicture, profileButtonMainFeed, profileLabelAlreadyFollow, profileButtonFollow);
        
        profileVBoxTop = new VBox(50);
        profileVBoxTop.setAlignment(Pos.CENTER_LEFT);
        profileVBoxTop.getChildren().addAll(profileLabelTitle, profileScrollPane2, profileHBox2, profileLabelFeed);
        
        profileHBox = new HBox(10);
        profileHBox.setAlignment(Pos.TOP_LEFT);
        profileHBox.getChildren().addAll(profileVBoxTop, image);
        
        bottomMenu.setAlignment(Pos.BOTTOM_CENTER);
        
        profileVBox = new VBox(10);
        profileVBox.setPadding(new Insets(10));
        profileVBox.getChildren().addAll(profileHBox, profileScrollPane, bottomMenu);
        
        profileScene = new Scene(profileVBox, 1000, 900);
        GUI.window.setScene(profileScene);
    }
    
    public static void PicturePost(Picture pic)
    {
        File f = new File(pic.getFPath());
        ImageView image = new ImageView(f.toURI().toString());
        image.setFitHeight(450);
        image.setFitWidth(450);
        
        pictureLabelCaption = new Label("\""+pic.getCaption()+"\"");
        pictureLabelCaption.setFont(Font.font("arial", FontPosture.ITALIC, 30));
        pictureLabelInfo = new Label("Posted By:\t\t\t");
        pictureLabelInfo.setFont(Font.font("arial", 20));
        pictureLabelInfo3 = new Label(pic.getOwner().getUsername());
        pictureLabelInfo3.setFont(Font.font("arial", 20));
        pictureLabelInfo3.setOnMouseClicked(e -> {
            Profile(pic.getOwner());
        });
        pictureLabelInfo2 = new Label(
        "Posted On:\t\t\t"+(pic.getTime().format(DateTimeFormatter.ofPattern("MM-dd-yyyy  @  hh:mm:ss")))+
                "\n\nLikes:\t\t\t\t"+pic.getLikes()+"\n\nHashTag:\t\t\t\t"+pic.getHashtag());
        
        pictureLabelInfo2.setFont(Font.font("arial", 20));
        pictureLabelAlreadyLiked = new Label("You Have Already Liked this Picture!");
        pictureLabelAlreadyLiked.setVisible(false);
        pictureLabelComments = new Label("Comments");
        pictureLabelComments.setFont(Font.font("arial", 30));
        pictureLabelComments2 = new Label(pic.getComments());
        pictureLabelComments2.setFont(Font.font("arial", 20));
        
        pictureScrollPaneComments = new ScrollPane();
        pictureScrollPaneComments.setContent(pictureLabelComments2);
        pictureScrollPaneComments.setMaxHeight(500);
        
        pictureButtonLike = new Button("Add a Like");
        pictureButtonLike.setOnAction(e -> {
            pic.addLikes(GUI.userLoggedIn);
            GUI.AlertBox("Success!", "You have liked this picture!");
            PicturePost(pic);
        });
        if (pic.getLikedBy().contains(GUI.userLoggedIn.getUsername()))
        {
            pictureButtonLike.setVisible(false);
            pictureLabelAlreadyLiked.setVisible(true);
        }
        pictureButtonComment = new Button("Add a Comment");
        pictureButtonComment.setOnAction(e -> {
            String ans = GUI.EntryBox("Comment", "Enter a comment to post to this picture.", "Post Comment");
            ans = GUI.userLoggedIn.getUsername()+" ("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy @ hh:mm:ss"))+" )  --  "+ans;
            pic.addComments(ans);
            PicturePost(pic);
        });
        profileButtonMainFeed.setOnAction(e -> {
            MainFeed();
        });
        pictureHBoxLike = new HBox(15);
        pictureHBoxLike.getChildren().addAll(profileButtonMainFeed, pictureButtonLike, pictureLabelAlreadyLiked);
        pictureHBoxUser = new HBox(0);
        pictureHBoxUser.getChildren().addAll(pictureLabelInfo, pictureLabelInfo3);
        pictureHBoxComment = new HBox(700);
        pictureHBoxComment.getChildren().addAll(pictureLabelComments, pictureButtonComment);
        
        pictureVBoxInfoLike = new VBox(50);
        pictureVBoxInfoLike.getChildren().addAll(pictureHBoxUser, pictureLabelInfo2, pictureHBoxLike);
        pictureVBoxPicCap = new VBox(10);
        pictureVBoxPicCap.getChildren().addAll(image, pictureLabelCaption);
        
        pictureHBoxTop = new HBox(50);
        pictureHBoxTop.getChildren().addAll(pictureVBoxPicCap, pictureVBoxInfoLike);
        
        pictureVBox = new VBox(30);
        pictureVBox.setPadding(new Insets(10));
        pictureVBox.getChildren().addAll(pictureHBoxTop, pictureHBoxComment, pictureScrollPaneComments);
        
        pictureScene = new Scene(pictureVBox, 1000, 900);
        GUI.window.setScene(pictureScene);
    }
    
    public static void Follow(RegisteredUser user)
    {
        GUI.userLoggedIn.addFollower(user);
    }
    
    public static void CreatePicture()
    {
        createPictureStage = new Stage();
        createPictureStage.setTitle("Create a Picture Post");
        createPictureStage.initModality(Modality.APPLICATION_MODAL);
        
        createPictureLabelTitle = new Label("Create a Picture Post");
        createPictureLabelTitle.setFont(Font.font("arial", 40));
        createPictureLabelTitle.setAlignment(Pos.CENTER_LEFT);
        createPictureLabelInfo = new Label("Enter the following information:");
        createPictureLabelInfo.setFont(Font.font("arial", 25));
        createPictureLabelInfo.setAlignment(Pos.CENTER_LEFT);
        createPictureLabelInfo1 = new Label(
        "File Pathway:\n\nCaption:\n\nHashTag:\n\n");
        createPictureLabelInfo1.setFont(Font.font("arial", 20));
        createPictureLabelInfo1.setAlignment(Pos.CENTER);
        
        createPictureTextFieldFile = new TextField();
        createPictureTextFieldFile.setPromptText("e.g. C:\\\\Windows\\Folder");
        createPictureTextFieldFile.setMinWidth(350);
        createPictureTextFieldCaption = new TextField();
        createPictureTextFieldCaption.setPromptText("Enter a brief description");
        createTextFieldHashtag = new TextField();
        createTextFieldHashtag.setPromptText("Enter a searchable hashtag e.g #food");
        
        createPictureButton = new Button("Create Picture Post");
        createPictureButton.setOnAction(e -> {
            System.out.println("test1");
            Picture pic = new Picture(GUI.userLoggedIn,
                                      LocalDateTime.now(),
                                      createPictureTextFieldFile.getText(),
                                      createPictureTextFieldCaption.getText(),
                                      "",
                                      createTextFieldHashtag.getText(),
                                      0);
            System.out.println("test2");
            GUI.userLoggedIn.addPicture(pic);
            System.out.println("Test3");
            Profile(GUI.userLoggedIn);
            System.out.println("test4");
            createPictureStage.close();
        });
        createPictureButtonGoBack = new Button("Go Back");
        createPictureButtonGoBack.setOnAction(e -> {
            Profile(GUI.userLoggedIn);
            createPictureStage.close();
        });
        
        createPictureVBoxTextField = new VBox(20);
        createPictureVBoxTextField.setAlignment(Pos.CENTER);
        createPictureVBoxTextField.getChildren().addAll(createPictureTextFieldFile, createPictureTextFieldCaption, createTextFieldHashtag);
        
        createPictureHBoxInfo = new HBox(150);
        createPictureHBoxInfo.setAlignment(Pos.CENTER);
        createPictureHBoxInfo.getChildren().addAll(createPictureLabelInfo1, createPictureVBoxTextField);
        createPictureHBoxButton = new HBox(600);
        createPictureHBoxButton.getChildren().addAll(createPictureButtonGoBack, createPictureButton);
        
        createPictureVBox = new VBox(50);
        createPictureVBox.setPadding(new Insets(10));
        createPictureVBox.getChildren().addAll(createPictureLabelTitle, createPictureLabelInfo, createPictureHBoxInfo, createPictureHBoxButton);
        
        createPictureScene = new Scene(createPictureVBox);
        
        createPictureStage.setScene(createPictureScene);
        createPictureStage.showAndWait();
    }
    
    public static void MainFeed()
    {
        if ((time == false) && (likes == false) && (location == false))
        {
            PixTastic.pictureAL.clear();
            for (RegisteredUser ele : PixTastic.registeredUserAL)
            {
                for (Picture pic : ele.getArraylist())
                {
                    PixTastic.pictureAL.add(pic);
                }
            }
        }
        time = false;
        likes = false;
        
        
        mainFeedLabelTitle = new Label();
        if (GUI.userLoggedIn != null)
        {
            mainFeedLabelTitle.setText(GUI.userLoggedIn.getUsername()+"'s Main Feed\t\t\t\t");
        }
        else
        {
            mainFeedLabelTitle.setText("Guest's Main Feed\t\t\t\t");
        }
        mainFeedLabelTitle.setOnMouseClicked(e -> {
        if (GUI.userLoggedIn != null)
        {
            Profile(GUI.userLoggedIn);
        }
        else
            GUI.AlertBox("Not Logged In!", "Sorry, You must be logged in to do that!");
        });
        mainFeedLabelTitle.setFont(Font.font("arial", 40));
        mainFeedLabelSort = new Label("Sort By:  ");
        mainFeedLabelSort.setFont(Font.font("arial", 25));
        mainFeedLabelSearch = new Label("Search by HashTag:");
        mainFeedLabelSearch.setFont(Font.font("arial", 25));
        
        mainFeedButtonSortTime = new Button("Time Posted");
        mainFeedButtonSortTime.setOnAction(e -> {
            time = true;
            Collections.sort(PixTastic.pictureAL, new ComparatorByTime());
            MainFeed();
        });
        mainFeedButtonSortLikes = new Button("Likes");//arraylistComp.add(pic);
        mainFeedButtonSortLikes.setOnAction(e -> {
            likes = true;
            Collections.sort(PixTastic.pictureAL, new ComparatorByLikes());
            MainFeed();
        });
        mainFeedButtonSortLocation = new Button("Follow");
        if (GUI.userLoggedIn != null)
            {
                mainFeedButtonSortLocation.setOnAction(e -> {
                location = true;
                //Collections.sort(PixTastic.registeredUserAL, new ComparatorByLocation());
                MainFeed();
            });
            }
        
        mainFeedButtonSearch = new Button("Search");
        mainFeedButtonSearch.setMinWidth(200);
        
        mainFeedTextFieldSearch = new TextField();
        mainFeedTextFieldSearch.setPromptText("e.g. #food");
        mainFeedTextFieldSearch.setAlignment(Pos.BASELINE_RIGHT);
        mainFeedTextFieldSearch.setMinWidth(400);
        
        mainFeedButtonSearch.setOnAction(e -> {
            for (Picture ele : PixTastic.pictureAL)
            {
                if (ele.getHashtag().equalsIgnoreCase(mainFeedTextFieldSearch.getText()))
                {
                    PixTastic.arraylistSearch.add(ele);
                }
            }
            other = true;
            MainFeed();
        });
        
        mainFeedHBoxTitle = new HBox(10);
        mainFeedHBoxTitle.getChildren().addAll(mainFeedLabelTitle, mainFeedLabelSort, mainFeedButtonSortLikes, mainFeedButtonSortTime, mainFeedButtonSortLocation);
        mainFeedHBoxSearch = new HBox(20);
        mainFeedHBoxSearch.setAlignment(Pos.CENTER_RIGHT);
        mainFeedHBoxSearch.getChildren().addAll(mainFeedLabelSearch, mainFeedTextFieldSearch, mainFeedButtonSearch);
        
        mainFeedVBoxImages = new VBox(25);
        mainFeedVBoxImages.setAlignment(Pos.CENTER);
        mainFeedVBoxImages.setPadding(new Insets(25,0,25,25));
        
        if (other == true)
        {
           for (Picture pic : PixTastic.arraylistSearch)
            {
                File f = new File(pic.getFPath());
                ImageView photo = new ImageView(f.toURI().toString());
                photo.setFitHeight(400);
                photo.setFitWidth(400);
                if (GUI.userLoggedIn != null)
                {
                    photo.setOnMouseClicked(e -> PicturePost(pic));
                }
                mainFeedLabelImage = new Label(
                        "Posted By:\t\t"+pic.getOwner().getUsername()
                        +"\n\nTime Posted:\t\t"+pic.getTime().format(DateTimeFormatter.ofPattern("MM-dd-yyyy @ hh:mm:ss"))
                        +"\n\nLikes:\t\t\t"+pic.getLikes()
                        +"\n\nLocation:\t\t\t"+pic.getOwner().getLocation()
                        +"\n\nHashTag:\t\t\t"+pic.getHashtag());
                mainFeedLabelImage.setFont(Font.font("arial", 25));
                mainFeedHBoxImage = new HBox(50);
                mainFeedHBoxImage.getChildren().addAll(photo, mainFeedLabelImage);

                mainFeedVBoxImages.getChildren().add(mainFeedHBoxImage);
            }
        }
        if (location == true)
        {
            for (RegisteredUser ele : GUI.userLoggedIn.getAlFollowing())
            {
                for (Picture pic : ele.getArraylist())
                {
                    File f = new File(pic.getFPath());
                    ImageView photo = new ImageView(f.toURI().toString());
                    photo.setFitHeight(400);
                    photo.setFitWidth(400);
                    if (GUI.userLoggedIn != null)
                    {
                        photo.setOnMouseClicked(e -> PicturePost(pic));
                    }

                    mainFeedLabelImage = new Label(
                            "Posted By:\t\t"+pic.getOwner().getUsername()
                            +"\n\nTime Posted:\t\t"+pic.getTime().format(DateTimeFormatter.ofPattern("MM-dd-yyyy @ hh:mm:ss"))
                            +"\n\nLikes:\t\t\t"+pic.getLikes()
                            +"\n\nLocation:\t\t\t"+pic.getOwner().getLocation()
                            +"\n\nHashTag:\t\t\t"+pic.getHashtag());
                    mainFeedLabelImage.setFont(Font.font("arial", 25));
                    mainFeedHBoxImage = new HBox(50);
                    mainFeedHBoxImage.getChildren().addAll(photo, mainFeedLabelImage);

                    mainFeedVBoxImages.getChildren().add(mainFeedHBoxImage);
                }
            }
        }
        else
            for (Picture pic : PixTastic.pictureAL)
            {
                File f = new File(pic.getFPath());
                ImageView photo = new ImageView(f.toURI().toString());
                photo.setFitHeight(400);
                photo.setFitWidth(400);
                if (GUI.userLoggedIn != null)
                {
                    photo.setOnMouseClicked(e -> PicturePost(pic));
                }

                mainFeedLabelImage = new Label(
                        "Posted By:\t\t"+pic.getOwner().getUsername()
                        +"\n\nTime Posted:\t\t"+pic.getTime().format(DateTimeFormatter.ofPattern("MM-dd-yyyy @ hh:mm:ss"))
                        +"\n\nLikes:\t\t\t"+pic.getLikes()
                        +"\n\nLocation:\t\t\t"+pic.getOwner().getLocation()
                        +"\n\nHashTag:\t\t\t"+pic.getHashtag());
                mainFeedLabelImage.setFont(Font.font("arial", 25));
                mainFeedHBoxImage = new HBox(50);
                mainFeedHBoxImage.getChildren().addAll(photo, mainFeedLabelImage);

                mainFeedVBoxImages.getChildren().add(mainFeedHBoxImage);
            }
        
        mainFeedScrollPaneImages = new ScrollPane();
        mainFeedScrollPaneImages.setMaxHeight(700);
        mainFeedScrollPaneImages.setContent(mainFeedVBoxImages);
        
        mainFeedVBox = new VBox(10);
        mainFeedVBox.setPadding(new Insets(10));
        mainFeedVBox.getChildren().addAll(mainFeedHBoxTitle, mainFeedHBoxSearch, mainFeedScrollPaneImages, bottomMenu);
        
        mainFeedScene = new Scene(mainFeedVBox, 1000, 900);
        GUI.window.setScene(mainFeedScene);
        location = false;
        other = false;
    }
}
