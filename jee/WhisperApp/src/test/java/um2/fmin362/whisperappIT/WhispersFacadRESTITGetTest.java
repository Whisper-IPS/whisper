package um2.fmin362.whisperappIT;

import static com.eclipsesource.restfuse.Assert.assertOk;

import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;

// on test ici que que l'appele de findall via get est effectif se basant sur restfuse (une extension de JUnit pour les tests de services REST ). 
// Errereur retournée (il faudrais renvoyer un body apres la creation d'un utilisateur, cf ci-dessous).

// Fonctionnelle renvoie bien Expected 201

@RunWith(HttpJUnitRunner.class)
public class WhispersFacadRESTITGetTest {

    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080/WhisperApp/webresources");

    @Context
    private Response response;

    @HttpTest(method = Method.GET, path = "/whispers")
    public void testGetJson() {
        assertOk(response);
    }

}





