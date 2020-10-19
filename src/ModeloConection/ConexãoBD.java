/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class ConexãoBD {
    
    public static PreparedStatement stm ;
    public static ResultSet rs ;
    public static Connection con ;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/hamburgueria";
    private String usuario = "root";
    private String senha = "";

   
    
    public void conexao(){
        try {
            String setProperty = System.setProperty("jbdc.Driver", driver  );
            con = (Connection) DriverManager.getConnection(caminho , usuario , senha );
           // JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados:\n"+ex);
        }
    }
    
    public void executaSql(String sql){
        try {
            Statement stm =  con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ExecutaSQL :\n"+ex);
        }
        
        
    }
    
    public void desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexãoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  }

   

   
}
    

