package br.com.myapp.mod.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.myapp.mod.bean.Usuario;

public class LoginDAO {
	
	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("default");
private EntityManager em = factory.createEntityManager();

public Usuario getUsuario(String nome, String senha) {

      try {
            Usuario usuario = (Usuario) em
                       .createQuery(
                                   "SELECT u from Usuario u where u.nome = :name and u.senha = :senha")
                       .setParameter("name", nome)
                       .setParameter("senha", senha).getSingleResult();

            return usuario;
      } catch (NoResultException e) {
            return null;
      }
}
/*
public boolean inserirUsuario(Usuario usuario) {
      try {
            em.persist(usuario);
            return true;
      } catch (Exception e) {
            e.printStackTrace();
            return false;
      }
}

public boolean deletarUsuario(Usuario usuario) {
      try {
            em.remove(usuario);
            return true;
      } catch (Exception e) {
            e.printStackTrace();
            return false;
      }
}
*/
}