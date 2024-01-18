
package controller;




import utility.ShowForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.ActiveUser;
import dao.UserDAO;
import model.User;



public class LoginController  {
    
    /*kullanıcı adı şifre  
INSERT INTO USERS(userName,password,groupsID,aitOldKisiID)VALUES('admin','1',1,1);
INSERT INTO USERS(userName,password,groupsID,aitOldKisiID)VALUES('kullanici','123456',2,2);
    */

    @FXML private TextField txtUName;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnLogin, btnCancel;
    @FXML private Text lnkSignUp;
    
 

 
    
    
    //close stage
    @FXML void cancel() {
        closeStage();
    }

    
    
    
    //login system
    @FXML void login() {
        final User user=isUserHave();
        if(user != null){
            ActiveUser.setActiveUser(user);
            System.out.println("Aktif User set edildii: "+ActiveUser.getActiveUser().toString());
            closeStage();
            
            
            new ShowForm().createForm(new Stage(), "/view/start.fxml", true).show();
            
            
        }else{
            JOptionPane.showMessageDialog(null, "User Name or Pass is wrong");
        }
    }
    
    
    


    //kaydol dugmesine tiklaninca calisan bu metod yeni bir kullanici kaydi yapar
    @FXML
    private void registerNewUser(ActionEvent event) {
        
         new ShowForm().createForm(new Stage(), "/login/newUser.fxml", true).show();
    }
    

    
    /**
     * kullanicinin bilgileri mevcut mu
     * @return eger bulunamazsa null bulunursa da kullanici bilgileri
     */
    private User isUserHave() {
        final UserDAO userDao = new UserDAO();
        final String password=txtPassword.getText();
        final String userName=txtUName.getText();
        User result=userDao.isHave(userName, password);
        return result;
    }
    
    
    private void closeStage(){
         ((Stage) this.txtUName.getScene().getWindow()).close();
    }
}
