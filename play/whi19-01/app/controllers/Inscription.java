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
import play.data.*;
import views.html.signup.*;
import models.*;

//controlleur lors des inscriptions
public class Inscription extends Controller 
{
    
	//définit le formulaire avec toutes les interfaces contenues dans user
    final static Form<User> signupForm = form(User.class, User.All.class);
  
	//affichage du formulaire blanc
    public static Result blank() 
    {
        return ok(form.render(signupForm));
    }
	

  
	//traitement du formulaire
    public static Result submit() 
    {
		//récupération des infos validées par le formulaire
        Form<User> filledForm = signupForm.bindFromRequest();
        
        // si les conditions sont pas acceptées on définit l'erreur
        if(!"true".equals(filledForm.field("accept").value())) 
        {
            filledForm.reject("accept", "Vous devez accepter les termes et conditions d'utilisation.");
        }
        
        // si les deux mdp ne correspondent pas entre eux on le signale
        if(!filledForm.field("password").valueOr("").isEmpty()) 
        {
            if(!filledForm.field("password").valueOr("").equals(filledForm.field("repeatPassword").value())) 
            {
                filledForm.reject("repeatPassword", "Les mots de passe ne sont pas identiques.");
            }
        }
		
		
        // Si l'username est pas valide ou déjà pris on le signale
        if(!filledForm.hasErrors()) {
            if(User.checkUsername(filledForm.get().getUsername())) 
            {
                filledForm.reject("username", "Ce nom d'utilisateur est déjà pris.");
            }
        }
        //si on a signalé une erreur on renvoi le formulaire avec le message d'erreur
        if(filledForm.hasErrors()) 
        {
            return badRequest(form.render(filledForm));
        } else 
        {//sinon on crée l'utilisateur et on le redirige
            User created = filledForm.get();
			User.create(created);
            return ok(summary.render(created));
        }
    }
	
	
	   
  
}
