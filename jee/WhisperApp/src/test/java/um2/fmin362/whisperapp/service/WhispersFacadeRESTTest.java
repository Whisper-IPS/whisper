package um2.fmin362.whisperapp.service;

//package com.mycompany.whisperapp.service;
//
//import com.mycompany.whisperapp.Whispers;
//import java.util.List;
//import javax.ejb.embeddable.EJBContainer;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author mathieu moreno, marion cardinale, patrick boussier
// * 
// */
//
//public class WhispersFacadeRESTTest {
//    
//    public WhispersFacadeRESTTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of edit method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testEdit_GenericType() throws Exception {
//        System.out.println("edit");
//        Whispers entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        instance.edit(entity);
//        container.close();
//        
//    }
//
//    /**
//     * Test of remove method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testRemove_GenericType() throws Exception {
//        System.out.println("remove");
//        Whispers entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        instance.remove(entity);
//        container.close();
//        
//    }
//
//    /**
//     * Test of find method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testFind_Object() throws Exception {
//        System.out.println("find");
//        Object id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        Whispers expResult = null;
//        Whispers result = instance.find(id);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of findRange method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testFindRange_intArr() throws Exception {
//        System.out.println("findRange");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        List<Whispers> expResult = null;
//        List<Whispers> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of count method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testCount() throws Exception {
//        System.out.println("count");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of create method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        Whispers entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        instance.create(entity);
//        container.close();
//        
//    }
//
//    /**
//     * Test of edit method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testEdit_Integer_Whispers() throws Exception {
//        System.out.println("edit");
//        Integer id = null;
//        Whispers entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        instance.edit(id, entity);
//        container.close();
//        
//    }
//
//    /**
//     * Test of remove method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testRemove_Integer() throws Exception {
//        System.out.println("remove");
//        Integer id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        instance.remove(id);
//        container.close();
//        
//    }
//
//    /**
//     * Test of find method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testFind_Integer() throws Exception {
//        System.out.println("find");
//        Integer id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        Whispers expResult = null;
//        Whispers result = instance.find(id);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of findAll method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        List<Whispers> expResult = null;
//        List<Whispers> result = instance.findAll();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of findRange method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testFindRange_Integer_Integer() throws Exception {
//        System.out.println("findRange");
//        Integer from = null;
//        Integer to = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        List<Whispers> expResult = null;
//        List<Whispers> result = instance.findRange(from, to);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//
//    /**
//     * Test of countREST method, of class WhispersFacadeREST.
//     */
//    @Test
//    public void testCountREST() throws Exception {
//        System.out.println("countREST");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        WhispersFacadeREST instance = (WhispersFacadeREST)container.getContext().lookup("java:global/classes/WhispersFacadeREST");
//        String expResult = "";
//        String result = instance.countREST();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
//    
//}
