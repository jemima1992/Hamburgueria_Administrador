
package ModeloBeans;

import java.util.ArrayList;
import java.util.List;

public class PedidoBeans {
    private int ID;
    private String Mesa;
    private String Categoria ;
    private String Produto ;
    private float Preço;
    private String Valortotal;
    private String Data;
    private String Hora;
    private String Status;
    private String Observa;
    private List<Integer> CodCardopio;
    private List<Integer> Quantidade;
    private String pesquisa;

    public List<Integer> getCodCardopio() {
        return CodCardopio;
    }

    public void setCodCardopio(List<Integer> CodCardopio) {
        this.CodCardopio = CodCardopio;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
   

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }

    public List<Integer> getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(List<Integer> Quantidade) {
        this.Quantidade = Quantidade;
    }

    public PedidoBeans(){
        CodCardopio = new ArrayList<>();
        Quantidade = new ArrayList<>();
    }

    public int getCodCardopio(int Posicão) {
        return CodCardopio.get(Posicão);
    }

    public void setCodCardopio(int CodCardopio) {
        this.CodCardopio.add(CodCardopio);
    }

    public int getQuantidade(int Posicão) {
        return Quantidade.get(Posicão);
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade.add(Quantidade);
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }


    public float getPreço() {
        return Preço;
    }

    public void setPreço(float Preço) {
        this.Preço = Preço;
    }

    public String getValortotal() {
        return Valortotal;
    }

    public void setValortotal(String Valortotal) {
        this.Valortotal = Valortotal;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
     public String getObserva() {
        return Observa;
    }

    public void setObserva(String Observa) {
        this.Observa = Observa;
    }


  
}
