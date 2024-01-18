package dao;

import model.EntityInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DavaTuru;
import model.Mahkemeler;

public class DavaTuruDao {

    public ArrayList<EntityInterface> getByMahkeme(Mahkemeler mahkeme) {
        ArrayList<EntityInterface> entityList = null;
        try {
            entityList = new ArrayList<>();
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from davaTuru where mahkemeid=?");
            pst.setInt(1, mahkeme.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                entityList.add(entityDoldur(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " getAll esnasında hata oluştu tablo veritabanında oluşturulmamış olabilir\n" + ex.getMessage());
        }
        return entityList;
    }
    
    public ArrayList<EntityInterface> getAll() {
        ArrayList<EntityInterface> entityList = null;
        try {
            entityList = new ArrayList<>();
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from davaTuru");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                entityList.add(entityDoldur(rs));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " getAll esnasında hata oluştu tablo veritabanında oluşturulmamış olabilir\n" + ex.getMessage());
        }
        return entityList;
    }

    
    
    
    
    
    public DavaTuru getById(int id) {
        try {
            PreparedStatement pst = DAOAbstract.baglanti.prepareStatement("select * from davaturu where id=?");
            pst.setInt(1, id);
            //veritabanından alınan verileri tutmak için ResultSet nesnesi kullanılır
            ResultSet rs = pst.executeQuery();

            //eğer aranan veritabanında varsa yani rs'in nexti mevcut ise
            if (rs.next()) {
                //nesne oluşturulup veriler dolduruluyor
                return entityDoldur(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " getbyID metodunda hata oluştu\n" + ex.getMessage());
        }
        //aranan bulunmadıysa
        return null;
    }

    
    
    
    
    
    
    private DavaTuru entityDoldur(ResultSet rs) throws SQLException {
        DavaTuru entity = null;
        try {
            entity = new DavaTuru();
            entity.setId(rs.getInt("id"));
            entity.setDavaninTuru(rs.getString("davaninTuru"));
            entity.setImhaSuresi(rs.getInt("imhaSuresi"));
            entity.setMahkeme(new MahkemelerDAO().getById(rs.getInt("mahkemeID")));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "veritabanindaki kolon adi yanlış yazılmış.\n" + ex.getMessage());
        }
        return entity;

    }
}
