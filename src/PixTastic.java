//Authors seth, rachel, tiffany
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class PixTastic extends Application
{
    Stage window;
    Button button;
    Label name;
    HBox topMenu;
    HBox centerMenu;
    BorderPane borderPane;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        this.window = window;
        window.setTitle("PixTastic");
        
        name = new Label("PixTastic");
        name.setFont(Font.font("Permanent Marker", 80));
        
        button = new Button();
        button.setText("Close Program");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
                {
                    System.out.println("Success");
                    window.close();
                }
        });
        Button button2 = new Button("Login");
        button2.setFont(Font.font("Arial", 50));
        topMenu = new HBox();
        topMenu.setAlignment(Pos.CENTER);
        topMenu.setPadding(new Insets(10));
        topMenu.setSpacing(500.0);
        topMenu.getChildren().addAll(name, button);
        centerMenu = new HBox();
        centerMenu.getChildren().addAll(button2);
        centerMenu.setAlignment(Pos.CENTER);
        borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setCenter(centerMenu);
        
        Scene scene = new Scene(borderPane, 1000, 900);
        
        window.setScene(scene);
        window.show();
    }
}