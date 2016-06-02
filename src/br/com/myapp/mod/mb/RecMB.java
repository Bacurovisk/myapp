package br.com.myapp.mod.mb;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.myapp.mod.crud.RecCRUD;
import br.com.myapp.mod.val.Usuario;

@ManagedBean 

@ViewScoped

public class RecMB {
	
	private RecCRUD recCRUD = new RecCRUD();
    private Usuario usuario = new Usuario();
    
    public String envia() {
          
          usuario = recCRUD.getUsuario(usuario.getNome(), usuario.getEmail());
          if (usuario == null) {
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                       "Erro no Login!"));
                return null;
          } else {
                return "/rec2";
          }
          
          
    }

    public Usuario getUsuario() {
          return usuario;
    }

    public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
    }
   	

}
