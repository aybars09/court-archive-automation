
package dao;

import model.EntityInterface;
import java.util.ArrayList;
import model.MahkemeTuru;
import org.junit.Test;
import static org.junit.Assert.*;


public class MahkemeTuruDaoTest {
    
    
    
    
    public MahkemeTuruDaoTest() {
    }
    
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        MahkemeTuruDao instance = new MahkemeTuruDao();
        ArrayList<MahkemeTuru> result = instance.getAll();
        
        System.out.println(result.toString());
    }
    
    
    
   @Test
    public void testById() {
        System.out.println("getById");
        MahkemeTuruDao instance = new MahkemeTuruDao();
        EntityInterface result = instance.getById(1);
        
        assertNotNull(result);
    }
    
    
}
