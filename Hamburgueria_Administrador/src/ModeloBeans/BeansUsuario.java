/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBeans;

public class BeansUsuario {
    
    private String ID;
    private String Login;
    private String senha;
    private String UsuPesquisa;

    public String getUsuPesquisa() {
        return UsuPesquisa;
    }

    public void setUsuPesquisa(String UsuPesquisa) {
        this.UsuPesquisa = UsuPesquisa;
    }
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
