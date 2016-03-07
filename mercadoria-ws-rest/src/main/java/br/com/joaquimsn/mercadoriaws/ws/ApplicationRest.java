package br.com.joaquimsn.mercadoriaws.ws;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.joaquimsn.mercadoriaws.ws.expose.MercadoriaResource;
import br.com.joaquimsn.mercadoriaws.ws.expose.TesteResource;


/**
 * Classe responsável por controlar os resources que serão expostos
 * @author Joaquim Neto
 * Created on Mar 6, 2016 - 11:44:24 PM
 */
@ApplicationPath("/api")
public class ApplicationRest extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	@Inject
	private MercadoriaResource mercadoriaResource;
	@Inject
	private TesteResource testeResource;
	
	@PostConstruct
	public void createResoursesRoutes() {
		singletons.add(mercadoriaResource);
		singletons.add(testeResource);
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}