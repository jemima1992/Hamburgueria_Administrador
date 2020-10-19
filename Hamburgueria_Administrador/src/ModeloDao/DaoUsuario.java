/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloBeans.BeansUsuario;
import ModeloConection.ConexãoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoUsuario {
    ConexãoBD conex = new ConexãoBD();
    BeansUsuario mod = new BeansUsuario();

    public void Salvar(BeansUsuario mod) {
        conex.conexao();

        try {
            PreparedStatement pst = ConexãoBD.con.prepareStatement("INSERT into acesso (ID,Login,Senha)Values(?,?,?)");
            pst.setString(1, mod.getID());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuario inseridos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/Erro" + ex);
        }

        conex.desconecta();
    }
    
    public BeansUsuario buscaUsuario(BeansUsuario mod) {
        conex.conexao();
        conex.executaSql("select *from acesso where Login like '%" + mod.getUsuPesquisa()+ "%'");
        try {
            if (conex.rs.first()) {
                mod.setID(conex.rs.getString("ID"));
                mod.setLogin(conex.rs.getString("Login"));
                mod.setSenha(conex.rs.getString("senha"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado  /nErro" );
        }

        conex.desconecta();
        return mod;
    }
     public void Alterar(BeansUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update acesso set ID=?,Login = ?,  senha=? where Login = ? ");
            pst.setString(1, mod.getID());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getLogin());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário alterados com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro nas alteração dos usuário /nErro" + ex);
        }

        conex.desconecta();
    }
      public void Excluir(BeansUsuario mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from acesso where Login =? ");
            pst.setString(1, mod.getLogin());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário /nErro" + ex);
        }

        conex.desconecta();
    }
}
