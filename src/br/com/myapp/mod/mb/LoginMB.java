package br.com.myapp.mod.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.myapp.mod.crud.LoginCRUD;
import br.com.myapp.mod.val.Usuario;

@ManagedBean 

@ViewScoped

public class LoginMB {
	
	private LoginCRUD loginCRUD = new LoginCRUD();
    private Usuario usuario = new Usuario();
    
    public String envia() {
          
          usuario = loginCRUD.getUsuario(usuario.getNome(), usuario.getSenha());
          if (usuario == null) {
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                       "Erro no Login!"));
                return null;
          } else {
                return "/home";
          }
          
          
    }

    public Usuario getUsuario() {
          return usuario;
    }

    public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
    }

}
