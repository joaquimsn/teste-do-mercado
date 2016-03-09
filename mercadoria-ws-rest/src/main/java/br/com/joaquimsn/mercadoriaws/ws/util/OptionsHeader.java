package br.com.joaquimsn.mercadoriaws.ws.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


@Provider
public class OptionsHeader implements	ContainerResponseFilter {
	
	private static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
	private static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
	
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN_ANYONE = "*";

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_ORIGIN_ANYONE);
		responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, DELETE, PUT");
		responseContext.getHeaders().add(ACCESS_CONTROL_ALLOW_HEADERS, "X-Requested-With, Content-Type, X-Codingpedia");
	}
}