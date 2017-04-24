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
        RegisteredUser user1 = new RegisteredUser("seth77","Seth Perts","Virginia","C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\images.jpg","I go to school at UMW. My favorite color is blue. My favorite football team is the steelers. Go Pittsburgh!",true);
        Picture pic1 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\cat1.jpg","I love my cat!","blah","#cats",10);
        Picture pic2 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\cat2.jpg","My cat is the cutest!","blaher","",410);
        Picture pic3 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\umw1.jpg","My school rocks!","blah2","#umw",105);
        Picture pic4 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\food1.jpg","Yum!","blah3","",102);
        Picture pic5 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\football1.jpg","Go football!","blah5","",10);
        user1.addPicture(pic1);
        user1.addPicture(pic2);
        user1.addPicture(pic3);
        user1.addPicture(pic4);
        user1.addPicture(pic5);
        RegisteredUser user2 = new RegisteredUser("BoBBY_cool","Bob Peason","Your Mom","C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\images.jpg","Im an alcoholic who doesn't care.",true);
        GUI.userLoggedIn = user2;
        Picture pic11 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\food2.jpg","Food is good!","blah","#food",12);
        Picture pic22 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\car1.jpg","My dream car!","","#never",130);
        Picture pic33 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\homework1.jpg","F@#K school!","blah2","#umw",16);
        Picture pic44 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\gym1.jpg","Pumping iron","","#Swoll",10);
        Picture pic55 = new Picture("C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\movie1.jpg","I loe movies!","","#cantwait",10);
        user2.addPicture(pic11);
        user2.addPicture(pic22);
        user2.addPicture(pic33);
        user2.addPicture(pic44);
        user2.addPicture(pic55);
        user2.addFollower(user1);
        registeredUserAL = new ArrayList<>();
        registeredUserAL.add(user1);
        registeredUserAL.add(user2);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss")));
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        GUI.startProgram(window);
    }
}
