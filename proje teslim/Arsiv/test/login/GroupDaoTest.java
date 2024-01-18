package login;

import dao.GroupDao;
import model.Group;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroupDaoTest {

    GroupDao instance;

    public GroupDaoTest() {
        instance = new GroupDao();
    }

    
    
    
    @Test
    public void testSave() {
        System.out.println("save testi");
        Group grup = new Group("Admin");
        //unique değer girilebileceğinden mevcutsa sil sonra kaydet
        instance.delete(grup);
        Group result = instance.save(grup);
        assertEquals(grup, result);
    }

    
    
    
    @Test
    public void testSave2() {
        System.out.println("save testi");
        Group grup = new Group("Normal");
        //unique değer girilebileceğinden mevcutsa sil sonra kaydet
        instance.delete(grup);
        Group result = instance.save(grup);
        assertEquals(grup, result);
    }
    
    
    
    

    @Test
    public void testUpdate() {
        System.out.println("UPDATE testi");
        Group grup = new Group("XYZ");

        instance.delete(grup);
        instance.save(grup);
        //update testi başlıyor
        grup.setGrupName("ABC");
        Group result = instance.update(grup);

        String expectedName = "ABC";
        assertEquals(expectedName, result.getGrupName());
    }
    
    
    

    @Test
    public void testDelete() {
        System.out.println("DELETE testi");

        //önce silinecek veriyi oluştur ve kaydet
        Group grup = new Group("XXXX");
        instance.save(grup);

        //sil
        Group result = instance.delete(grup);

        assertNotNull(result);
    }
    
    
    
    

    @Test
    public void testGetALL() throws Exception {
        System.out.println("tüm verileri getir testi");

        assertTrue(instance.getAll().size() > 0);
    }

}
