package com.att.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.att.Person;

/**
 * 
 * @author DineshKori
 *
 */

//http://localhost:9080/RESTfulExample/rest/services/dinesh
//http://localhost:9080/RESTfulExample/rest/services/getAll

@Path("/services")
public class RestService {

	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Message : " + msg;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		populate();
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

	
	private void populate() {
		Person p1 = new Person();
		p1.setAge(25);
		p1.setId(1);
		p1.setName("Shyam");
		
		Person p2 = new Person();
		p2.setAge(25);
		p2.setId(2);
		p2.setName("Ram");
		
		persons.put(p1.getId(), p1);
		persons.put(p2.getId(), p2);
		
	}
}