
package ModeloDao;

import ModeloBeans.PedidoBeans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import ModeloConection.Conexao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PedidoDao {
    public static PreparedStatement STM ;
    public static ResultSet RS ;
  
    
    public PedidoDao() {        
    }

    public void pesquisaItens(String Pesquisa, List<String> ListadeItens) {
        
        try {
            String SQLPesquisa = "select * from categorias where  Produto like '%" + Pesquisa + "%';";
            PreparedStatement STM = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet RS = STM.executeQuery();
            while (RS.next()) {
                ListadeItens.add(RS.getString("Produto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double ValorDoItem(String Pesquisa){
        try {
            String SQLPesquisa = "select * from categorias where Produto  = ?; ";
            PreparedStatement STM =  Conexao.getConnection().prepareStatement(SQLPesquisa);
            STM.setString(1, Pesquisa);
            
            ResultSet RS = STM.executeQuery();
            if(RS.next()){
               return RS.getDouble("Preço");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int codigoDoItem(String Pesquisa){
        try {
            String SQLPesquisa = "select * from categorias where Produto  = ?; ";
            PreparedStatement STM =  Conexao.getConnection().prepareStatement(SQLPesquisa);
            STM.setString(1, Pesquisa);
            
            ResultSet RS = STM.executeQuery();
            if(RS.next()){
               return RS.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public void cadastrarPedido(String CodigoPedido, String Total, String Mesa, int TamanhoTabela, PedidoBeans PedidoB, String Obeservação){
        Date Data = new Date();
        SimpleDateFormat FormatoData = new SimpleDateFormat("yyy-MM-dd");
        SimpleDateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");
        try {
            String SQLInsertPedido = "insert into pedidos(Codigo_Pedido,Data,Hora,Valortotal,Status,Mesa,Obeservação) "
                    +"values(?,?,?,?,?,?,?);";
            
            PreparedStatement STM = Conexao.getConnection().prepareStatement(SQLInsertPedido);
            STM.setString(1, "0");
            STM.setString(2, FormatoData.format(Data));
            STM.setString(3, FormatoHora.format(Data));  
            STM.setString(4, Total);
            STM.setString(5, "Pedido Aberto");
            STM.setString(6, Mesa);
            STM.setString(7,Obeservação);
            
            STM.execute();
            
            cadastrarItens(CodigoPedido, Mesa,codigoDoPedido(), TamanhoTabela, PedidoB, Obeservação);
            
            codigoDoPedido();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!", "Cadastro Efetivado", 0, new ImageIcon("imagens/cancelar.png"));
        } catch (SQLException ex) {
            try {
                Conexao.getConnection().rollback();
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    public String codigoDoPedido(){
            String Cod = "0";
        try {
            String SQLSelection = " select Codigo_Pedido from pedidos order by Codigo_Pedido desc limit 1";
            
            PreparedStatement STM = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet RS = STM.executeQuery();
            if (RS.next()) {
                Cod = RS.getString("Codigo_Pedido");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null,Cod,"Numero do Pedido é ",1);
        return Cod;
    }
    
    private void cadastrarItens(String CodigoPedido, String Mesa, String codigoDoPedido, int TamanhoTabela, PedidoBeans PedidoB, String Obeservação){
        for(int i = 0; i <TamanhoTabela;i++){
            try {
                String SQLInsertItens = "insert into item(Codigo_Pedido,Numero_Mesa,Codigo_Produto,Quantidade_Produto,Obeservação)"
                        +"values(?,?,?,?,?)";
                PreparedStatement STM = Conexao.getConnection().prepareStatement(SQLInsertItens);
                STM.setString(1,codigoDoPedido);
                STM.setString(2, Mesa);
                STM.setInt(3, PedidoB.getCodCardopio(i));
                STM.setInt(4, PedidoB.getQuantidade(i));
                STM.setString(5, Obeservação);
                
                STM.execute();
            } catch (SQLException ex) {
                try {
                    Conexao.getConnection().rollback();
                    Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }



}
