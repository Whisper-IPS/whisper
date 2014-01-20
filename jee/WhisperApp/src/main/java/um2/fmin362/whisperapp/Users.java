package um2.fmin362.whisperapp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */

// ----------------------------------------
// classe pour la création des utilisateurs
// ---------------------------------------


@Entity 
@Table(name = "users") // nom de la table dans la bdd
@XmlRootElement // élément racine du document xml
@NamedQueries({ // requetes nommées
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByPwd", query = "SELECT u FROM Users u WHERE u.pwd = :pwd"),
    @NamedQuery(name = "Users.findByPwdhash", query = "SELECT u FROM Users u WHERE u.pwdhash = :pwdhash"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByUsernameAndPwd", query = "SELECT u FROM Users u WHERE u.username = :username AND u.pwd = :pwd"),
    @NamedQuery(name = "Users.findByURegistration", query = "SELECT u FROM Users u WHERE u.uRegistration = :uRegistration")})
    
public class Users implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
     /* ****************************** */
    /* ***** ATTRIBUTS         ******* */
    /* ****************************** */
    
    @Id // identifiant de la table : attribut porteur de clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // génération de la valeur à partir de l'attribut porteur de clé primaire userId en AUTOINCREMENT.
    @Basic(optional = false) // serialisation de la valeur de l'objet (persistant) + valeur obligatoir de l'attribut
    @Column(name = "user_id") // nom de l'attribut dans la table de la bdd
    private Integer userId;
    
    @Basic(optional = false)
    @NotNull // attribut non null 
    @Size(min = 1, max = 255) // taille de la valeur de l'attribut
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "pwd")
    private String pwd;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "pwdhash")
    private String pwdhash;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    
    @Column(name = "u_registration")
    @Temporal(TemporalType.DATE) // précision : la date.
    private Date uRegistration;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId") // relation liant les tables users et whispers : 1 users pour plusieurs whispers (collection de whispers)
    private Collection<Whispers> whispersCollection;

    
     /* ****************************** */
    /* ***** CONSTRUCTEURS    ******* */
    /* ****************************** */
    public Users() {    }

    public Users(Integer userId) 
    {
        this.userId = userId;
    }

    public Users(Integer userId, String username, String pwd, String pwdhash, String email) 
    {
        this.userId = userId;
        this.username = username;
        this.pwd = pwd;
        this.pwdhash = pwdhash;
        this.email = email;
    }

     /* ****************************** */
    /* ***** ACCESSEURS       ******* */
    /* ****************************** */
    
    public Integer getUserId() 
    {
        return userId;
    }

    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPwd() 
    {
        return pwd;
    }

    public void setPwd(String pwd) 
    {
        this.pwd = pwd;
    }

    public String getPwdhash() 
    {
        return pwdhash;
    }

    public void setPwdhash(String pwdhash) 
    {
        this.pwdhash = pwdhash;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public Date getURegistration() 
    {
        return uRegistration;
    }

    public void setURegistration(Date uRegistration) 
    {
        this.uRegistration = uRegistration;
    }

    @XmlTransient // permet d'ignorer une entité dans le mapping (objets volatils)
    public Collection<Whispers> getWhispersCollection() 
    {
        return whispersCollection;
    }

    public void setWhispersCollection(Collection<Whispers> whispersCollection) 
    {
        this.whispersCollection = whispersCollection;
    }

    
     /* ****************************** */
    /* ***** METHODES           ***** */
    /* ****************************** */
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        if (!(object instanceof Users)) 
        {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return userId + " " + username + " " + pwd + " " + email;
    }
    
}
