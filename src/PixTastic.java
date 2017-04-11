import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PixTastic extends Application
{
    Stage window;
    Button button;
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage window)
    {
        this.window = window;
        window.setTitle("PixTastic");
        
        button = new Button();
        button.setText("Click Here");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
                {
                    System.out.println("Success");
                    window.close();
                    www.homeandlearn.chttps://www.google.com/maps/place/RunRite+Small+Engine+Repair+%26+Custom+Golf+Carts/@38.2391926,-77.5371852,14z/data=!4m20!1m14!4m13!1m6!1m2!1s0x89b6c7206508ecd7:0x41910e4d3fa86d19!2s9503+Whiteheart+Drive,+Fredericksburg,+VA+22407-9332,+USA!2m2!1d-77.51696!2d38.2172849!1m5!1m1!1s0x89b6c112422699af:0x2211eba75af5e666!2m2!1d-77.4997942!2d38.2641129!3m4!1s0x89b6c112422699af:0x2211eba75af5e666!8m2!3d38.2641129!4d-77.4997942o.uk/java/java_and_databases.html
                }
        });
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        
        Scene scene = new Scene(layout, 300, 250);
        
        window.setScene(scene);
        window.show();
    }
}