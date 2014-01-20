package um2.fmin362.whisperappIT;


import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.MediaType;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static com.eclipsesource.restfuse.Assert.*;

// on test ici que que la creation d'un utilisateur est effectif via la methode POST en se basant sur restfuse (une extension de JUnit pour les tests de services REST ). 
// Errereur retournée (il faudrais renvoyer un body apres la creation d'un utilisateur, cf ci-dessous).

//UserFacadeRESTITCreateTest.testCreateJson:29 Sent request to http://localhost:8080/WhisperApp2/webresources/users
//Response code did mot match expectation:
//Expected 201 (Created) but was 204 (No Content)
//
//10.2.5 204 No Content
//
//The server has fulfilled the request but does not need to return an entity-body, 
//and might want to return updated metainformation. The response MAY include new or 
//updated metainformation in the form of entity-headers, which if present SHOULD be 
//associated with the requested variant.


@RunWith(HttpJUnitRunner.class)
public class UserFacadeRESTITCreateTest {

    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080/WhisperApp/webresources");

    @Context
    private Response response;

    @HttpTest(method = Method.POST, path = "/users", type = MediaType.APPLICATION_JSON, content = "{\"userId\": 14,\"username\": \"testIT\",\"pwd\": \"pwd\",\"pwdhash\": \"pwdhash\",\"email\": \"email@gmail.com\"}")
    

        
    public void testCreateJson() throws Exception {
        assertCreated(response);

        
    }
}


