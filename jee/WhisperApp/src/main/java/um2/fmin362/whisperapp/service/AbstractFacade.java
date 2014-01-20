package um2.fmin362.whisperapp.service;

import java.util.List;
import javax.persistence.EntityManager;
 // EntityManager : interface avec des méthodes pour interagir dans un contexte de persistence.
 // C'est à dire que les données survivent dans la BDD au dela de la session ou de l'application qui les a crée.
 // Par exemple: faire persister, faire des MAJ, supprier, etc. Cad faire des opérations CRUD.
 // EntityManager permet de gérer tout un tas de beans entités nommés persistence unit.

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */


// Classe abstraite qui factorise les méthodes dont nous aurons besoins. 
// Afin de ne pas faire du code redondant. 

public abstract class AbstractFacade<T> 
{
    /**
    *
    * attributs
    * 
    */
    private Class<T> entityClass;

    // récupération d'un Manager d'entités
    protected abstract EntityManager getEntityManager(); 
    
    /**
    *
    * constructeur
    * 
    */
    public AbstractFacade(Class<T> entityClass) 
    {
        this.entityClass = entityClass;
    }

    
    /**
    *
    * méthodes
    * 
    */
    
    // la méthode create, permet de créer une nouvelle entité. 
    // la méthode persist() de getEntityManager, prend en entrée une instance d'entité, l'ajoute au contexte
    // et gère cette dernière. cela permettra de faire plus tard de la MAJ.
    public void create(T entity) 
    {
        getEntityManager().persist(entity);
    }

    // la méthode edit permet de modifier une entité
    // la méthode merge() de getEntityManager, fusionne les informations relative à l'entité passée en 
    // paramètre.
    // en d'autres termes cela fusionne l'état de l'entité donnée dans le contexte de persistance actuelle.
    public void edit(T entity) 
    {
        getEntityManager().merge(entity);
    }

    // la fonction remove permet de supprimer une entité
    // la méthode remove() de getEntityManager supprime l'instance d'entité 
    public void remove(T entity) 
    {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    // la méthode find, retrouve/ récupère une entité par sa clé primaire. 
    // La méthode find de getEntityManager permet de chercher une entité dont la 
    // classe et l'id ont été spécifié en paramètres. si l'instance d'entité est 
    // présente dans le contexte de persistence, alors il est renvoyé.
    public T find(Object id) 
    {
        return getEntityManager().find(entityClass, id);
    }

    // la méthode findAll permet de retourner toutes les instances. 
    // L'interface CriteriaQuery définit les fonctionnalités qui sont spécifiques à des requêtes de haut niveau,
    // avec des classements (ordered), des composants de séléction, des prédicats...
    // le résultat de la requete est retrouné    
    public List<T> findAll() 
    {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

        
}
