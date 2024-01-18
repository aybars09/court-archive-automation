package dao;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;




/**
 * Alt tabakada olup iş yapan katmanlar DAO sınıfları olarak adlandırılır.
 *
 * UserDAO sınıfımız; User tablosuna ait verilerin veritabanına kaydedilmesi,
 * silinmesi, güncellenmesi gibi üst katmanda bulunan kullanıcı arayüzü olan
 * view sınıflarının verdiği görevleri yerine getirir. kısaca projemizdeki dao
 * sınıfları veri tabanıyla view sınıfları arasındaki katmandır diyebiliriz.
 * 
 */
public class UserDAO extends DAOAbstract<User> {
   
  
    @Override
    public String getTabloAdi() {
        return "users";
    }
    
    
    
    
    public User isHave(String userName, String password) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from "+getTabloAdi()+" where userName=? and password=?");
            pst.setString(1, userName);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) return entityDoldur(rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "kullanici aranirken hata olustu.\n"+ex.getMessage());
        }
         return null;
    }
 
    

    
    
    @Override
    public String updateIcinSorguStringi() {
        return "update  "+getTabloAdi()+"  set  userName=?, password=?, groupsID=?, aitOldKisiID=? where id=?";
    }
    
   
    
    
    
    @Override
    public String saveIcinSorguStringi() {
        return "insert into "+getTabloAdi()+" (userName, password, groupsID, aitOldKisiID) VALUES (?,?,?,?)";
    }

    
    
    
    

    @Override
    public void pstUpdateVeSaveIcin(PreparedStatement pst, User entity, boolean islemUpdateIslemiMi) throws SQLException {

        pst.setString(1, entity.getUserName());
        pst.setString(2, entity.getPassword());
        pst.setInt(3, entity.getGroups().getId());
        pst.setInt(4, entity.getPers().getId());
       
        if(islemUpdateIslemiMi)
            pst.setInt(5, entity.getId());
    }

    
    
    
    @Override
    public String getIdIcinSorguStringi() {
        return "select * from "+getTabloAdi()+" where aitOldKisiID=?";
    }   
    
    
    
    
    
    @Override
    public void pstGetIdIcin(PreparedStatement pst, User entity, boolean islemUpdateIslemiMi) throws SQLException {
        pst.setInt(1, entity.getPers().getId());
    }
    
     
    
    
    @Override
    public User entityDoldur(ResultSet rs) {
        User tmp=null;
        try {
            tmp=new User();
            tmp.setId(rs.getInt("id"));
            tmp.setUserName(rs.getString("userName"));
            tmp.setPassword(rs.getString("password"));
            tmp.setGroups(new GroupDao().getById(rs.getInt("groupsID")));
            tmp.setPers(new PersonelDAO().getById(rs.getInt("aitOldKisiID")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n"+ex.getMessage());
        }
        return tmp;
    }
}

