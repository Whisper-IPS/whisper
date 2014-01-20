package models;
import models.*;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.avaje.ebean.Ebean;
import play.data.format.Formats.NonEmpty;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Tweet extends Model
{
	//ATTRIBUTS
	
	//le @Id est unique
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "tweet_id")
	public long tweetId;
	
	@NotNull 
	public String comment;
	
	@JoinColumn(name = "username", referencedColumnName = "username")
	@ManyToOne(optional = false)
	
	public String username;
	
	
	public Date creationDate;
	
	
	
	//METHODES
	//finder
	public static Finder<Long, Tweet> find = new Finder<Long, Tweet>(Long.class, Tweet.class);
	
	//liste de tous les tweets
	public static List<Tweet> all()
	{
		return find.all();
	}
	//liste des tweets d'un user
	public static List<Tweet> findByUsername(String username)
	{
		return find.where().eq("username", username).findList();
	}
	//sauvegarde d'un tweet
	public static Tweet create(Tweet tweet)
	{
		tweet.creationDate = new Date(); 
		tweet.save();
		return tweet;
	}

	
}
