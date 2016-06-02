package br.com.myapp.mod.crud;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.myapp.mod.val.Usuario;

public class RecCRUD {
	
	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("default");
private EntityManager em = factory.createEntityManager();

public Usuario getUsuario(String nome, String email) {

      try {
            Usuario usuario = (Usuario) em
                       .createQuery(
                                   "SELECT u from Usuario u where u.nome = :name and u.email = :email")
                       .setParameter("name", nome)
                       .setParameter("email", email).getSingleResult();

            return usuario;
      } catch (NoResultException e) {
            return null;
      }
}

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


}