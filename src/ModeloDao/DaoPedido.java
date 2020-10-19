/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexãoBD;
import ModeloBeans.PedidoBeans;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoPedido {
    
    ConexãoBD conex = new ConexãoBD();
   PedidoBeans  mod = new PedidoBeans ();

    
    public void Salvar(PedidoBeans mod){
        conex.conexao();   
       
        try {
            PreparedStatement pst = ConexãoBD.con.prepareStatement("INSERT into pedidos (Codigo_Pedido, Data, Hora, Valortotal, Status, Mesa, Observação)Values(?,?,?,?,?,?,?)");  
            pst.setInt(1,mod.getID());
            pst.setString(2,mod.getData());
            pst.setString(3,mod.getHora());
            pst.setString(4,mod.getValortotal());
            pst.setString(5,mod.getStatus());
            pst.setString(6,mod.getMesa());
            pst.setString(7,mod.getObserva());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Pedido inseridos com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/Erro"+ex);
        }

        conex.desconecta();
}
    
    public void Editar (PedidoBeans mod){
        conex.conexao();
        try {
             PreparedStatement pst = conex.con.prepareStatement("update pedidos set Data = ?, Hora=?, Valortotal=? ,Status= ?, Mesa = ? , Observação =? where Codigo_Pedido = ? ");
             pst.setString(1,mod.getData());
             pst.setString(2,mod.getHora());
             pst.setString(3,mod.getValortotal());
             pst.setString(4,mod.getStatus());
             pst.setString(5,mod.getMesa());
             pst.setInt(6,mod.getID());
             pst.setString(7,mod.getObserva());
             pst.execute();
        JOptionPane.showMessageDialog(null , "Pedido alterados com sucesso");
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null , "Erro nas alteração dos dados /nErro"+ex);
        }
        
        conex.desconecta();
    }
    
    public void Excluir(PedidoBeans mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement ("delete from pedidos where Codigo_Pedido =? ");  
            pst.setInt(1,mod.getID());
            pst.execute();
            JOptionPane.showMessageDialog(null , "Pedido excluidos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "Erro ao excluir Pedidos /nErro"+ex);
        }
        
        conex.desconecta(); 
    }
    
    public PedidoBeans buscaPedidos(PedidoBeans mod) {
        conex.conexao();
        conex.executaSql("select *from pedidos where Mesa like '%" + mod.getPesquisa() + "%'");
        try {
            if (conex.rs.first()) {
                mod.setID(conex.rs.getInt("Codigo_Pedido"));
                mod.setData(conex.rs.getString("Data"));
                mod.setProduto(conex.rs.getString("Hora"));
                mod.setValortotal(conex.rs.getString("Valortotal"));
                mod.setStatus(conex.rs.getString("Status"));
                mod.setMesa(conex.rs.getString("Mesa"));
                mod.setMesa(conex.rs.getString("Observação"));
               
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Pedido não cadastrado  /nErro" + ex);
        }

        conex.desconecta();
        return mod;
    }
    

  
    }

