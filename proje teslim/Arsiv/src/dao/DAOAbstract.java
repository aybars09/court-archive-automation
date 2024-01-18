package dao;

import model.EntityInterface;
import model.BaseEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utility.ConnectionManager;

/**
 * Abstrtact sinif olarak yazılan bu sınıf iş yapan katman olan yani view paketindeki
 * viewerlerin crud işlerini yerine getiren dao sınıflarının ortak bir arayüzden
 * üretilmesi ve işlemlerin düzenli olması için yazıldı
 *
 * bütün dao sınıfları DAOAbstract sınıfına extend edeceklerdir
 *
 * @param <T> EntityInterfaceye extend eden siniflar
 */
public abstract class DAOAbstract<T extends EntityInterface> {

    //veritabanı bağlantısını sağlayan değişkendir. 
    //her talep edildiğinde ConnectionManager() sınıfının üretilmemesi için   static ve final olarak oluşturuldu
    public static final Connection baglanti = new ConnectionManager().getConnection();

    
    //siniflarin implemente edecekleri metodlar
    abstract public String getTabloAdi();
    abstract public String saveIcinSorguStringi();
    abstract public String updateIcinSorguStringi();
    abstract public void pstUpdateVeSaveIcin(PreparedStatement pst, T entity, boolean islemUpdateIslemiMi) throws SQLException;
    abstract public String getIdIcinSorguStringi();
    abstract public void pstGetIdIcin(PreparedStatement pst, T entity, boolean islemUpdateIslemiMi) throws SQLException;
    abstract public T entityDoldur(ResultSet rs);
    
    

    
    
    /**
     * veritabanına kaydetme işini yapacak metod
     *
     * @param entity kaydedilecek entity
     * @return eğer kaydetme işlemi başarılı ise entiti başarısız ise null
     */
    public T save(T entity) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement(saveIcinSorguStringi());
            pstUpdateVeSaveIcin(pst, entity, false);
            pst.executeUpdate();
            //entitye id bilgisi veritabanından getiriliyor
            ((BaseEntity) entity).setId(getId(entity));
            return entity;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "when save error occured"  + "\n" + entity.toString() + "\n" + ex.getMessage());
            return null;
        }
    }

    
    
    
    
    public T update(T entity) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement(updateIcinSorguStringi());
            pstUpdateVeSaveIcin(pst, entity, true);
            pst.executeUpdate();
            return entity;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "when update error occured"  + "\n" + entity.toString() + "\n" + ex.getMessage());
            return null;
        }
    }

    
    
    
    
    
    public T delete(T entity) {
        try {
            //baglanti değişkenimiz ile veri tabanına bağlantı kur ve sorguyu çalıştır
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("delete from " + getTabloAdi() + " where id=?");

            //bazen entity id ile yuklü gelir bu durumda id yi aramamak icin
            int entityId = ((BaseEntity) entity).getId();
            pst.setInt(1, entityId > 0 ? entityId : getId(entity));
            
            //sorguyu çalıştır 2 çeşit çalıştırma mevcut 1.executeUpdate: ekle sil güncelle
            pst.executeUpdate();
            return entity;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "when delete error occured"  + "\n" + entity.toString() + "\n" + ex.getMessage());
            return null;
        }
    }

    
    
    
    
    
    //veritabanındaki bir tabloda bulunan bütün kayıtları Array Liste çeker
    public ArrayList<EntityInterface> getAll() {
        ArrayList<EntityInterface> entityList = null;
        try {
            entityList = new ArrayList<>();
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from "+getTabloAdi());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                T entity = entityDoldur(rs);
                entityList.add(entity);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," getAll esnasında hata oluştu tablo veritabanında oluşturulmamış olabilir\n"+ex.getMessage());
        }
        return entityList;
    }

    
    
    
    
    
    public T getById(int id) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from "+getTabloAdi()+" where id=?");
            pst.setInt(1, id);
            //veritabanından alınan verileri tutmak için ResultSet nesnesi kullanılır
            ResultSet rs = pst.executeQuery();

            //eğer aranan veritabanında varsa yani rs'in nexti mevcut ise
            if (rs.next()) {
                //nesne oluşturulup veriler dolduruluyor
                return entityDoldur(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "getById error occured"  + "\n" + id + "\n" + ex.getMessage());
        }
        //aranan bulunmadıysa
        return null;
    }

    
    
    
    
    public int getId(T entity) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement(getIdIcinSorguStringi());
            pstGetIdIcin(pst, entity, false);
            //veritabanından alınan verileri tutmak için ResultSet nesnesi kullanılır
            ResultSet rs = pst.executeQuery();

            //eğer aranan veritabanında varsa yani rs'in nexti mevcut ise
            if (rs.next()) {
                //o zaman id yi al
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "an error occured when getID"  + "\n" + entity.toString() + "\n" + ex.getMessage());
        }
        //aranan bulunmadıysa
        return 0;
    }

}
