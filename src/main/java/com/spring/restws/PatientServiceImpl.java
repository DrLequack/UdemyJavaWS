package com.spring.restws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.spring.restws.model.Patient;

@Service
public class PatientServiceImpl implements PatientService 
{

	Map<Long,Patient> patients = new HashMap<>();
	static Long id = 100L;
	
	public PatientServiceImpl()
	{
		init();
	}

	@Override
	public List<Patient> getPatients() 
	{
		List<Patient> list = new ArrayList<>(patients.values());
		return list;
	}
	
	@Override
	public Patient getPatient(Long id) 
	{
		return patients.get(id);
	}
	
	@Override
	public Response addPatient(Patient p) 
	{
		p.setId(id++);
		patients.put(p.getId(), p);
		return Response.ok(p).build();
	}
	
	@Override
	public Response updatePatient(Patient p) 
	{
		Response response;
		if(patients.containsKey(p.getId()))
		{
			patients.put(p.getId(), p);
			response = Response.ok().build();
		}
		else
		{
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	@Override
	public Response deletePatient(long id) 
	{
		Response response;
		if(patients.containsKey(id))
		{
			patients.remove(id);
			response = Response.ok().build();
		}
		else
		{
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	private void init() 
	{
		Patient p = new Patient();
		p.setId(id++);
		p.setName("Dragnea");
		patients.put(p.getId(), p);
		p = new Patient();
		p.setId(id++);
		p.setName("Tariceanu");
		patients.put(p.getId(), p);
	}

}
