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
        RegisteredUser user1 = new RegisteredUser("seth77","Seth Perts","Virginia","C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\images.jpg","I go to school at UMW. My favorite color is blue. My favorite football team is the steelers. Go Pittsburgh!",true,true);
        Picture pic1 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\cat1.jpg","I love my cat!","blah","#cats",10);
        Picture pic2 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\cat2.jpg","My cat is the cutest!","blaher","",10);
        Picture pic3 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\umw1.jpg","My school rocks!","blah2","#umw",10);
        Picture pic4 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\food1.jpg","Yum!","blah3","",10);
        Picture pic5 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\football1.jpg","Go football!","blah5","",10);
        user1.addPicture(pic1);
        user1.addPicture(pic2);
        user1.addPicture(pic3);
        user1.addPicture(pic4);
        user1.addPicture(pic5);
        registeredUserAL = new ArrayList<>();
        registeredUserAL.add(user1);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss")));
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        GUI.startProgram(window);
    }
}
