
package Test;
import datos.PersonaJDBC;
import domain.Persona;
import java.util.List;


public class TestPersona {
    public static void main(String[] args) {
        
        PersonaJDBC personaJDBC = new PersonaJDBC();
        List<Persona> personas = personaJDBC.select();
        
        for(Persona persona:personas){
            System.out.println("persona: " + persona);
        }
    }
}
