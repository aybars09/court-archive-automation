package controller;

import dao.DAOAbstract;
import model.EntityInterface;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * Bütün controller sınıflarında ortak olan değişken ve metodlar kod tekrarının
 * azaltılması kod hakimiyetinin sağlanması tek yerden kontrol amacıyla yani
 * Nesne tabanlı tasarımın temellerinden olan SOLID prensiplerinden Single
 * Responsibility nin sağlanması amacıyla diğer controller sınıflarının extend
 * edeceği bu sınıfta toplanmıştır
 */
public abstract class BaseController implements Initializable{

    @FXML protected Button btnSave, btnUpdate, btnDelete, btnCancel;
    @FXML protected TableView<EntityInterface> table;
    @FXML protected TextField txtID;
    
    
    //abstract methods
    abstract public DAOAbstract getDAO();
    abstract public boolean isError(); 
    //abstract public void errorMsg();
    abstract public void clearFormFields();
    abstract public ArrayList<EntityInterface> tablodaGosterilecekListe();
    abstract public void createTable();
    
    abstract public EntityInterface fromForm();

    
    public void errorMsg() {
        JOptionPane.showMessageDialog(null,  "hatalı/eksik veri girişi var kontrol ederek tekrar giriniz");
    }

    

    
    private void refreshTable(ArrayList<EntityInterface> list) {
        table.getItems().clear();
        table.getItems().addAll(list);
        table.refresh();
    }

    

    protected void btnsDisabledEnabled(boolean state) {
        btnSave.setDisable(state);
        btnDelete.setDisable(!state);
        btnUpdate.setDisable(!state);
        btnCancel.setDisable(!state);
    }
    

    protected boolean isNumber(String text){
        try {
            Double.valueOf(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    /**
     * @param nodes bu fonksiyon kendisine gelen nodeleri temizler
     */
    protected void clearNodes(Node... nodes) {
        for (Node node : nodes) {
            if (node instanceof TextField) ((TextField) node).clear();
            if (node instanceof Label) ((Label) node).setText(null);
            if (node instanceof ComboBox) ((ComboBox) node).setValue(null);
        }
    }
    
    
    
    protected void createTableColumn(String cols[],String colsHeader[]) {
        //Col Array
         for (int i = 0; i < cols.length; i++) {
             TableColumn<EntityInterface, String> col = new TableColumn<>(colsHeader[i]);
             col.setCellValueFactory(new PropertyValueFactory<EntityInterface, String>(cols[i]));
             table.getColumns().add(col);
         }
    }

    
    
    
    
    @FXML private void save() {
        btnsDisabledEnabled(false);
        //eğer ad ve soyad boş değilse
        if (isError()) {
            errorMsg();
            return;
        }

        //eğer kaydetme esnasında hata oluşmadıysa
        if (getDAO().save(fromForm()) != null) {
            refreshTable(tablodaGosterilecekListe());
            clearFormFields();
            btnsDisabledEnabled(false);
        }
    }
    
    
    
 
    @FXML private void update() {
        if (isError()) {
            errorMsg();
            return;
        }

        //eğer denetleme esnasında hata oluşmadıysa
        if (getDAO().update(fromForm()) != null) {
            refreshTable(tablodaGosterilecekListe());
            clearFormFields();
            btnsDisabledEnabled(false);
        }
    }

    



    @FXML private void cancel() {
        clearFormFields();
        btnsDisabledEnabled(false);
    }

    
    
    
    
    @FXML private void delete() {
        getDAO().delete(fromForm());
        refreshTable(tablodaGosterilecekListe());
        clearFormFields();
        btnsDisabledEnabled(false);
    }
    
    
    
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {

        createTable();
        ArrayList<EntityInterface> liste=tablodaGosterilecekListe();
        refreshTable(liste);
    }
        
}
