package com.spring.restws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.spring.restws.exceptions.PatientBusinessException;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {

	@Override
	public Response toResponse(PatientBusinessException exception) 
	{
		StringBuilder message = new StringBuilder();
		message.append("{")
			   .append("\"status\":\"error\"")
			   .append(",")
			   .append("\"message\":\"There is no pataient with that info\"")
			   .append("}");
		
		return Response.serverError().entity(message.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
