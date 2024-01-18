package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Arsiv;




/**
 * Alt tabakada olup iş yapan katmanlar DAO sınıfları olarak adlandırılır.
 *
 * UserDAO sınıfımız; User tablosuna ait verilerin veritabanına kaydedilmesi,
 * silinmesi, güncellenmesi gibi üst katmanda bulunan kullanıcı arayüzü olan
 * view sınıflarının verdiği görevleri yerine getirir. kısaca projemizdeki dao
 * sınıfları veri tabanıyla view sınıfları arasındaki katmandır diyebiliriz.
 * 
 */
public class ArsivDAO extends DAOAbstract<Arsiv> {
   
  
    @Override
    public String getTabloAdi() {
        return "arsiv";
    }
    
    

 
    

    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  "+getTabloAdi()+"  set   yil=?, geldigiYerId=?, dosyaEsasNo=?,kararNo=?,"
                + "karartarihi=?,kesinlesmeTarihi=?, davaTuruID=?  where id=?";
    }
    
   
    
    
    
    @Override
    public String saveIcinSorguStringi() {
        return "insert into "+getTabloAdi()+" (yil, geldigiYerId, dosyaEsasNo,kararNo,karartarihi,kesinlesmeTarihi,davaTuruID) VALUES (?,?,?,?,?,?,?)";
    }


    

    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, Arsiv entity, boolean islemUpdateIslemiMi) throws SQLException {

        pst.setInt(1, entity.getYil());
        pst.setInt(2, entity.getGeldigiYer().getId());
        pst.setString(3, entity.getDosyaEsasNo());
        pst.setString(4, entity.getKararNo());
        pst.setString(5, entity.getKarartarihi());
        pst.setString(6, entity.getKesinlesmeTarihi());
        pst.setInt(7, entity.getDavaTuru().getId());
        
        if(islemUpdateIslemiMi)
            pst.setInt(8, entity.getId());
    }

  

    
    //hangi bilgiler id için yeterli
    @Override
    public String getIdIcinSorguStringi() {
        return "select * from "+getTabloAdi()+" where dosyaEsasNo=? and kararNo=? and karartarihi=? and geldigiYerId=?";
    }   
    
    
    
    
    
    @Override
    public void pstGetIdIcin(PreparedStatement pst, Arsiv entity, boolean islemUpdateIslemiMi) throws SQLException {
        pst.setString(1, entity.getDosyaEsasNo());
        pst.setString(2, entity.getKararNo());
        pst.setString(3, entity.getKarartarihi());
        pst.setInt(4, entity.getGeldigiYer().getId());
    }
    
     

    
    @Override
    public Arsiv entityDoldur(ResultSet rs) {
        Arsiv tmp=null;
        try {
            tmp=new Arsiv();
            tmp.setId(rs.getInt("id"));
            tmp.setYil(rs.getInt("yil"));
            tmp.setDosyaEsasNo(rs.getString("dosyaEsasNo"));
            tmp.setKararNo(rs.getString("kararNo"));
            tmp.setKarartarihi(rs.getString("karartarihi"));
            tmp.setKesinlesmeTarihi(rs.getString("kesinlesmeTarihi"));
            tmp.setGeldigiYer(new MahkemelerDAO().getById(rs.getInt("geldigiYerId")));
            tmp.setDavaTuru(new DavaTuruDao().getById(rs.getInt("davaTuruID")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return tmp;
    }
}

