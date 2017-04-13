//Authors seth, rachel, tiffany
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

public class PixTastic extends Application
{
    private Stage window;
    private Scene startPage;
    private Button closeButton, loginButton, createAccount, guest;
    private Label title1, title2, titleSlogan, author;
    private HBox centerMenu, rightMenu, topMenu1;
    private VBox topMenu;
    private BorderPane borderPane;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        this.window = window;
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
        createAccount = new Button("Create an\nAccount");
        createAccount.setFont(Font.font("Arial", 30));
        createAccount.setTextAlignment(TextAlignment.CENTER);
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
        rightMenu = new HBox();
        rightMenu.setPadding(new Insets(10));
        rightMenu.setAlignment(Pos.BOTTOM_RIGHT);
        rightMenu.setSpacing(600);
        rightMenu.getChildren().addAll(author, closeButton);
        borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerMenu);
        borderPane.setBottom(rightMenu);
        
        startPage = new Scene(borderPane, 1000, 900);
        
        window.setScene(startPage);
        window.show();
    }
    
    public void exitProgram()
    {
        Boolean answer = GUI.ConfirmBox("Exit Program", "Are you sure you want to exit the program?");
        if (answer == true)
        {
            window.close();
        }
    }
}