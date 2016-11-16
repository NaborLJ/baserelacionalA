/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baserelacionala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oracle
 */
public class Metodos {

    Connection conn = null;
    String tabla, nomColumna, valores;

    public void conexion() throws SQLException {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain";
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
        conn = DriverManager.getConnection(url);

    }

    public void cerrarconexion() throws SQLException {
        conn.close();

    }

    public void insireProduto(String cod, String desc, int prezo) {
        java.sql.PreparedStatement ps;
        try {
            ps = conn.prepareStatement("Insert into produtos values (?,?,?)");
            ps.setString(1, cod);
            ps.setString(2, desc);
            ps.setInt(3, prezo);
            ps.executeUpdate();
            System.out.println("Exito en la insercción.");

        } catch (Exception insertar) {
            System.out.println(insertar.getMessage());
        }
    }

    public void amosarFila(String code) throws SQLException {
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from produtos where CODIGO='"+code+"'");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));

        }
    }   public void actualizaPre(String code, int prezo) throws SQLException {
        Statement state = conn.createStatement();
        state.executeUpdate("update produtos set prezo=" + prezo + " where CODIGO='" + code + "'");
        System.out.println("Updated");
    }
       public void borrarFila(String code) throws SQLException{
        Statement state = conn.createStatement();
        state.executeUpdate("DELETE FROM produtos WHERE CODIGO='"+code+"'");
        System.out.println("Delete commited");
       }
    public void listaProdutos() throws SQLException {
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from produtos");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));

        }
}
}
