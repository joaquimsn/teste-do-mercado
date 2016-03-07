package br.com.joaquimsn.mercadoriaws.ws.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Quando um uri não existir informar ao usuário  
 * @author Joaquim Neto
 * Created on Mar 7, 2016 - 3:28:40 AM
 */
@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		String message = "O caminho solicitado não existe";
		return Response.serverError().entity(message).build();
	}

}
