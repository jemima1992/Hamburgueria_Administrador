
package ModeloBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author brainiac
 */
public final class ModeloTabela extends AbstractTableModel{
    private ArrayList linhas ;
    private String[] colunas ;

    // Abaixo, método responsável por setar a quantidade de linhas e colunas
    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);        
    }
   
    // abaixo método para retornar as linhas
    public ArrayList getLinhas(){
        return linhas;
       
    }
    
    // método para Setar(Fazer) as linhas, preenchar as linhas 
    public void setLinhas(ArrayList dados){
        linhas= dados;
        fireTableDataChanged();
        fireTableStructureChanged();
       
    }
    
    
     public String[] getColunas(){
        return colunas;
    }
     
     // Responsável por preencher os nomes das colunas
     public void setColunas(String[] categoria){
        colunas= categoria;

     }
     
     // Método para realizar a contagem do número de colunas
     public int getColumnCount(){
         return colunas.length;   // retorna o a qtde de colunas
     }
     
     // conta a quantidade de linhas
     public int getRowCount(){
         return linhas.size();  // conta tamaho da array, qto elementos tem na Array
     }
     
     // responsável por pegar o valor da colunas
     public String getColumnName(int numCol){
         return colunas[numCol];
     }
     
     // Pega colunas(numCol) e linhas(numLin) para montar a tabela
    

    @Override
    public Object getValueAt(int numLin, int numCol) {   
        Object[] linha = (Object[])getLinhas().get(numLin);
         return linha[numCol];


    }

   
}
