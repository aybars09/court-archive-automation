
package login;



import dao.PersonelDAO;
import dao.GroupDao;
import dao.UserDAO;
import model.Group;
import model.User;
import model.Personel;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserDAOTest {
    
    
    UserDAO instance;
    
    public UserDAOTest() {
        instance = new UserDAO();
    }

    
    private User createNewUser(){
        Personel personel=new PersonelDAO().getById(1);
        Group grup=new GroupDao().getById(1);
        return new User("Test", "123", grup, personel);
    }
    
    
    
    
    @Test
    public void testSave() {
        User user=createNewUser();
        //unique değer girilebileceğinden mevcutsa kaydı sil sonra kaydet
        instance.delete(user);
        User result = instance.save(user);
        assertEquals(user, result);
    }

    
    
    
    

    @Test
    public void testUpdate() {
        System.out.println("UPDATE testi");
        User user=createNewUser();
        user.setUserName("Update");
  
        instance.delete(user);
        User result = instance.update(user);

        String expectedUserName = "Update";
        assertEquals(expectedUserName, result.getUserName());
    }
    
    
  
    
    
    

    @Test
    public void testGetALL() throws Exception {
        System.out.println("tüm verileri getir testi");
        assertTrue(instance.getAll().size() > 0);
    }
    
    
}
