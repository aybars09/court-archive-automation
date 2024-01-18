package dao;

import model.Group;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Alt tabakada olup iş yapan katmanlar DAO sınıfları olarak adlandırılır.
 *
 * DAO sınıfımız; Customers tablosuna ait verilerin veritabanına kaydedilmesi,
 * silinmesi, güncellenmesi gibi üst katmanda bulunan kullanıcı arayüzü olan
 * view sınıflarının verdiği görevleri yerine getirir. kısaca projemizdeki dao
 * sınıfları veri tabanıyla view sınıfları arasındaki katmandır diyebiliriz.
 *
 */
public class GroupDao extends DAOAbstract<Group> {
    


    //veri tabanı işlemlerinde kullanılacak olan tablo adı
    @Override
    public String getTabloAdi() {
        return "groupss";
    }
    
    
    

    @Override
    public String saveIcinSorguStringi() {
        return "insert into groupss (grupName) VALUES (?)";
    }

    
            
                    
                    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  groupss  set  grupName=? where id=?";
    }

    
    
    
    
    
    

    @Override
    public Group entityDoldur(ResultSet rs) {
        Group entity=null;
        try {
            entity=new Group();
            entity.setId(rs.getInt("id"));
            entity.setGrupName(rs.getString("grupName"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return entity;
    }

    
    
    

    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, Group entity, boolean islemUpdateIslemiMi) throws SQLException {
        //pst verileri doldur
        pst.setString(1, entity.getGrupName());
        if(islemUpdateIslemiMi)pst.setInt(2, entity.getId());
    }
    
    
    

    
    
    @Override
    public String getIdIcinSorguStringi() {
        return "select * from "+getTabloAdi()+" where grupName=?";
    }

  
    
    
    

    @Override
    public void pstGetIdIcin(PreparedStatement pst, Group entity, boolean islemUpdateIslemiMi) throws SQLException {
        pst.setString(1, entity.getGrupName());
    }

}