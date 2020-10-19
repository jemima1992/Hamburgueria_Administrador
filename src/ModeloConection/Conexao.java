
package ModeloConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    private final String URL = "jdbc:mysql://localhost:3306/hamburgueria";
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String Usuario = "root";
    private final String Senha = "";
    private static Connection Con ;
     
    
    public Conexao () {
        try {
            Class.forName(Driver);
            Con = DriverManager.getConnection(URL,Usuario,Senha);
            Con.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null,"Conectou com sucesso ","Conectou com o Banco", 1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao conectar no Banco","Erro com o Banco", 0);
        }
        
    }
    
    public static Connection getConnection(){
        if(Con == null){
            Conexao conexao = new Conexao();
           
        }
    
        return Con;
    }
    
    public static void closeConnection(){
        try {
            if(!Con.isClosed()){
                Con.close();
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
  
    
  
}
