/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Imha;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blnk
 */
public class ImhaDaoTest {
    
    public ImhaDaoTest() {
    }

    /**
     * Test of getTabloAdi method, of class ImhaDao.
     */
    @Test
    public void testGetTabloAdi() {
        System.out.println("getTabloAdi");
        ImhaDao instance = new ImhaDao();
        String expResult = "";
        String result = instance.getTabloAdi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateIcinSorguStringi method, of class ImhaDao.
     */
    @Test
    public void testUpdateIcinSorguStringi() {
        System.out.println("updateIcinSorguStringi");
        ImhaDao instance = new ImhaDao();
        String expResult = "";
        String result = instance.updateIcinSorguStringi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveIcinSorguStringi method, of class ImhaDao.
     */
    @Test
    public void testSaveIcinSorguStringi() {
        System.out.println("saveIcinSorguStringi");
        ImhaDao instance = new ImhaDao();
        String expResult = "";
        String result = instance.saveIcinSorguStringi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pstUpdateVeSaveIcin method, of class ImhaDao.
     */
    @Test
    public void testPstUpdateVeSaveIcin() throws Exception {
        System.out.println("pstUpdateVeSaveIcin");
        PreparedStatement pst = null;
        Imha entity = null;
        boolean islemUpdateIslemiMi = false;
        ImhaDao instance = new ImhaDao();
        instance.pstUpdateVeSaveIcin(pst, entity, islemUpdateIslemiMi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdIcinSorguStringi method, of class ImhaDao.
     */
    @Test
    public void testGetIdIcinSorguStringi() {
        System.out.println("getIdIcinSorguStringi");
        ImhaDao instance = new ImhaDao();
        String expResult = "";
        String result = instance.getIdIcinSorguStringi();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pstGetIdIcin method, of class ImhaDao.
     */
    @Test
    public void testPstGetIdIcin() throws Exception {
        System.out.println("pstGetIdIcin");
        PreparedStatement pst = null;
        Imha entity = null;
        boolean islemUpdateIslemiMi = false;
        ImhaDao instance = new ImhaDao();
        instance.pstGetIdIcin(pst, entity, islemUpdateIslemiMi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entityDoldur method, of class ImhaDao.
     */
    @Test
    public void testEntityDoldur() {
        System.out.println("entityDoldur");
        ResultSet rs = null;
        ImhaDao instance = new ImhaDao();
        Imha expResult = null;
        Imha result = instance.entityDoldur(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
