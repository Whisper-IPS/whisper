package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.*;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import java.util.Map;
import views.html.*;

//controlleur principal
public class Application extends Controller 
{	
	//formulaire pour l'envoi de tweet
	final static Form<Tweet> tweetForm = Form.form(Tweet.class);
	
	
    public static Result index() 
    {//si un user connecté : redirection vers sa page
	String user = session("connected");
	if (user!=null)
	{
		return redirect(routes.Application.listTweets(user));
		}
    return ok(index.render("Ok."));
    }    
    

    //affichage du mur, imbrication des if else pour les différents affichages du mur
	//selon si on est connecté/pas connecté, si on veut voir notre page/autre page/tous 
        public static Result listTweets(String username)
        {
			List<Tweet> tweets;
			String user = session("connected");
			//si on est pas connecté
			if (user==null){
			//si on veut tous les tweets on passe Anon en username (anonyme) et on définit la liste de tweets
				if (username=="Anon")
					tweets= Tweet.all();
					//Sinon on affiche les tweets de username 
				else
					tweets= Tweet.findByUsername(username);
				//négociation de contenu
				if(request().accepts("text/html"))
						return ok(views.html.externalwall.render(tweets, username, tweetForm));
					else if(request().accepts("application/json"))
						return ok(Json.toJson(tweets));
					else if(request().accepts("application/rdf+xml"))
						return ok("this will be RDF XML");
					return badRequest();

				}
			//si on est connecté
			else {//si on cherche notre page
				if(username.equals(user))
					{//on accede à nos tweets
					tweets= Tweet.findByUsername(user);
					//negociation de contenu
					if(request().accepts("text/html"))
							return ok(views.html.wall.render(tweets, username, tweetForm));
						else if(request().accepts("application/json"))
							return ok(Json.toJson(tweets));
						else if(request().accepts("application/rdf+xml"))
							return ok("this will be RDF XML");
						return badRequest();
					}
				else {//si on veut tous les tweets on passe Anon en username
					if (username=="Anon")
					{
						tweets= Tweet.all();
						}
						
					else//sinon on trouve les tweets d'un autre utilisateur
						tweets= Tweet.findByUsername(username);
						//négociation de contenu
					if(request().accepts("text/html"))
							return ok(views.html.lightwall.render(tweets, user, tweetForm));
						else if(request().accepts("application/json"))
							return ok(Json.toJson(tweets));
						else if(request().accepts("application/rdf+xml"))
							return ok("this will be RDF XML");
						return badRequest();
				}


				}
    	

		}
		
		//on utilise le formulaire et on le remplit avec les valeurs des champs
		public static Result submitTweet()
		{ 
			Tweet tweet = tweetForm.bindFromRequest().get();
			if (tweet.comment==""){return redirect(routes.Application.listTweets(tweet.username));}
		else{
			Tweet.create(tweet);
			tweet.save(); // on fait persister en bdd 
			// si le tweet existe elle le met a jour, sinon l'ajoute dans bdd
			Map<String,String[]> map = request().body().asFormUrlEncoded();
			System.out.println(map.get("username")[0]);
			return redirect(routes.Application.listTweets(tweet.username));
			//on redirige vers le visiteur -- il faudra passer le parametre utilisateur
		}}
			
		//suppression de tweet
	   public static Result delete(Long tweet_id)
		{	//vérifie que l'user qui possède le tweet est connecté et qu'il correspond
			String user = session("connected");
			if(Tweet.find.where().eq("tweet_id", tweet_id).eq("username", user).findUnique()!=null)
				{
				Tweet.find.where().eq("tweet_id", tweet_id).eq("username", user).findUnique().delete();
				}
			return redirect(routes.Application.listTweets(user));
		}
			
		
	
	
}
