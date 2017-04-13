import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class GUI
{
    private static Stage alertBoxStage, confirmBoxStage;
    private static Scene alertBoxScene, confirmBoxScene;
    private static Button alertBoxButton, confirmBoxButtonYes, confirmBoxButtonNo;
    private static Label alertBoxLabel, confirmBoxLabel;
    private static VBox alertBoxVBox, confirmBoxVBox;
    private static HBox confirmBoxHBox;
    
    private static boolean comfirmBoxAnswer;
    
    public void AlertBox(String title, String message)
    {
        alertBoxStage = new Stage();
        alertBoxStage.initModality(Modality.APPLICATION_MODAL);
        alertBoxStage.setTitle(title);
        alertBoxStage.setMinWidth(350);
        
        alertBoxLabel = new Label(message);
        
        alertBoxButton = new Button("OK");
        alertBoxButton.setOnAction(e -> alertBoxStage.close());
        
        alertBoxVBox = new VBox();
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
}
