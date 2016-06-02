package br.com.myapp.mod.pers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}

/*
 * PersistenceUnitUtil é obtido a partir da EntityManagerFactory. O método
 * getIdentifier leva um argumento, um objeto de entidade gerida, e retorna a
 * chave primária. Em caso de uma chave primária composta - uma instância da
 * classe ID ou a classe incorporável é retornado.
 */