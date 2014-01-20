package um2.fmin362.whisperapp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mathieu moreno, marion cardinale, patrick boussier
 * 
 */
// ----------------------------------------
// classe pour la création des messages
// ---------------------------------------


@Entity
@Table(name = "whispers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Whispers.findAll", query = "SELECT w FROM Whispers w"),
    @NamedQuery(name = "Whispers.findByUserId", query = "SELECT w FROM Whispers w WHERE w.userId.userId = :userId"),
    @NamedQuery(name = "Whispers.findByWhisperId", query = "SELECT w FROM Whispers w WHERE w.whisperId = :whisperId"),
    @NamedQuery(name = "Whispers.findByWhisper", query = "SELECT w FROM Whispers w WHERE w.whisper = :whisper"),
    @NamedQuery(name = "Whispers.findByWRegistration", query = "SELECT w FROM Whispers w WHERE w.wRegistration = :wRegistration")})
public class Whispers implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
     /* ****************************** */
    /* ***** ATTRIBUTS          ******* */
    /* ****************************** */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "whisper_id")
    private Integer whisperId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "whisper")
    private String whisper;
    
    @Column(name = "w_registration")
    @Temporal(TemporalType.TIMESTAMP) // precision : milliseconde
    private Date wRegistration;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") // jointure inter-tables sur l'user_id
    @ManyToOne(optional = false) // plusieurs messages sont liés à 1 utilisateur - attribut obligatoire
    private Users userId;

     /* ****************************** */
    /* ***** CONSTRUCTEURS    ******* */
    /* ****************************** */
    
    public Whispers() {
        this.wRegistration = new Date();
    }

    public Whispers(Integer whisperId) 
    {
        this.whisperId = whisperId;
        this.wRegistration = new Date();
    }

    public Whispers(Integer whisperId, String whisper) 
    {
        this.whisperId = whisperId;
        this.whisper = whisper;
        this.wRegistration = new Date();
    }

    public Whispers(Integer whisperId, String whisper, Users userId) 
    {
        this.whisperId = whisperId;
        this.whisper = whisper;
        this.userId = userId;
    }
    


     /* ****************************** */
    /* ***** ACCESSEURS        ******* */
    /* ****************************** */
    
    public Integer getWhisperId() 
    {
        return whisperId;
    }

    public void setWhisperId(Integer whisperId) 
    {
        this.whisperId = whisperId;
    }

    public String getWhisper() 
    {
        return whisper;
    }

    public void setWhisper(String whisper) 
    {
        this.whisper = whisper;
    }

    public Date getWRegistration() 
    {
        return wRegistration;
    }

    public void setWRegistration(Date wRegistration) 
    {
        this.wRegistration = wRegistration;
    }

    public Users getUserId() 
    {
        return userId;
    }

    public void setUserId(Users userId) 
    {
        this.userId = userId;
    }

    
     /* ****************************** */
    /* ***** METHODES          ******* */
    /* ****************************** */ 
    
    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (whisperId != null ? whisperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Whispers)) {
            return false;
        }
        Whispers other = (Whispers) object;
        if ((this.whisperId == null && other.whisperId != null) || (this.whisperId != null && !this.whisperId.equals(other.whisperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return "identifiant whisper = " + whisperId ;

    }
    
}
