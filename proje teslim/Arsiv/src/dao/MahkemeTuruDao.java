package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.MahkemeTuru;



public class MahkemeTuruDao {

    public ArrayList<MahkemeTuru> getAll() {
        ArrayList<MahkemeTuru> entityList = null;
        try {
            entityList = new ArrayList<>();
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from mahkemeturu");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MahkemeTuru entity = new MahkemeTuru();
                entity.setId(rs.getInt("id"));
                entity.setMahkemeTuru(rs.getString("MahkemeTuru"));
                entityList.add(entity);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " getAll esnasında hata oluştu tablo veritabanında oluşturulmamış olabilir\n" + ex.getMessage());
        }
        return entityList;
    }
    
    
    
    public MahkemeTuru getById(int id) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from mahkemeturu where id=?");
            pst.setInt(1, id);
            //veritabanından alınan verileri tutmak için ResultSet nesnesi kullanılır
            ResultSet rs = pst.executeQuery();

            //eğer aranan veritabanında varsa yani rs'in nexti mevcut ise
            if (rs.next()) {
                //nesne oluşturulup veriler dolduruluyor
                MahkemeTuru entity = new MahkemeTuru();
                entity.setId(rs.getInt("id"));
                entity.setMahkemeTuru(rs.getString("MahkemeTuru"));
                return entity;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " getbyID metodunda hata oluştu\n" + ex.getMessage());
        }
        //aranan bulunmadıysa
        return null;
    }
}
