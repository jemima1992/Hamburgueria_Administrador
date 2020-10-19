
package Controle;

import ModeloBeans.PedidoBeans;
import ModeloDao.PedidoDao;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PedidoController {
    
    PedidoDao PedidoD;
    
    public PedidoController(){
        PedidoD = new PedidoDao();
    }
    
    public void controleDeItens(String Pesquisa, List<String> ListadeItens){
        PedidoD.pesquisaItens(Pesquisa, ListadeItens);
    }
    
    public double controleDeValor(String Pesquisa){
        return PedidoD.ValorDoItem(Pesquisa);
    }
    public int controleDecodigo(String Pesquisa){
        return PedidoD.codigoDoItem(Pesquisa);
    }
  

    public boolean verificaItens(String Valor, String Quantidade,String Codigo,String Item,String Mesa){
        try {
            int X = Integer.parseInt(Quantidade);
            if (X == 0) {
                JOptionPane.showMessageDialog(null, "Campo Quantidade Não Pode Ser 0 !!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
            
        } catch (NumberFormatException Ex) {
            JOptionPane.showMessageDialog(null, "Campo Quantidade  Deve Ser um Numero Inteiro !!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        
        if (Valor.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Valor não pode ser Vazio!!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (Codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Codigo não pode ser Vazio!!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (Item.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Item Selecionado não pode ser Vazio!!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (Quantidade.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Item Quantidade não pode ser Vazio!!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (Mesa.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Mesa não pode ser Vazio!!", "Erro de preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        } else {
        }
        return true;
          
  
    }
    public void controleDePedidos(String CodigoPedido,String Total,String Mesa,int TamanhoTabela, PedidoBeans PedidoB,String Obeservação){
        PedidoD.cadastrarPedido( CodigoPedido, Total,Mesa,TamanhoTabela,PedidoB,Obeservação);
    
    }

   


}
