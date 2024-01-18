package utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Bu sınıf veritabanı bağlantısını sağlar bağlatı mysql veri tabanı ile yapılacaktır.
 */
public class ConnectionManager {
   
    private Connection connection = null;
    
    
    /**
     * Connetion türünde yeni bir veri tabanı bağlantısı oluşturur. 
     * bu connection ile veri tabanında crud işlemleri gerçekleştirebiliriz.
     * @return 
     */
    private Connection connetToDatabase() {
          Connection connection=null;     
          try{
             connection = DriverManager.getConnection ("jdbc:mysql://localhost/arsiv", "root", "1123");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "veri tabanına bağlanılamadı... hata kodu:" + ex.getMessage());
            System.out.println("veri tabanına bağlanılamadı... hata kodu:" + ex.getMessage());
        }
        return connection;
    }
    
    
    
    /**
     * veritabanı bağlantısını oluşturan veriTabaninaBaglan() metodunu denetler
     * şöyleki bağlantının defalarca oluşturulmasını engellemek için bağlantı talep edildiğinde 
     * eğer bağlantı zaten varsa direk bağlantıyı aksi halde ise 
     * yeni bir bağlantıyı oluşturarak gönderir
     * 
     * @return veri tabanı bağlantısını return eder.
     */
    public Connection getConnection(){
        if(connection==null) connection=connetToDatabase();
        return connection;
    }
    
}
