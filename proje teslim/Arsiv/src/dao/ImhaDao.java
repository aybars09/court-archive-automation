package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Imha;




/**
 * Alt tabakada olup iş yapan katmanlar DAO sınıfları olarak adlandırılır.
 *
 * UserDAO sınıfımız; User tablosuna ait verilerin veritabanına kaydedilmesi,
 * silinmesi, güncellenmesi gibi üst katmanda bulunan kullanıcı arayüzü olan
 * view sınıflarının verdiği görevleri yerine getirir. kısaca projemizdeki dao
 * sınıfları veri tabanıyla view sınıfları arasındaki katmandır diyebiliriz.
 * 
 */
public class ImhaDao extends DAOAbstract<Imha> {
   
  
    @Override
    public String getTabloAdi() {
        return "imha_personel";
    }
    

    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  "+getTabloAdi()+"  set   arsivId=?, persId=?, imhaTarihi=?   where id=?";
    }
    
   
    
    
    
    @Override
    public String saveIcinSorguStringi() {
        return "insert into "+getTabloAdi()+" (arsivId, persId, imhaTarihi) VALUES (?,?,?)";
    }


    

    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, Imha entity, boolean islemUpdateIslemiMi) throws SQLException {

        pst.setInt(1, entity.getArsiv().getId());
        pst.setInt(2, entity.getPers().getId());
        pst.setString(3, entity.getDate());
   
        
        if(islemUpdateIslemiMi)
            pst.setInt(4, entity.getId());
    }

  

    
    //hangi bilgiler id için yeterli
    @Override
    public String getIdIcinSorguStringi() {
        return "select * from "+getTabloAdi()+" where arsivId=? and persId=? and imhaTarihi=?";
    }   
    
    
    
    
    
    @Override
    public void pstGetIdIcin(PreparedStatement pst, Imha entity, boolean islemUpdateIslemiMi) throws SQLException {
        pst.setInt(1, entity.getArsiv().getId());
        pst.setInt(2, entity.getPers().getId());
        pst.setString(3, entity.getDate());
    }
    
     

    
    @Override
    public Imha entityDoldur(ResultSet rs) {
        Imha tmp=null;
        try {
            tmp=new Imha();
            tmp.setId(rs.getInt("id"));
    
            tmp.setDate(rs.getString("imhaTarihi"));
            tmp.setArsiv(new ArsivDAO().getById(rs.getInt("arsivId")));
            tmp.setPers(new PersonelDAO().getById(rs.getInt("persId")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return tmp;
    }
}

