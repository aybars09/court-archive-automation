package controller;

import dao.PersonelDAO;
import model.Personel;
import dao.DAOAbstract;
import model.EntityInterface;
import dao.ArsivDAO;
import dao.ImhaDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import model.Arsiv;
import model.Imha;
import utility.ComboboxDoldur;

public class ImhaController extends BaseController implements Initializable {

    @FXML private DatePicker txtTarih;
    @FXML private ComboBox<Personel> cmbPers;
    @FXML private ComboBox<Arsiv> cmbArsiv;
   
    
    //sınıfın kullanacağı dao 
    private DAOAbstract<Imha> dao;
    
    
    @Override
    public DAOAbstract getDAO() {
        if (dao == null) {
            dao = new ImhaDao();
        }
        return dao;
    }
    


    
    
    @Override
    public boolean isError() {
        return txtTarih.getValue() == null || cmbArsiv.getValue() == null || cmbPers.getValue() == null;
    }


    
    @Override
    public void clearFormFields() {
         clearNodes(txtID,cmbArsiv,cmbPers);
    }

    
    
    @Override
    public ArrayList<EntityInterface> tablodaGosterilecekListe() {
        return getDAO().getAll();
    }
    

    @Override
    public void createTable() {
        String[] columns = new String[]{"id","arsiv","pers","date"};
        String[] Basliklar = new String[]{"ID","İmha Edilecek Dosya","Görevli Personel","İmha Tarihi"};
        createTableColumn(columns, Basliklar); 
    }

    
    
    @Override
    public EntityInterface fromForm() {
        Imha entity =new Imha();
        //id olarak sayi girmis mi
        if(isNumber(txtID.getText())){
            entity.setId(Integer.parseInt(txtID.getText()));
        } else  entity.setId(0);
        
        //diğer elemanları set et
        entity.setArsiv(cmbArsiv.getValue());
        entity.setPers(cmbPers.getValue());
        entity.setDate(txtTarih.getValue().toString());
        return entity;
    }

    
    
    
    private void comboboxDoldur(){
        ComboboxDoldur.comboboxPopulateFromDao(cmbArsiv, new ArsivDAO());
        ComboboxDoldur.comboboxPopulateFromDao(cmbPers, new PersonelDAO());
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(null, null);
        comboboxDoldur();
    }
    
    
    
    

    @FXML
    private void toForm(MouseEvent event) {
        Imha entity = (Imha) table.getSelectionModel().getSelectedItem();
        if (entity != null) {
            btnsDisabledEnabled(true);
            txtID.setText(String.valueOf(entity.getId()));
            //txtTarih.setText(entity.getDate());
            cmbArsiv.setValue(entity.getArsiv());
            cmbPers.setValue(entity.getPers());
        }
    }

}
