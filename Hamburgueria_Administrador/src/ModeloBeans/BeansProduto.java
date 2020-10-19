package ModeloBeans;

public class BeansProduto {
    
    private int ID;
    private String Categoria;
    private String Produto;
    private float Preço;
    private String pesquisa;


    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
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

   
      
}
