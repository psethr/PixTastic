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
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class PixTastic extends Application
{
   public static String username;
   public static String name;
   public static String location;
   public static String profilePic;
   public static String bio;
   public static int numUsers = 0;
   public static ArrayList<RegisteredUser> registeredUserAL;
   
   public static void main(String[] args)
    {
        
        Scanner in = new Scanner(System.in);
        Scanner f = null;
        String fileUsers = "C:\\Users\\Rachel\\Documents\\PixTastic\\User.txt.txt";
        String line = "";
    try
    {  
           FileReader fileReader = new FileReader(fileUsers);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           
           while((line = bufferedReader.readLine()) != null)
           { 
             String[] inputSplit = line.split("(?<=\") *(?=\")");  
             username = inputSplit[0];
             name = inputSplit[1];
             location = inputSplit[2];
             profilePic = inputSplit[3];
             bio = inputSplit[4];
            
             RegisteredUser user = new RegisteredUser(username, name, location, profilePic, bio, true); 
             registeredUserAL.add(user);
             numUsers++;
             //System.out.println(" " + registeredUserAL);
           }
           bufferedReader.close();
    }
        
    catch (IOException e) 
    {
            System.err.println("Caught IOException: " + e.getMessage());
    }
    /*
        RegisteredUser user1 = new RegisteredUser("seth77","Seth Perts","Virginia","C:\\Users\\Seth\\Desktop\\CPSC 240\\Group Project Pictures\\images.jpg","I go to school at UMW. My favorite color is blue. My favorite football team is the steelers. Go Pittsburgh!",true);
        GUI.userLoggedIn = user1;
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
        //GUI.userLoggedIn = user2;
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
        //System.out.println(GUI.userLoggedIn.getUsername());
        */
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        GUI.startProgram(window);
    }
}
