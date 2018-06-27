package com.spring.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.spring.restws.model.Patient;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/patientservice")
public interface PatientService {

	@Path("/patients")
	@GET
	public List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	public Patient getPatient(@PathParam(value = "id") Long id);
	
	@Path("/patients")
	@POST
	public Response addPatient(Patient p);
	
	@Path("/patients")
	@PUT
	public Response updatePatient(Patient p);
	
	@Path("/patients/{id}")
	@DELETE
	public Response deletePatient(@PathParam("id") long id);
}
