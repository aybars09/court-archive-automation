package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Mahkemeler;




/**
 * Alt tabakada olup iş yapan katmanlar DAO sınıfları olarak adlandırılır.
 *
 * UserDAO sınıfımız; User tablosuna ait verilerin veritabanına kaydedilmesi,
 * silinmesi, güncellenmesi gibi üst katmanda bulunan kullanıcı arayüzü olan
 * view sınıflarının verdiği görevleri yerine getirir. kısaca projemizdeki dao
 * sınıfları veri tabanıyla view sınıfları arasındaki katmandır diyebiliriz.
 * 
 */
public class MahkemelerDAO extends DAOAbstract<Mahkemeler> {
   
  
    @Override
    public String getTabloAdi() {
        return "mahkemeler";
    }
    

    

    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  "+getTabloAdi()+"  set  adi=?, turuID=? where id=?";
    }
    
   
       
    
    
    @Override
    public String saveIcinSorguStringi() {
        return "insert into "+getTabloAdi()+" (adi, turuID) VALUES (?,?)";
    }

    
    
    
    

    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, Mahkemeler entity, boolean islemUpdateIslemiMi) throws SQLException {

        pst.setString(1, entity.getAdi());
        pst.setInt(2, entity.getMahkemeTuru().getId());

       
        if(islemUpdateIslemiMi)
            pst.setInt(3, entity.getId());
    }

    
    
    
    @Override
    public String getIdIcinSorguStringi() {
        return "select * from "+getTabloAdi()+" where adi=? and turuID=?";
    }   
    
    
    
    
    
    @Override
    public void pstGetIdIcin(PreparedStatement pst, Mahkemeler entity, boolean islemUpdateIslemiMi) throws SQLException {
        pst.setString(1, entity.getAdi());
        pst.setInt(2, entity.getMahkemeTuru().getId());
    }
    
     
    
    
    @Override
    public Mahkemeler entityDoldur(ResultSet rs) {
        Mahkemeler tmp=null;
        try {
            tmp=new Mahkemeler();
            tmp.setId(rs.getInt("id"));
            tmp.setAdi(rs.getString("adi"));
            tmp.setMahkemeTuru(new MahkemeTuruDao().getById(rs.getInt("turuID")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return tmp;
    }
}

