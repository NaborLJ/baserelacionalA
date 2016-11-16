
package baserelacionala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaserelacionalA {
    
  
   
    public static void main(String[] args) throws SQLException {
        Metodos aux = new Metodos();
        aux.conexion();
        aux.listaProdutos();
        aux.cerrarconexion();
    }
    
}
