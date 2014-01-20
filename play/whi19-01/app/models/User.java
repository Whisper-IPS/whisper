package models;

import javax.validation.*;
import play.data.validation.Constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.validation.NotNull;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class User extends Model 
{
   
    public interface All {}
    public interface Step1{}    
	public interface Step2{}    

	//attributs des utilisateurs et mise en place
	//des interfaces qui vont servir à façonner automatiquement
	//les formulaires (avec la division du formulaire entre step1 
	//et step2) et les rentrées en bdd
	@Id
    @Required(groups = {All.class, Step1.class})
    @MinLength(value = 4, groups = {All.class, Step1.class})
    private String username;
    
	//@NotNull
    @Required(groups = {All.class, Step2.class})
    @Email(groups = {All.class, Step1.class})
    @Size(min = 1, max = 50)
    private String email;
    
	@NotNull
    @Required(groups = {All.class, Step1.class})
    @MinLength(value = 6, groups = {All.class, Step1.class})
    private String password;

	
    @Required(groups = {All.class, Step2.class})
    public String country;
    
	@Required(groups = {All.class, Step2.class})
	public String address;
      
	@Required(groups = {All.class, Step2.class})
    @Min(value = 18, groups = {All.class, Step2.class}) @Max(value = 100, groups = {All.class, Step2.class})
    public Integer age;
	
    //constructeurs accesseurs
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User() {}
    
    public User(String username, String email, String password, String country, String address, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
		this.country = country;
        this.address = address;
        this.age = age;
    }
    

	//finder d'user
	public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);

	//tous les utilisateurs
	public static List<User> findAll()
	{
		return find.all();
	}
	
	//sauvegarde d'un utilisateur
	public static void create(User user)
	{
		Ebean.save(user);
	}	
	
	//recherche d'utilisateur et si le mdp correspond
	public static boolean searchUser(String username, String password) {
        if (find.where().eq("username", username).eq("password", password).findUnique()!=null)
			return true;
		else
			return false;
	}
	
	//recherche si l'username est unique et est dans la BDD
	public static boolean checkUsername(String username) {
        if (find.where().eq("username", username).findUnique()!=null)
			return true;
		else
			return false;
	}
	
	
    
}
