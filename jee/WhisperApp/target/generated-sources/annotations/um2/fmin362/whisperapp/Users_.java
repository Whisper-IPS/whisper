package um2.fmin362.whisperapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import um2.fmin362.whisperapp.Whispers;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-20T14:45:59")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> username;
    public static volatile SingularAttribute<Users, String> pwd;
    public static volatile SingularAttribute<Users, Date> uRegistration;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile CollectionAttribute<Users, Whispers> whispersCollection;
    public static volatile SingularAttribute<Users, String> pwdhash;

}