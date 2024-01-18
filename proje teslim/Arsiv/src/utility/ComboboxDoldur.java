package utility;


import dao.DAOAbstract;
import model.EntityInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import java.util.List;

public class ComboboxDoldur {



    /**
     * belirtilen Classtaki tüm dataları veritabanından alarak comboboxa yükler
     * @param comboBox yüklemenin yapılacağı combobox
     * @param clazz datalar hangi entitiden çekilecekse o entiti adı
     * @param <T> dataların cinsi Object olmak zorunda EntityInterface olarak girilebilir
     */
    public static <T extends EntityInterface> void comboboxPopulateFromDao(ComboBox<T> comboBox, DAOAbstract<T> dao) {
        List<T> lst =(List<T>) (Object) dao.getAll();
        ObservableList<T> olist = FXCollections.observableArrayList(lst);
        comboBox.getItems().addAll(olist);
    }


    
    
    
    
    /**
     *  T cinsinden verilen valueleri combobox listesine ekler
     * @param comboBox yüklemenin yapılacağı combobox
     * @param datalar yüklenecek datalar ör: Pazartesi,Salı,Çarşamba ....
     * @param <T> dataların cinsi Object olmak zorunda örneğin: String,Integer vs
     */

    @SafeVarargs
    public static <T> void comboboxPopulate(ComboBox<T> comboBox, T... datalar) {
        if (datalar == null) return;
        ObservableList<T> observableList = FXCollections.observableArrayList(datalar);
        comboBox.getItems().setAll(observableList);
    }
}
