
package utility;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectionManagerTest {
    
    public ConnectionManagerTest() {
    }

 
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        ConnectionManager instance = new ConnectionManager();
        Connection result = instance.getConnection();
        assertNotNull("bağlantı sağlantı", result);
    }
    
}
