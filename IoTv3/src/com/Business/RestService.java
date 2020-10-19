package com.Business;

import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.Data.DAO;
import com.Models.Audio;

@Path("/api")
public class RestService {

	@GET
	@Path("/ping")
	public Response ping() {
		return Response.ok().entity("Service OK").build();
	}
	
	@GET
	@Path("/allAudio")
	public Response AllAudio() {
		DAO data = new DAO();		

		List<Audio> audios = data.getAllAudio();
		
		if (audios.isEmpty()) {
			return Response.ok().entity("Not Found").build();
		} 
		
		return Response.ok().entity(audios).build();
	}
}
