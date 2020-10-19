/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBeans;

import java.util.List;


/**
 *
 * @author Jemima
 */
public class BeansPedido {
    private int ID;
    private String Mesa;
    private String Produto ;
    private float Preço;
    private String Valortotal;
    private String Data;
    private String Hora;
    private String Status;
    private String Observa;
    private int Quantidade;
    private String pesquisa;

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getObserva() {
        return Observa;
    }

    public void setObservação(String Observa) {
        this.Observa = Observa;
    }
   
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Mesa
     */
    public String getMesa() {
        return Mesa;
    }

    /**
     * @param Mesa the Mesa to set
     */
    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }

    /**
     * @return the Produto
     */
    public String getProduto() {
        return Produto;
    }

    /**
     * @param Produto the Produto to set
     */
    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    /**
     * @return the Preço
     */
    public float getPreço() {
        return Preço;
    }

    /**
     * @param Preço the Preço to set
     */
    public void setPreço(float Preço) {
        this.Preço = Preço;
    }

    /**
     * @return the Valortotal
     */
    public String getValortotal() {
        return Valortotal;
    }

    /**
     * @param Valortotal the Valortotal to set
     */
    public void setValortotal(String Valortotal) {
        this.Valortotal = Valortotal;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }

    /**
     * @return the Hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * @param Hora the Hora to set
     */
    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the Quantidade
     */
    public int getQuantidade() {
        return Quantidade;
    }

    /**
     * @param Quantidade the Quantidade to set
     */
    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    

}
