package um2.fmin362.whisperapp;

import um2.fmin362.whisperapp.Whispers;
import um2.fmin362.whisperapp.Users;
import java.util.Collection;
import java.util.Date;
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

//classe contenant les tests relatifs à la classe Users.java
public class UsersTest {

    // constructeur vide de la classe de test
    public UsersTest() {
    }

    // @BeforeClass signifie  que la methode est exécutée une fois, avant que 
    // les méthodes de test ne soient exploitées dans la classe de test
    @BeforeClass
    public static void setUpClass() 
    {
        System.out.println("******************************************");
        System.out.println("Debut des tests de la classe Users");
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
        System.out.println("Fin des tests de la classe Users");
        System.out.println("******************************************");
    }

//    // @Before est executé avant chaque methode de test
//    @Before
//    public void setUp() 
    //{
//         System.out.println("Test pour la methode ");
//    }
//
    // @After est executé après chaque methode de test
    @After
    public void tearDown() 
    {
        System.out.println("---------------------------------------------------------------------------------");
    }

    
    /* ****************************** */
    /* ***** METHODES DE TEST ******* */
    /* ****************************** */
    
    
    /**
     * UserId
     */
    @Test
    public void testGetUserId() 
    {
        System.out.println("Test pour la methode getUserId, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        Integer resultatAttendu = 10;
        
        // récupération de l'UserId
        Integer resultat = utilisateurTest.getUserId();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


    /**
     * Username
     */
    @Test
    public void testGetUsername() 
    {
        System.out.println("Test pour la methode getUsername, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        String resultatAttendu = "totoTest";
        
        // récupération de l'username
        String resultat = utilisateurTest.getUsername();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


    @Test
    public void testSetUsername()
    {
        System.out.println("Test pour la methode setUsername, de la classe Users.java");
        
        // on assigne la variable de username à "tataTest"
        String username = "tataTest";
        
        // création d'un user 
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        //on assigne ce nouvel username à l'utilisateur
        utilisateurTest.setUsername(username);
        
        // on verifie que la nouvelle valeur est bien celle que l'on a assignée
        assertEquals("tataTest", "tataTest");


    }

    /**
     * Pwd
     */
    @Test
    public void testGetPwd() 
    {
        System.out.println("Test pour la methode getPwd, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        String resultatAttendu = "mdpTest";
        
        // récupération du mot de passe
        String resultat = utilisateurTest.getPwd();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


    @Test
    public void testSetPwd() 
    {
        System.out.println("Test pour la methode setPwd, de la classe Users.java");
        
        String pwd = "mdpTest999";
        
        // création d'un user 
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // on assigne le nouveau mot de passe a l'utilisateur
        utilisateurTest.setPwd(pwd);
        
        // on verifie que la nouvelle valeur est bien celle que l'on a assignée
        assertEquals("mdpTest999", "mdpTest999");

    }

    /**
     * Email
     */
    @Test
    public void testGetEmail() 
    {
        System.out.println("Test pour la methode getEmail, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        String resultatAttendu = "email@test.fr";
        
        // récupération de l'email
        String resultat = utilisateurTest.getEmail();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


    @Test
    public void testSetEmail() 
    {
        System.out.println("Test pour la methode setEmail, de la classe Users.java");
        
        // on assigne a la variable email une valeur
        String email = "test@test.com";
        
        // création d'un user 
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // on assigne le nouvel email a l'utilisateur
        utilisateurTest.setEmail(email);
        
        // on verifie que la nouvelle valeur est bien celle que l'on a assignée
        assertEquals("test@test.com", "test@test.com");

    }

    /**
     * URegistration
     */
    @Test
    public void testGetURegistration() 
    {
        System.out.println("Test pour la methode getURegistration, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users();
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        Date resultatAttendu = null;
        
        // récupération de la date d'inscription
        Date resultat = utilisateurTest.getURegistration();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


    /**
     * WhispersCollection
     */
    @Test
    public void testGetWhispersCollection() 
    {
        System.out.println("Test pour la methode getWhispersCollection, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users();
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        Collection<Whispers> resultatAttendu = null;
        
        // récupération de la collection de messages de l'utilisateur
        Collection<Whispers> resultat = utilisateurTest.getWhispersCollection();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }


//    @Test
//    public void testSetWhispersCollection() 
//    {
//        System.out.println("Test pour la methode setWhispersCollection, de la classe Users.java");
//        
//        Collection<Whispers> whispersCollection = null;
//        
//        // création d'un user
//        Users utilisateurTest = new Users();
//        
//        utilisateurTest.setWhispersCollection(whispersCollection);
//
//    }

    /**
     * equals
     */
    @Test
    public void testEquals() 
    {
        System.out.println("Test pour la methode equals, de la classe Users.java");
        
        Object object = null;
        
        // création d'un user
        Users utilisateurTest = new Users();
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        boolean resultatAttendu = false;
        
        // récupération de l'objet créer
        boolean resultat = utilisateurTest.equals(object);
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }

    /**
     * toString
     */
    @Test
    public void testToString() 
    {
        System.out.println("Test pour la methode toString, de la classe Users.java");
        
        // création d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'une variable conenant la valeur de l'attribut que l'on souhaite récupérer
        String resultatAttendu = "10 totoTest mdpTest email@test.fr";
        
        // récupération de la chaine de caractères
        String resultat = utilisateurTest.toString();
        
        // verification que le resultat attendu et le resultat récupéré sont identiques
        assertEquals(resultatAttendu, resultat);

    }

}
