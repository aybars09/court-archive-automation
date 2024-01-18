package controller;

import dao.DAOAbstract;
import model.EntityInterface;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Group;
import dao.GroupDao;
import model.Personel;
import dao.PersonelDAO;
import model.User;
import dao.UserDAO;
import utility.ComboboxDoldur;

public class UserController extends BaseController implements Initializable {

    @FXML private TextField txtUserName, txtPassword;
    @FXML private ComboBox<Personel> cmbPers;
    @FXML private ComboBox<Group> cmbGroup;
   
    
    //sınıfın kullanacağı dao 
    private DAOAbstract<User> dao;
    
    
    @Override
    public DAOAbstract getDAO() {
        if (dao == null) {
            dao = new UserDAO();
        }
        return dao;
    }
    

    
    
    @Override
    public boolean isError() {
         return txtUserName.getText().trim().isEmpty()||cmbPers.getValue()==null||cmbGroup.getValue()==null;
    }

    
    
    
    @Override
    public void errorMsg() {
        JOptionPane.showMessageDialog(null, "Kullanıcı Adı, Kime Ait olduğu ve grubu bilgileri zorunludur");
    }

    
    
    
    @Override
    public void clearFormFields() {
         clearNodes(txtID,txtPassword,txtUserName,cmbGroup,cmbPers);
    }

    
    
    @Override
    public ArrayList<EntityInterface> tablodaGosterilecekListe() {
        return getDAO().getAll();
    }
    


    @Override
    public void createTable() {
        String[] columns = new String[]{"id","userName","password","pers","groups"};
        String[] Basliklar = new String[]{"ID","Kullanıcı Adı","Şifresi","Ait Olduğu Pers.","Grubu"};
        createTableColumn(columns, Basliklar); 
    }

    
    
    @Override
    public EntityInterface fromForm() {
        User entity =new User();
        //id olarak sayi girmis mi
        if(isNumber(txtID.getText())){
            entity.setId(Integer.parseInt(txtID.getText()));
        } else  entity.setId(0);
        
        //diğer elemanları set et
        entity.setPassword(txtPassword.getText());
        entity.setUserName(txtUserName.getText());
        entity.setPers(cmbPers.getValue());
        entity.setGroups(cmbGroup.getValue());
        return entity;
    }

    
    
    
    private void comboboxDoldur(){
        ComboboxDoldur.comboboxPopulateFromDao(cmbGroup, new GroupDao());
        ComboboxDoldur.comboboxPopulateFromDao(cmbPers, new PersonelDAO());
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(null, null);
        comboboxDoldur();
    }
    
    
    
    

    @FXML
    private void toForm(MouseEvent event) {
        User entity = (User) table.getSelectionModel().getSelectedItem();
        if (entity != null) {
            btnsDisabledEnabled(true);
            txtID.setText(String.valueOf(entity.getId()));
            txtPassword.setText(entity.getPassword());
            txtUserName.setText(entity.getUserName());
            cmbPers.setValue(entity.getPers());
            cmbGroup.setValue(entity.getGroups());
        }
    }

}
