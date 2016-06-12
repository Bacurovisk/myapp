package br.com.myapp.mod.mb;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.myapp.mod.bean.Usuario;
import br.com.myapp.mod.dao.RecDAO;

@ManagedBean 

@ViewScoped

public class RecMB {
	
	private RecDAO recDAO = new RecDAO();
    private Usuario usuario = new Usuario();
    
    public String envia() {
          
          usuario = recDAO.getUsuario(usuario.getNome(), usuario.getEmail());
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
