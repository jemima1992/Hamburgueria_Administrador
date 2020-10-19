/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexãoBD;
import ModeloBeans.BeansProduto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoProduto {
    
    ConexãoBD conex = new ConexãoBD();
    BeansProduto mod = new BeansProduto();

    
    public void Salvar(BeansProduto mod){
        conex.conexao();   
       
        try {
            PreparedStatement pst = ConexãoBD.con.prepareStatement("INSERT into categorias (ID,Categoria,Produto,Preço)Values(?,?,?,?)");  
            pst.setInt(1,mod.getID());
            pst.setString(2,mod.getCategoria());
            pst.setString(3,mod.getProduto());
            pst.setFloat(4,mod.getPreço());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/Erro"+ex);
        }

        conex.desconecta();
}
    
    public void Editar (BeansProduto mod){
        conex.conexao();
        try {
             PreparedStatement pst = conex.con.prepareStatement("update Categorias  set Categoria = ?, Produto=?, Preço=? where ID = ? ");
             pst.setString(1,mod.getCategoria());
             pst.setString(2,mod.getProduto());
             pst.setFloat(3,mod.getPreço());
             pst.setInt(4,mod.getID());
             pst.execute();
        JOptionPane.showMessageDialog(null , "Dados alterados com sucesso");
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null , "Erro nas alteração dos dados /nErro"+ex);
        }
        
        conex.desconecta();
    }
    
    public void Excluir(BeansProduto mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from categorias where ID =? ");
            pst.setInt(1,mod.getID());
            pst.execute();
            JOptionPane.showMessageDialog(null , "Dados excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "Erro ao excluir dados /nErro"+ex);
        }
        
        conex.desconecta(); 
    }
    
    public BeansProduto buscaProdutos(BeansProduto mod){
        conex.conexao();
        conex.executaSql("select *from categorias where Produto like '%"+mod.getPesquisa()+"%'");
        try {
            if(conex.rs.first()){
            mod.setID(conex.rs.getInt("ID"));
            mod.setCategoria(conex.rs.getString("Categoria"));
            mod.setProduto(conex.rs.getString("Produto"));
            mod.setPreço(conex.rs.getFloat("Preço"));
           }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "Médico não cadastrado  /nErro"+ex);
        }
    
        conex.desconecta();
        return mod;
    }
    }

