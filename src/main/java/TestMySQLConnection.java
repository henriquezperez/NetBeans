import java.sql.*;
import java.sql.DriverManager;
//Kevin Miguel Henriquez Perez      COD: HP0826022019     Fecha: 15-10-2021
public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/aplicada1?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
         try{
             Connection cnx = DriverManager.getConnection(url,"root","");
             Statement instrucion = cnx.createStatement();
             var sql = "select * from persona";
             ResultSet resultado = instrucion.executeQuery(sql);
             while(resultado.next()){
                 System.out.println("Id_Persona: " + resultado.getInt("id_persona"));
                 System.out.println("Persona: " + resultado.getString("nombre"));
                 System.out.println("Apellido: " + resultado.getString("apellido"));
                 System.out.println("Telefono: " + resultado.getString("telefono"));
                 System.out.println("Mail: " + resultado.getString("mail"));
                 System.out.println("--------------------------------------------");
             }
             resultado.close();
             instrucion.close();
             cnx.close();
         }
         catch(SQLException ex){
             ex.printStackTrace(System.out);
             
         }
    }
}
