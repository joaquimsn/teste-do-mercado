package br.com.joaquimsn.mercadoriaws.ws.expose;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.joaquimsn.mercadoriaws.modules.mercadoria.model.Mercadoria;
import br.com.joaquimsn.mercadoriaws.modules.mercadoria.service.MercadoriaService;

@Path("/mercadorias")
public class MercadoriaResource implements Serializable {
	private static final long serialVersionUID = 1097526968510251256L;
	
	private static final String CHARACTER_ENCODING = ";charset=UTF-8";
	
	@Inject
	private MercadoriaService mercadoriaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON + CHARACTER_ENCODING)
	public Response findAll() {
		return createSuccessResponse(mercadoriaService.findAllActive());
	}
	
	@GET()
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARACTER_ENCODING)
	public Response findById(@PathParam("id") String id) {
		int idMercadoria;
		
		try {
			idMercadoria = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			return createBadResquestResponse("O id informado é inválido");
		}
		
		return createSuccessResponse(mercadoriaService.findById(idMercadoria));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON + CHARACTER_ENCODING)
	public Response save(Mercadoria mercadoria) {
		mercadoriaService.save(mercadoria);
		System.out.println(mercadoria);
		return Response.status(Status.CREATED).entity(mercadoria).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARACTER_ENCODING)
	public Response update(@PathParam("id") String id, Mercadoria mercadoria) {
		mercadoriaService.update(mercadoria);
		return createSuccessResponse(mercadoria);
	}
	
	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") String id) {
		int idMercadoria;
		
		try {
			idMercadoria = Integer.parseInt(id);
			
			if (!inativarMercadoria(idMercadoria)) {
				new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			return createBadResquestResponse("O id " + id + " não pertence a uma mercadoria");
		}
		
		return createSuccessResponse("Mercadoria excluida logicamente");
	}
	
	/**
	 * Faz a exclusão lógica da mercadoria cadastrada referente ao id passado
	 * por parâmetro
	 * @author Joaquim Neto 
	 * Created on Mar 7, 2016 - 4:59:58 AM
	 * @param idMercadoria
	 * @return <b>true</b> se a mercadoria foi inativada na base
	 */
	public boolean inativarMercadoria(int idMercadoria) {
		Mercadoria mercadoria = mercadoriaService.findById(idMercadoria);
		if (mercadoria != null) {
			mercadoriaService.inactivate(mercadoria);	
			return true;
		}
		
		return false;
	}

	/**
	 * Criar response padronizada de sucesso
	 * @author Joaquim Neto 
	 * Created on Mar 6, 2016 - 11:43:15 PM
	 * @param object
	 * @return Response com Status code 200
	 */
	private Response createSuccessResponse(Object object) {
		return Response.ok(object).build();
	}
	
	/**
	 * Cria response padronizada para as situações onde o conteúdo recebido 
	 * é inválido
	 * @author Joaquim Neto
	 * Created on Mar 7, 2016 - 5:06:52 AM
	 * @param messageErro
	 * @return Response com Status code 400
	 */
	private Response createBadResquestResponse(String messageErro) {
		return Response.status(Response.Status.BAD_REQUEST).entity(messageErro).build();
	}
}
