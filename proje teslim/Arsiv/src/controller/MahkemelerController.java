package controller;

import dao.DAOAbstract;
import model.EntityInterface;
import dao.MahkemeTuruDao;
import dao.MahkemelerDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.MahkemeTuru;
import model.Mahkemeler;




public class MahkemelerController extends BaseController implements Initializable {

    @FXML private TextField txtName;
    @FXML private ComboBox<MahkemeTuru> cmbMahkemeTuru;
   
    //sınıfın kullanacağı dao 
    private DAOAbstract<Mahkemeler> dao;
    

    //state tasarım kalıbı, durum değişikliklerini bu metodla haber almaktadır
    @Override
    public DAOAbstract getDAO() {
        if(dao==null) 
            dao=new MahkemelerDAO();
        return dao;
    }
    

    

    //tablodaki verileri entitiye doldur
    
    @FXML public void toForm() {
        Mahkemeler entity = (Mahkemeler) table.getSelectionModel().getSelectedItem();
        if (entity != null) {
            btnsDisabledEnabled(true);
            txtID.setText(String.valueOf(entity.getId()));
            txtName.setText(entity.getAdi());
            cmbMahkemeTuru.setValue(entity.getMahkemeTuru());
        }
    }

   
    
    

    //kutucuklardaki verilerle entity oluştur
    @Override
    public Mahkemeler fromForm() {
        Mahkemeler entity =new Mahkemeler();
        //id olarak sayi girmis mi
        if(isNumber(txtID.getText())){
            entity.setId(Integer.parseInt(txtID.getText()));
        } else  entity.setId(0);
        //diğer elemanları set et
        entity.setAdi(txtName.getText());
        entity.setMahkemeTuru(cmbMahkemeTuru.getValue());
        return entity;
    }
    
    

    //kutucuklarda hatalı veri var mı kontrol et
    @Override
    public boolean isError() {
        //eğer ad girilmemişse
        return txtName.getText().trim().isEmpty()||cmbMahkemeTuru.getValue()==null;
    }

    
    
    
    //sınıfın kullandığı hata mesajı
    @Override
    public void errorMsg() {
        JOptionPane.showMessageDialog(null, "Form components (Name and Türü) cant be empty..  !!");
    }
    
    
    
    //kutucukları temizle
    @Override
    public void clearFormFields() {
        clearNodes(txtID,txtName,cmbMahkemeTuru);
    }
    
    


    //tablo olustur
    @Override
    public void createTable() {
        String[] columns = new String[]{"id","adi","mahkemeTuru"};
        String[] Basliklar = new String[]{"No","Mahkemenin Adı","Mahkemenin Türü"};
        createTableColumn(columns, Basliklar);    
    }



    private void comboboxDoldur(){
        ObservableList<MahkemeTuru> observableList = FXCollections.observableArrayList(new MahkemeTuruDao().getAll());
        cmbMahkemeTuru.getItems().setAll(observableList);
    }
    

    //tabloyu dolduracak verileri liste halinde dao dan getir
    @Override
    public ArrayList<EntityInterface> tablodaGosterilecekListe() {
        ArrayList<EntityInterface> list=getDAO().getAll();
        return list!=null?list:new ArrayList<>();
    }
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {

        super.initialize(null, null);
        comboboxDoldur();
    }

}
