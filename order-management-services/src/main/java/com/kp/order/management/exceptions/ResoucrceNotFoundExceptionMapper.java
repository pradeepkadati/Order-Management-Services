package com.kp.order.management.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ResoucrceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{

	@Override
	public Response toResponse(ResourceNotFoundException e) {
		
		ErrorMessage error = new ErrorMessage(e.getMessage(), 401, "google.com");
		
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
