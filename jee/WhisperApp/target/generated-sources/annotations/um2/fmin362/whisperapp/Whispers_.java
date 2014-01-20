package um2.fmin362.whisperapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import um2.fmin362.whisperapp.Users;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-20T14:45:59")
@StaticMetamodel(Whispers.class)
public class Whispers_ { 

    public static volatile SingularAttribute<Whispers, String> whisper;
    public static volatile SingularAttribute<Whispers, Date> wRegistration;
    public static volatile SingularAttribute<Whispers, Integer> whisperId;
    public static volatile SingularAttribute<Whispers, Users> userId;

}