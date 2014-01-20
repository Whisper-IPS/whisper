package um2.fmin362.whisperapp.service;

import um2.fmin362.whisperapp.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */

// --------------------------------------------------------------------------------------
// Classe fille de "AbstractFacade", qui redéfinie les méthodes relatives à l'utilisateur
// --------------------------------------------------------------------------------------


//composant défini pour un bean sans état : application en REST
@Stateless
//définition du chemin de l'url
@Path("users")
public class UsersFacadeREST extends AbstractFacade<Users> 
{
    
    
    /* ****************************** */
    /* ***** attribut         ******* */
    /* ****************************** */
    // Exprime une dépendance à un contexte de persistance EntityManager
    // en donnant un nom à l'unité de persistence.
    @PersistenceContext(unitName = "WhisperApp_PU")
    private EntityManager em;

    
    
    /* ****************************** */
    /* ***** constructeur     ******* */
    /* ****************************** */
    public UsersFacadeREST() 
    {
        super(Users.class);
    }


    /* ****************************** */
    /* ***** METHODES          ******* */
    /* ****************************** */
    
    
    @Override // héritage : redéfiniton de méthode
    protected EntityManager getEntityManager() 
    {
        return em;
    }
    
        
    @POST // traitement par la méthode http POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) 
    {
        super.create(entity);
    }

    @PUT // traitement par la méthode http PUT
    @Path("{id}") // chemin URI relatif
    @Consumes({"application/xml", "application/json"}) // spécifie les types multimédia MIME pour la représentation d'une ressource peut utiliser : XML ou JSON ici
    public void edit(@PathParam("id") Integer id, Users entity) 
    {
        super.edit(entity);
    }

    @DELETE // traitement par la méthode http DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) 
    {
        super.remove(super.find(id));
    }

    @GET // traitement par la méthode http GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"}) // spécifie les les types multimédia MIME qui peuvent être produits par la ressource
    public Users find(@PathParam("id") Integer id) 
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() 
    {
        return super.findAll();
    }

    
    // méthode de récupération de l'ID de l'user pour le login
    @GET
    @Path("{username}/{pwd}")
    @Produces("text/plain")
    public String getLoginId(@PathParam("username") String username, @PathParam("pwd") String pwd) 
    {
        String userId = "0"; // initialisation 
        try 
        {   // requete + récupération résultat de la requete pour avoir infos de l'utilisateur
            Object ob = em.createNamedQuery("Users.findByUsernameAndPwd").setParameter("username", username).setParameter("pwd", pwd).getSingleResult(); 
            Users user = (Users) ob;
            userId = user.getUserId().toString();// récupération e l'userID
        } 
        catch (Exception e) // récupération de l'erreur: envoie message d'erreur standard
        {
            e.getMessage();
        } 
        finally // traitement : on renvoie id
        {
            return userId;
        }
    }
    
}
