package um2.fmin362.whisperapp.service;

import java.util.Date;
import um2.fmin362.whisperapp.Whispers;
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


@Stateless
@Path("whispers")
public class WhispersFacadeREST extends AbstractFacade<Whispers> 
{
    /* ****************************** */
    /* ***** attribut         ******* */
    /* ****************************** */
    @PersistenceContext(unitName = "WhisperApp_PU")
    private EntityManager em;

    
    /* ****************************** */
    /* ***** constructeur     ******* */
    /* ****************************** */
    public WhispersFacadeREST() 
    {
        super(Whispers.class);
    }

    
    /* ****************************** */
    /* ***** METHODES          ******* */
    /* ****************************** */
    
    
    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Whispers entity) 
    {
        super.create(entity);
    }

    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Whispers entity) 
    {
        Date wRegistration = new Date();
        entity.setWRegistration(wRegistration);
        super.edit(entity);        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) 
    {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Whispers find(@PathParam("id") Integer id) 
    {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Whispers> findAll() 
    {
        return super.findAll();
    }

    
    @Override
    protected EntityManager getEntityManager() 
    {
        return em;
    }
    
    // création d'une liste de messages
    // récupérations des messages de l'utilisateur
    @GET
    @Path("user/{userId}")
    @Produces({"application/xml", "application/json"})
    public List<Whispers> getUserWhispers (@PathParam("userId") int userId) 
    {       
            List ob = em.createNamedQuery("Whispers.findByUserId").setParameter("userId", userId).getResultList();
            return ob;
    }

   
    
}
