/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import facade.PersonFacade;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Hassuni
 */
@Path("person")
public class PersonResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    PersonFacade pf = new PersonFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok().entity(gson.toJson(pf.getAllPersonsDTO())).build();
    }

    @GET
    @Path("/allzip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllZipcodes() {
        return Response.ok().entity(gson.toJson(pf.getAllzipCodes())).build();
    }

    @GET
    @Path("hobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonsByHobby(@PathParam("hobby")String hobby){
        List<PersonDTO> persons = pf.getPersonsByHobby(hobby);

        return Response.ok().entity(gson.toJson(persons)).build();
        
    }
    
    @GET
    @Path("number/{phoneNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
        PersonDTO p = pf.getPerson(phoneNumber);
        /*     if (p == null)
        {

            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
         */
        return Response.ok().entity(gson.toJson(p)).build();
    }
}
