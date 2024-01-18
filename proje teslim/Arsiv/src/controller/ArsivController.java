package controller;

import dao.DAOAbstract;
import model.EntityInterface;
import dao.ArsivDAO;
import dao.DavaTuruDao;
import dao.MahkemelerDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Arsiv;
import model.DavaTuru;
import model.Mahkemeler;
import utility.ComboboxDoldur;

public class ArsivController extends BaseController implements Initializable {

    
    @FXML private ComboBox<Mahkemeler> cmbGeldigiYer;
    @FXML private ComboBox<DavaTuru> cmbDavaTuru;
    @FXML private TextField txtDosyaEsasNo, txtKararNo, txtKararTarihi, txtKesinlesmeTar, txtDurumu,txtYil;

   
    
    //sınıfın kullanacağı dao 
    private DAOAbstract<Arsiv> dao;
    
    
    @Override
    public DAOAbstract getDAO() {
        if (dao == null) {
            dao = new ArsivDAO();
        }
        return dao;
    }
    
    

    
    @Override
    public boolean isError() {
        if(!isNumber(txtYil.getText())) return true;
        return txtDosyaEsasNo.getText().trim().isEmpty()||cmbGeldigiYer.getValue()==null||cmbDavaTuru.getValue()==null;
    }

    
    
    
    @Override
    public void errorMsg() {
        JOptionPane.showMessageDialog(null, "hatalı/eksik veri girişi var kontrol ederek tekrar giriniz");
    }

    
    
    
    @Override
    public void clearFormFields() {
         clearNodes(txtID,txtDosyaEsasNo,txtDurumu,txtKararNo,txtKararTarihi,txtKesinlesmeTar,txtYil,cmbGeldigiYer,cmbDavaTuru);
    }

    
    
    @Override
    public ArrayList<EntityInterface> tablodaGosterilecekListe() {
        return getDAO().getAll();
    }
    


    @Override
    public void createTable() {
        String[] columns = new String[]{"geldigiYer","dosyaEsasNo","kararNo","karartarihi","kesinlesmeTarihi","davaTuru"};
        String[] Basliklar = new String[]{"Mahkeme","Esas No","Karar No","Karar Tarihi","Kesinleşme Tarihi","Dava Türü"};
        createTableColumn(columns, Basliklar); 
    }


    
    
    @Override
    public EntityInterface fromForm() {
        Arsiv entity =new Arsiv();
        //id olarak sayi girmis mi
        if(isNumber(txtID.getText())){
            entity.setId(Integer.parseInt(txtID.getText()));
        } else  entity.setId(0);
        
        //diğer elemanları set et
        entity.setDavaTuru(cmbDavaTuru.getValue());
        entity.setDosyaEsasNo(txtDosyaEsasNo.getText());
        entity.setDurumu(txtDurumu.getText());
        entity.setGeldigiYer(cmbGeldigiYer.getValue());
        entity.setKararNo(txtKararNo.getText());
        entity.setKarartarihi(txtKararTarihi.getText());
        entity.setKesinlesmeTarihi(txtKesinlesmeTar.getText());
        entity.setYil(Integer.parseInt(txtYil.getText()));
        
        return entity;
    }

    
    
    
    private void comboboxDoldur(){
        //ComboboxDoldur.comboboxPopulateFromDao(cmbDavaTuru, new DavaTuruDao());
        ComboboxDoldur.comboboxPopulateFromDao(cmbGeldigiYer, new MahkemelerDAO());
    }
    
    
    
    @FXML private void comboDavaTuruDoldur(){
            if(cmbGeldigiYer.getValue()!=null){
            List<DavaTuru> lst =(List<DavaTuru>) (Object) new DavaTuruDao().getByMahkeme(cmbGeldigiYer.getValue());
            ObservableList<DavaTuru> olist = FXCollections.observableArrayList(lst);
            cmbDavaTuru.getItems().clear();
            cmbDavaTuru.getItems().addAll(olist);
        }
    } 
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(null, null);
        comboboxDoldur();
    }
    
    
    
    

    @FXML
    private void toForm(MouseEvent event) {
        Arsiv entity = (Arsiv) table.getSelectionModel().getSelectedItem();
        if (entity != null) {
            btnsDisabledEnabled(true);
            txtID.setText(String.valueOf(entity.getId()));
            txtDosyaEsasNo.setText(entity.getDosyaEsasNo());
            txtDurumu.setText(entity.getDurumu());
            txtKararNo.setText(entity.getKararNo());
            txtKararTarihi.setText(entity.getKarartarihi());
            txtKesinlesmeTar.setText(entity.getKesinlesmeTarihi());
            txtYil.setText(String.valueOf(entity.getYil()));
           
            cmbDavaTuru.setValue(entity.getDavaTuru());
            cmbGeldigiYer.setValue(entity.getGeldigiYer());
        }
    }


}
