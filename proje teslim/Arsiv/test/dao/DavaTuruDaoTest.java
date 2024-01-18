/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.EntityInterface;
import java.util.ArrayList;
import model.DavaTuru;
import org.junit.Test;
import static org.junit.Assert.*;


public class DavaTuruDaoTest {
    
    public DavaTuruDaoTest() {
    }


    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DavaTuruDao instance = new DavaTuruDao();
        ArrayList<EntityInterface> result = instance.getAll();
        assertTrue(result.size()>0);
    }


    
    
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 1;
        DavaTuruDao instance = new DavaTuruDao();
        DavaTuru result = instance.getById(id);
        assertNotNull(result);

    }
    
}
