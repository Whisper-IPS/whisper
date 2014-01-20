package um2.fmin362.whisperapp.service;

import java.util.Set;
import javax.ws.rs.core.Application;
// la classe application définit les composants d'une application JAX-RS et fournit
// des métadonnées supplémentaires. 

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */

// définition du chemin de l'application
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application 
{

    @Override
    public Set<Class<?>> getClasses() 
    {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    // Cette methode est auto-peuplée avec ttes les ressources definies dans le projet. 
    private void addRestResourceClasses(Set<Class<?>> resources) 
    {
        resources.add(um2.fmin362.whisperapp.service.UsersFacadeREST.class);
        resources.add(um2.fmin362.whisperapp.service.WhispersFacadeREST.class);
    }
    
}
