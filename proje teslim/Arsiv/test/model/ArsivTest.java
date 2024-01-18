
package model;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArsivTest {
    
    Arsiv instance=new Arsiv();
    
    
    @Test
    public void testSetDurumu() {
        System.out.println("setDurumu");
        String durumu = "xx";
        instance.setDurumu(durumu);
        assertEquals("xx", durumu);
    }
    
    
    @Test
    public void testGetDurumu() {
        System.out.println("getDurumu");
        instance.setDurumu("xx");
        String result=instance.getDurumu();
        assertEquals("xx", result);

    }


    


 
    
    @Test
    public void testGetYil() {
        System.out.println("getYil");
        instance.setYil(2021);
        int result=instance.getYil();
        assertEquals(2021, result);
    }


    
    @Test
    public void testSetYil() {
        System.out.println("setYil");
        int yil =2020;
        instance.setYil(yil);
        assertEquals(2020, yil);
    }


    
    @Test
    public void testGetDosyaEsasNo() {
        System.out.println("getDosyaEsasNo");
        instance.setDosyaEsasNo("xx");
        String result=instance.getDosyaEsasNo();
        assertEquals("xx", result);
    }

 
    @Test
    public void testSetDosyaEsasNo() {
        System.out.println("setDosyaEsasNo");
        String result = "xx";
        instance.setDosyaEsasNo(result);
        assertEquals("xx", result);
    }

 
    @Test
    public void testGetKararNo() {
        System.out.println("getKararNo");
        instance.setKararNo("xx");
        String result=instance.getKararNo();
        assertEquals("xx", result);
    }


    @Test
    public void testSetKararNo() {
        System.out.println("setKararNo");
        String result = "xx";
        instance.setKararNo(result);
        assertEquals("xx", result);
    }

    /**
     * Test of getKarartarihi method, of class Arsiv.
     */
    @Test
    public void testGetKarartarihi() {
        System.out.println("getKarartarihi");
         System.out.println("getKararNo");
        instance.setKarartarihi("xx");
        String result=instance.getKarartarihi();
        assertEquals("xx", result);
    }

    /**
     * Test of setKarartarihi method, of class Arsiv.
     */
    @Test
    public void testSetKarartarihi() {
        System.out.println("setKarartarihi");
        String result = "xx";
        instance.setKarartarihi(result);
        assertEquals("xx", result);
    }

    /**
     * Test of getKesinlesmeTarihi method, of class Arsiv.
     */
    @Test
    public void testGetKesinlesmeTarihi() {
        System.out.println("getKesinlesmeTarihi");
        instance.setKesinlesmeTarihi("xx");
        String result=instance.getKesinlesmeTarihi();
        assertEquals("xx", result);
    }

    /**
     * Test of setKesinlesmeTarihi method, of class Arsiv.
     */
    @Test
    public void testSetKesinlesmeTarihi() {
        System.out.println("setKesinlesmeTarihi");
        String result = "xx";
        instance.setKesinlesmeTarihi(result);
        assertEquals("xx", result);
    }

    
}
