package dao;

import model.Personel;
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
public class PersonelDAO extends DAOAbstract<Personel> {
    
    
    //veri tabanı işlemlerinde kullanılacak olan tablo adı
    @Override
    public String getTabloAdi() {
        return "personel";
    }

    
    
    @Override
    public Personel entityDoldur(ResultSet rs) {
        Personel entity=null;
        try {
            entity=new Personel();
            entity.setId(rs.getInt("id"));
            entity.setAdSoyad(rs.getString("adsoyad"));
            entity.setCalistigiBirim(rs.getString("calistigibirim"));
            entity.setTcNo(rs.getString("tcno"));
            entity.setdTArihi(rs.getString("dtarihi"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return entity;
    }
    
    
    
    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  "+getTabloAdi()+"  set  adsoyad=?, dtarihi=?,  tcno=?, calistigibirim=? where id=?";
    }

    
    
    @Override
    public String saveIcinSorguStringi() {
        return "insert into "+getTabloAdi()+" (adsoyad, dtarihi, tcno, calistigibirim) VALUES (?,?,?,?)";
    }   
    
    
    
    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, Personel entity, boolean islemUpdateIslemiMi) throws SQLException {
        //pst verileri doldur
        pst.setString(1, entity.getAdSoyad());
        pst.setString(2, entity.getdTArihi());
        pst.setString(3, entity.getTcNo());
        pst.setString(4, entity.getCalistigiBirim());

        if(islemUpdateIslemiMi)
            pst.setInt(5, entity.getId());
    }


    @Override
    public String getIdIcinSorguStringi() {
         return "select * from "+getTabloAdi()+" where tcno=? and adsoyad=?";
    }

    @Override
    public void pstGetIdIcin(PreparedStatement pst, Personel entity, boolean islemUpdateIslemiMi) throws SQLException {
        //pst verileri doldur
        pst.setString(1, entity.getTcNo());
        pst.setString(2, entity.getAdSoyad());

        if(islemUpdateIslemiMi)
            pst.setInt(5, entity.getId());
    }
}