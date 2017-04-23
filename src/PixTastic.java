//Authors seth, rachel, tiffany
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class PixTastic extends Application
{
    /**public static Stage window;
    public static Scene startPage;
    public static Button closeButton, loginButton, createAccount, guest;
    public static Label title1, title2, titleSlogan, author;
    public static HBox centerMenu, bottomMenu, topMenu1;
    public static VBox topMenu;
    public static BorderPane borderPane;*/
    
    
    public static ArrayList<RegisteredUser> registeredUserAL;
    public static void main(String[] args)
    {
        registeredUserAL = new ArrayList<>();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss")));
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        GUI.startProgram(window);
        /*PixTastic.window = window;
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
        loginButton = new Button("Login");
        loginButton.setFont(Font.font("Arial", 30));
        loginButton.setOnAction(e -> {
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
        centerMenu.getChildren().addAll(loginButton, createAccount, guest);
        bottomMenu = new HBox();
        bottomMenu.setPadding(new Insets(10));
        bottomMenu.setAlignment(Pos.BOTTOM_RIGHT);
        bottomMenu.setSpacing(600);
        bottomMenu.getChildren().addAll(author, closeButton);
        borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setBottom(bottomMenu);
        
        startPage = new Scene(borderPane, 1000, 900);
        
        window.setScene(startPage);
        window.show();*/
    }
    
    /*public void exitProgram()
    {
        Boolean answer = GUI.ConfirmBox("Exit Program", "Are you sure you want to exit the program?");
        if (answer == true)
        {
            window.close();
        }
    }*/
}
