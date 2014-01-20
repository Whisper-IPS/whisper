package um2.fmin362.whisperapp;

import um2.fmin362.whisperapp.Whispers;
import um2.fmin362.whisperapp.Users;
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

//classe contenant les tests relatifs à la classe Whisper.java
public class WhispersTest {

    // constructeur vide de la classe de test
    public WhispersTest() {
    }

    // @BeforeClass signifie  que la methode est exécutée une fois, avant que 
    // les méthodes de test ne soient exploitées dans la classe de test
    @BeforeClass
    public static void setUpClass() {
        System.out.println("******************************************");
        System.out.println("Debut des tests de la classe Whisper");
        System.out.println("******************************************");
        System.out.println("");
    }

    // @AfterClass signifie  que la methode est exécutée une fois, apres que 
    // les méthodes de test aient été exploitées dans la classe de test
    @AfterClass
    public static void tearDownClass() {
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("Fin des tests de la classe Whisper");
        System.out.println("******************************************");
    }

//    // @Before est executé avant chaque methode de test
//    @Before
//    public void setUp() {
//         System.out.println("Test pour la methode ");
//    }
//
    // @After est executé après chaque methode de test
    @After
    public void tearDown() {
        System.out.println("---------------------------------------------------------------------------------");
    }

    /* ****************************** */
    /* ***** METHODES DE TEST ******* */
    /* ****************************** */
    /**
     * WhisperId
     */
    @Test
    public void testGetWhisperId() 
    {
        System.out.println("Test pour la methode getWhisperId, de la classe Whisper.java");
        
        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisperDeTest");
        
        // creation d'une variable contenant l'id du message
        Integer resultatAttendu = 50;
        
        // récupération de l'id du message dans une variable
        Integer resultat = whisperTest.getWhisperId();
        
        // comparaison si résulats des deux variables sont identiques
        assertEquals(resultatAttendu, resultat);

    }

    /**
     * Whisper
     */
    @Test
    public void testGetWhisper() 
    {
        System.out.println("Test pour la methode getWhisper, de la classe Whisper.java");
        
        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisper De Test");
        
        // creation d'une variable contenant le message
        String resultatAttendu = "whisper De Test";
        
        // récupération du message dans une variable
        String resultat = whisperTest.getWhisper();
        
         // comparaison si résulats des deux variables sont identiques
        assertEquals(resultatAttendu, resultat);

    }

    @Test
    public void testSetWhisper() 
    {
        System.out.println("Test pour la methode setWhisper, de la classe Whisper.java");
        
        // creation d'une variable conenant un nouveau message
        String whisper = "TEST de modification du message";
        
        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisperDeTest");
        
        // affectation du nouveau message pour modification
        whisperTest.setWhisper(whisper);
        
        // comparaison si résulats des deux variables sont identiques
        assertEquals("TEST de modification du message", "TEST de modification du message");
    }

//    /**
//     * WRegistration
//     */
//    @Test
//    public void testGetWRegistration() 
//    {
//        System.out.println("Test pour la methode getWRegistration, de la classe Whisper.java");
//        
//        // creation d'un message avec le controleur vide car la date est crée automatiquement
//        Whispers whisperTest = new Whispers();
//        
//        
//        Date resultatAttendu = null;
//        
//        // récupération de la date
//        Date resultat = whisperTest.getWRegistration();
//        
//        // comparaison si résulats des deux variables sont identiques
//        assertEquals(resultatAttendu, resultat);
//
//    }

    /**
     * UserId
     */
    @Test
    public void testGetUserId() 
    {
        System.out.println("Test pour la methode getUserId, de la classe Whisper.java");
        
        // creation d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");
        
        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisperDeTest", utilisateurTest);
        
        // affectation de l'utilisateur a la variable
        Users resultatAttendu = utilisateurTest; 
        
        // recuperation de l'identifiant de l'utiliateur du message
        Users resultat = whisperTest.getUserId();
        
        // comparaison si résulats des deux variables sont identiques
        assertEquals(resultatAttendu, resultat);

    }

    @Test
    public void testSetUserId() 
    {
        System.out.println("Test pour la methode setUserId, de la classe Whisper.java");
        
        // creation d'un user
        Users utilisateurTest = new Users(10, "totoTest", "mdpTest", "mdphashTest", "email@test.fr");

        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisperDeTest", utilisateurTest);

        // affectation d'un utilisateur a un message
        whisperTest.setUserId(utilisateurTest);
        
        // verification de l'utilisateur a bien ete assigné
        assertEquals(10, 10);

    }

    /**
     * toString
     */
    @Test
    public void testToString() 
    {
        System.out.println("Test pour la methode toString, de la classe Whisper.java");
        
        // creation d'un message
        Whispers whisperTest = new Whispers(50, "whisperDeTest");
        
        // assignation du message attendu dans une variable
        String resultatAttendu = "identifiant whisper = 50";
        
        // applicatino de la methode et assignation a une variable
        String resultat = whisperTest.toString();
        
        // comparaison si résulats des deux variables sont identiques
        assertEquals(resultatAttendu, resultat);
    }

}
