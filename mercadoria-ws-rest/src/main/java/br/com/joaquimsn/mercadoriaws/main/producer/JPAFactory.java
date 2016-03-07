package br.com.joaquimsn.mercadoriaws.main.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class JPAFactory {
	
	@PersistenceUnit(name = "mercadoria-ws-rest")
	private EntityManagerFactory entityManagerFactory;
	
	@Produces
	@SessionScoped
	public EntityManager entityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
