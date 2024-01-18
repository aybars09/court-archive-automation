
package controller;

import dao.DAOAbstract;
import model.EntityInterface;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Personel;
import dao.PersonelDAO;


public class PersonelController  extends BaseController implements Initializable {

    @FXML
    private TextField txtID,txtTc,txtAdSoyad,txtDtarihi,txtBirim;

     //sınıfın kullanacağı dao 
    private DAOAbstract<Personel> dao;
    

    //state tasarım kalıbı, durum değişikliklerini bu metodla haber almaktadır
    @Override
    public DAOAbstract getDAO() {
        if(dao==null) 
            dao=new PersonelDAO();
        return dao;
    }
    

    

    //tablodaki verileri entitiye doldur

    @FXML public void toForm() {
        Personel entity = (Personel) table.getSelectionModel().getSelectedItem();
        if (entity != null) {
            btnsDisabledEnabled(true);
            txtID.setText(String.valueOf(entity.getId()));
            txtAdSoyad.setText(entity.getAdSoyad());
            txtBirim.setText(entity.getCalistigiBirim());
            txtDtarihi.setText(entity.getdTArihi());
            txtTc.setText(entity.getTcNo());
        }
    }

   
    
    

    //kutucuklardaki verilerle entity oluştur
    @Override
    public Personel fromForm() {
        Personel entity =new Personel();
        //id olarak sayi girmis mi
        if(isNumber(txtID.getText())){
            entity.setId(Integer.parseInt(txtID.getText()));
        } else  entity.setId(0);
        //diğer elemanları set et
        entity.setAdSoyad(txtAdSoyad.getText());
        entity.setCalistigiBirim(txtBirim.getText());
        entity.setTcNo(txtTc.getText());
        entity.setdTArihi(txtDtarihi.getText());
        
        return entity;
    }
    
    

    //kutucuklarda hatalı veri var mı kontrol et
    @Override
    public boolean isError() {
        //eğer ad girilmemişse
        return txtAdSoyad.getText().trim().isEmpty();
    }

    
    
    
    //sınıfın kullandığı hata mesajı
    @Override
    public void errorMsg() {
        JOptionPane.showMessageDialog(null, "Form components (Name and Türü) cant be empty..  !!");
    }
    
    
    
    //kutucukları temizle
    @Override
    public void clearFormFields() {
        clearNodes(txtID,txtAdSoyad,txtBirim,txtDtarihi,txtTc);
    }
    
    


    //tablo olustur
    @Override
    public void createTable() {
        String[] columns = new String[]{"id","tcNo","adSoyad","dTArihi","calistigiBirim"};
        String[] Basliklar = new String[]{"ID","Tc Kimlik No","Adı Soyadı","Doğum Tarihi","Çalıştığı Birim"};
        createTableColumn(columns, Basliklar);    
    }



  
    

    //tabloyu dolduracak verileri liste halinde dao dan getir
    @Override
    public ArrayList<EntityInterface> tablodaGosterilecekListe() {
        ArrayList<EntityInterface> list=getDAO().getAll();
        return list!=null?list:new ArrayList<>();
    }


    

}
