package controller;

import utility.ShowForm;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class startController {



    @FXML
    void showArchieve(MouseEvent event) {
        showForm("/view/arsiv");
    }
    
    
    @FXML
    void showImha(MouseEvent event) {
        showForm("/view/imha");
    }   
    
    

    @FXML
    void showMahkemeler(MouseEvent event) {
        showForm("/view/mahkemeler");
    }
       

    
    
    @FXML
    void showPersonnel(MouseEvent event) {
        showForm("/view/personel");
    }

    
    
    
    @FXML
    void showUsers(MouseEvent event) {
        showForm("/view/user");
    }
    
    
    
    
    
    private void showForm(String path){
        new ShowForm().createForm(new Stage(), path+".fxml", false).showAndWait();
    }
    
    
    

    @FXML
    private void exit(MouseEvent event) {
        if(JOptionPane.showConfirmDialog(null, "Are You Sure?  Aborted The Program","EXIT",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
        System.exit(0);
    }

}
