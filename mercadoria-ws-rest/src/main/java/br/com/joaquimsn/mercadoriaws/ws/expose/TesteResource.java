package br.com.joaquimsn.mercadoriaws.ws.expose;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/teste")
public class TesteResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response teste() {
		return Response.ok("name : 'joaquim'", MediaType.APPLICATION_JSON).build();
	}
}
