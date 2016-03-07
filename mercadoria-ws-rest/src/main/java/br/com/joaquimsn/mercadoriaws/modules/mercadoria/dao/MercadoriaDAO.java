package br.com.joaquimsn.mercadoriaws.modules.mercadoria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.joaquimsn.mercadoriaws.main.dao.GenericDAO;
import br.com.joaquimsn.mercadoriaws.modules.mercadoria.model.Mercadoria;

@Stateless
public class MercadoriaDAO extends GenericDAO<Mercadoria>{
	private static final long serialVersionUID = 3740540171467608530L;
	
	/**
	 * Sobrescreve o contrutor para fornecer o class que será 
	 * utilizado nas operações do entityManager
	 * @author Joaquim Neto 
	 * Created on Mar 7, 2016 - 2:49:23 AM
	 */
	public MercadoriaDAO() {
		super(Mercadoria.class);
	}

	/**
	 * Busca todas as mercadorias ativas na base
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 3:21:05 AM
	 * @return List Mercadoria
	 */
	public List<Mercadoria> findAllActive() {
		String jpql = "SELECT m FROM Mercadoria m WHERE m.ativo = :ativo";
		
		TypedQuery<Mercadoria> typedQuery = entityManager.createQuery(jpql, classe);
		typedQuery.setParameter("ativo", true);
		
		return typedQuery.getResultList();
	}
}
