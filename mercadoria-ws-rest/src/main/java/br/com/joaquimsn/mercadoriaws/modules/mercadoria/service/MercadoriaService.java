package br.com.joaquimsn.mercadoriaws.modules.mercadoria.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.joaquimsn.mercadoriaws.modules.mercadoria.dao.MercadoriaDAO;
import br.com.joaquimsn.mercadoriaws.modules.mercadoria.model.Mercadoria;

public class MercadoriaService implements Serializable {
	private static final long serialVersionUID = -7537769016132690531L;
	
	@Inject
	private MercadoriaDAO mercadoriaDAO;
	
	/**
	 * Faz a persistencia da mercadoria passada por parametro
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 2:56:18 AM
	 * @param mercadoria Object Entity
	 */
	public void save(Mercadoria mercadoria) {
		mercadoriaDAO.save(mercadoria);
	}
	
	/**
	 * Atualiza a mercadoria persistida
	 * @author Joaquim Neto 
	 * Created on Mar 7, 2016 - 3:00:15 AM
	 * @param mercadoria Object
	 * @return Objeto Atualizado
	 */
	public Mercadoria update(Mercadoria mercadoria) {
		return mercadoriaDAO.update(mercadoria);
	}
	
	/**
	 * Faz a exclusão lógica da mercadoria
	 * @author Joaquim Neto 
	 * Created on Mar 7, 2016 - 3:02:37 AM
	 * @param mercadoria
	 */
	public void inactivate(Mercadoria mercadoria) {
		mercadoria.setAtivo(false);
		mercadoriaDAO.update(mercadoria);
	}
	
	/**
	 * Busca uma mercadoria pelo com base no id informado
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 3:16:32 AM
	 * @param id da mercadoria
	 * @return Object Mercadoria
	 */
	public Mercadoria findById(int id) {
		return mercadoriaDAO.findById(id);
	}
	
	/**
	 * Busca todas as mercadorias cadastradas e ativas
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 3:17:17 AM
	 * @return Lista de Mercadorias
	 */
	public List<Mercadoria> findAllActive() {
		return mercadoriaDAO.findAllActive();
	}
}
