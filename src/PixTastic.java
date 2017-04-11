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
                }
        });
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        
        Scene scene = new Scene(layout, 300, 250);
        
        window.setScene(scene);
        window.show();
    }
}