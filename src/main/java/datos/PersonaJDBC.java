package datos;

import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaJDBC {
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,mail,telefono) values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona set nombre=?, apellido=?, mail=?, telefono=? WHERE id_persona =?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_perosna=?";
    
    public List<Persona> select(){
        Connection conn = null;
         PreparedStatement stmt =  null;
         ResultSet rs = null;
         
         Persona persona = null;
         List<Persona> personas = new ArrayList<Persona>();
         
            try{
               conn = Conexion.getConnection();
               stmt =  conn.prepareStatement(SQL_SELECT);
               rs = stmt.executeQuery();
               
               while(rs.next()){
                   int id_persona = rs.getInt("id_persona");
                   String nombre = rs.getString("nombre");
                   String apellido = rs.getString("apellido");
                   String mail = rs.getString("mail");
                   String telefono = rs.getString("telefono");
                           
                           persona = new Persona();
                           persona.setId_persona(id_persona);
                           persona.setApellido(apellido);
                           persona.setMail(mail);
                           persona.setTelefono(telefono);
                           personas.add(persona);
               }
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }finally{
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            
            return personas;         
    }
}
