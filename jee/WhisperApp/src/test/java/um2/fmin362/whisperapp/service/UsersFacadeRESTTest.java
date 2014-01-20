package um2.fmin362.whisperapp.service;

import um2.fmin362.whisperapp.Users;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */

//classe contenant les tests relatifs à la classe UsersFacadeREST.java
public class UsersFacadeRESTTest 
{
    
    private static EJBContainer container;
    
    // constructeur vide de la classe de test
    public UsersFacadeRESTTest() {    }
    
    // @BeforeClass signifie  que la methode est exécutée une fois, avant que 
    // les méthodes de test ne soient exploitées dans la classe de test
    @BeforeClass
    public static void setUpClass() 
    {
        System.out.println("******************************************");
        System.out.println("Debut des tests de la classe UsersFacadeREST");
        System.out.println("******************************************");
        System.out.println("");
    }
    
    // @AfterClass signifie  que la methode est exécutée une fois, apres que 
    // les méthodes de test aient été exploitées dans la classe de test
    @AfterClass
    public static void tearDownClass() 
    {
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("Fin des tests de la classe UsersFacadeREST");
        System.out.println("******************************************");
    }


    // @After est executé après chaque methode de test
    @After
    public void tearDown() 
    {
        System.out.println("---------------------------------------------------------------------------------");
    }
    
    
    /* ****************************** */
    /* ***** METHODES DE TEST ******* */
    /* ****************************** */

//    /**
//     * edit
//     */
//    @Test
//    public void testEdit_GenericType() throws Exception 
//    {
//        System.out.println("Test pour la methode edit, de la classe UsersFacadeREST.java");
//        
//        Users entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        instance.edit(entity);
//        container.close();
//      
//    }

//    /**
//     * remove
//     */
//    @Test
//    public void testRemove_GenericType() throws Exception 
//    {
//        System.out.println("Test pour la methode remove, de la classe UsersFacadeREST.java");
//        Users entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        instance.remove(entity);
//        container.close();
//        
//    }

//    /**
//     * find
//     */
//    @Test
//    public void testFind_Object() throws Exception 
//    {
//        System.out.println("Test pour la methode find, de la classe UsersFacadeREST.java");
//        Object id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        Users expResult = null;
//        Users result = instance.find(id);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }

//    /**
//     * findRange
//     */
//    @Test
//    public void testFindRange_intArr() throws Exception 
//    {
//        System.out.println("Test pour la methode findRange, de la classe UsersFacadeREST.java");
//        int[] range = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        List<Users> expResult = null;
//        List<Users> result = instance.findRange(range);
//        assertEquals(expResult, result);
//        container.close();
//        
//    }

//    /**
//     * count
//     */
//    @Test
//    public void testCount() throws Exception 
//    {
//        System.out.println("Test pour la methode count, de la classe UsersFacadeREST.java");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        int expResult = 0;
//        int result = instance.count();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }

//    /**
//     * create
//     */
//    @Test
//    public void testCreate() throws Exception 
//    {
//        System.out.println("Test pour la methode create, de la classe UsersFacadeREST.java");
//        Users entity = null;
//        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        instance.create(entity);
//        container.close();
//       
//    }

//    /**
//     * edit
//     */
//    @Test
//    public void testEdit_Integer_Users() throws Exception 
//    {
//        System.out.println("Test pour la methode edit, de la classe UsersFacadeREST.java");
//        Integer id = null;
//        Users entity = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        instance.edit(id, entity);
//        container.close();
//        
//    }

//    /**
//     * remove
//     */
//    @Test
//    public void testRemove_Integer() throws Exception 
//    {
//        System.out.println("Test pour la methode remove, de la classe UsersFacadeREST.java");
//        Integer id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        instance.remove(id);
//        container.close();
//        
//    }

//    /**
//     * find
//     */
//    @Test
//    public void testFind_Integer() throws Exception 
//    {
//        System.out.println("Test pour la methode find, de la classe UsersFacadeREST.java");
//        Integer id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        Users expResult = null;
//        Users result = instance.find(id);
//        assertEquals(expResult, result);
//        container.close();
//       
//    }

//    /**
//     * findAll
//     */
//    @Test
//    public void testFindAll() throws Exception 
//    {
//        System.out.println("Test pour la methode findAll, de la classe UsersFacadeREST.java");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        List<Users> expResult = null;
//        List<Users> result = instance.findAll();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }

//    /**
//     * findRange
//     */
//    @Test
//    public void testFindRange_Integer_Integer() throws Exception 
//    {
//        System.out.println("Test pour la methode findRange, de la classe UsersFacadeREST.java");
//        Integer from = null;
//        Integer to = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        List<Users> expResult = null;
//        List<Users> result = instance.findRange(from, to);
//        assertEquals(expResult, result);
//        container.close();
//       
//    }

//    /**
//     * countREST
//     */
//    @Test
//    public void testCountREST() throws Exception 
//    {
//        System.out.println("Test pour la methode countREST, de la classe UsersFacadeREST.java");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        UsersFacadeREST instance = (UsersFacadeREST)container.getContext().lookup("java:global/classes/UsersFacadeREST");
//        String expResult = "";
//        String result = instance.countREST();
//        assertEquals(expResult, result);
//        container.close();
//        
//    }
    
}
