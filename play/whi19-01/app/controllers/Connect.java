package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static play.data.Form.*;
import models.*;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import java.util.Map;
import views.html.*;
import java.lang.String;
import play.data.*;
import views.html.login.*;
import models.*;

//controlleur de connexion
public class Connect extends Controller 
{
    
	//formulaire de connexion définit juste à l'aide des attributs de l'interface step1
	final static Form<User>  loginForm = form(User.class, User.Step1.class);
	//affichage du formulaire blanc
	public static Result blank() 
	{
        return ok(form.render(loginForm));
    }
	//déconnexion et redirection
  	public static Result logoff(){
    	session().clear();
		return redirect(routes.Application.index());
	}
	
	//connexion
	    public static Result login() 
	    {
	    	
	    //récupère les infos passées par le formulaire
        Form<User> filledForm = loginForm.bindFromRequest();
        
        
        
        // si pas d'erreurs
        if(!filledForm.hasErrors()) 
        {//si l'username est pas dans la base
            if(User.checkUsername(filledForm.get().getUsername())!=true) 
            {
                filledForm.reject("username", "username introuvable");
            }
        
			//vérification de la concordance entre username et password
			if (User.searchUser(filledForm.get().getUsername(), filledForm.get().getPassword())!=true)
				filledForm.reject("password", "Ce mot de passe ne correspond pas.");
        }
        
		//si le traitement de la connexion comporte des erreurs, on renvoi le formulaire avec les infos
        if(filledForm.hasErrors()) 
        {			
            return badRequest(form.render(filledForm));
        } else 
        {
          
			//sinon on établis la session
			session("connected",filledForm.get().getUsername());
			String user = session("connected");
			return redirect(routes.Application.listTweets(user));
        
		}
  
		}
}
