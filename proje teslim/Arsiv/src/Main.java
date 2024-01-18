 

import utility.ShowForm;
import javafx.application.Application;
import javafx.stage.Stage;

 
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         new ShowForm().createForm(new Stage(), "/view/login.fxml", true).show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
