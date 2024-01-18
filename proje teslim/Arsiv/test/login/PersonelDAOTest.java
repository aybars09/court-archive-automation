
package login;


import dao.PersonelDAO;
import model.Personel;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonelDAOTest {
   
    PersonelDAO instance;

    public PersonelDAOTest() {
        instance = new PersonelDAO();
    }

    
    
    
    @Test
    public void testSave() {
        System.out.println("save testi");
        Personel personel=new Personel("74614523611","Fatma GECDOGDU","05/04/2004","Proje Test Birimi");
        //unique değer girilebileceğinden mevcutsa sil sonra kaydet
        instance.delete(personel);
        Personel result = instance.save(personel);
        assertEquals(personel, result);
    }

    
    
    
    @Test
    public void testSave2() {
        System.out.println("save testi");
        Personel personel=new Personel("10214523644","Ahmet YILDIZ","05/04/1996","Proje Test Birimi");
        //unique değer girilebileceğinden mevcutsa sil sonra kaydet
        instance.delete(personel);
        Personel result = instance.save(personel);
        assertEquals(personel, result);
    }
    
    
    
    

    @Test
    public void testUpdate() {
        System.out.println("UPDATE testi");
        Personel personel=new Personel("00000000001","xxxx YILDIZ_2","05/04/1996","");

        //eğer kayıt zaten varsa silelim ve kaydedelim
        instance.delete(personel);
        personel=instance.save(personel);
        
        //update için veri ayarla
        personel.setTcNo("11111111111");
        personel.setAdSoyad("ABC ABC");
        personel.setdTArihi("3-2-2001");
        instance.delete(personel);
        Personel result = instance.update(personel);

        String expectedName = "ABC ABC";
        assertEquals(expectedName, result.getAdSoyad());
    }
    
    
    

    @Test
    public void testDelete() {
        System.out.println("DELETE testi");

        //önce silinecek veriyi oluştur ve kaydet
        Personel personel=new Personel("88888888888","a a","05/04/1996","Proje Test Birimi");
        instance.save(personel);

        //sil
        Personel result = instance.delete(personel);

        assertNotNull(result);
    }
    
    
    
    

    @Test
    public void testGetALL() throws Exception {
        System.out.println("tüm verileri getir testi");

        assertTrue(instance.getAll().size() > 0);
    }

}
