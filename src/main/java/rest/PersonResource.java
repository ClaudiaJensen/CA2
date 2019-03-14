/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import entity.Person;
import facade.PersonFacade;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons(){
        return Response.ok().entity(gson.toJson(pf.getAllPersonsDTO())).build();
    }
    
     @GET
    @Path("/allzip")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllZipcodes(){
        return Response.ok().entity(gson.toJson(pf.getAllzipCodes())).build();
    }
    
    
    
//    @GET
//    @Path("/personsbyhobby")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPersonsByHobby(@PathParam("hobby")Hobby hobby){
//        
//        return Response.ok().entity(gson.toJson(pf.getPersonsByHobby(hobby))).build();
//        
//    }
    /*
    @GET
    @Path("/{phoneNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(@PathParam("phoneNumber")String phoneNumber){
        PersonDTO p = pf.getPerson(phoneNumber);
    
    return Response.ok().entity(gson.toJson(p)).build();
    */
    

    
    @GET
    @Path("/getPersonByPhoneNumber")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByPhoneNumber(@PathParam("phoneNumber")String phoneNumber){
        PersonDTO p = pf.getPerson(phoneNumber);
//        if(p == null)
//        {
//            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
//        }
        return Response.ok().entity(gson.toJson(p)).build();
    }
}
/*
    // SImple method to see if the service is running. Test with: /api/customer
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok().entity(gson.toJson(cf.getAllCustomers())).build();
    }

    // Simple method to test use of Path annotation. Test with /api/customer/allasmap
    @GET
    @Path("/allasmap")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response.ok().entity(gson.toJson(cf.getData())).build();
    }
    
    // Simple method to use with javascript (See the script.js file.
    // Test with /api/customer/allasarray Better for javascript to get an array of objects
    @GET
    @Path("/allasarray")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllasArray() {
        return Response.ok().entity(gson.toJson(cf.getData().values())).build();
    }

    // Method to test the use of semantic parameters. Test with /api/customer/3
    @GET
    @Path("/{id}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id) throws CustomerNotFoundException {
        Customer c = cf.getCustomerById(id);
        if(c==null) throw new CustomerNotFoundException("no customer with id: "+id);
        return Response.ok().entity(gson.toJson(c)).build();
    }
    
    // Method to test use of url query string parameters. Test with /api/customer/queryparam?olderThan=50
    @GET
    @Path("/queryparam") 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> showUseOfQueryParam(@QueryParam("olderThan") int age) {
        List<Customer> all = new ArrayList(cf.getAllCustomers());
        List older = all.stream().filter((cus)->cus.getAge()>age).collect(Collectors.toList());
        return older;
    }

    // Method to test use of request parameters from a web form. Test with POST: /api/customer/ DATA: {"name": "Svend Auken","age": 82}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postCustomer(String content) {
        Customer newCustomer = gson.fromJson(content, Customer.class);
        System.out.println("newCustomer: " + newCustomer);
        Customer c = cf.createCustomer(newCustomer);
        return Response.ok().entity(gson.toJson(c)).build();
    }

    // Simple errorhandling. Test the use of jersey WebApplicationException. Test with /api/customer/test/2 and /api/customer/test/10 to see difference look in browsers network tab for 404.
    @GET
    @Path("/test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id) {
        Customer cust = cf.getCustomerById(id);
        if (cust == null){
           throw new WebApplicationException(Response.Status.NOT_FOUND); //look for 404 not found in the browser.
        }
        return cust;
    }
    // Test the jersey automatic conversion of List<Customer> to json (or xml based on the @produces media type). 
    // Test with GET: /api/customer/test/all
    @GET
    @Path("/test/all")
    @Produces(MediaType.APPLICATION_JSON)
        public List<Customer> getCustomersALL() {
        return cf.getAllCustomers();
    }
    
    // ErrorHandling Test using the Exception DTO to wrap the Exception and send as json. 
    // Test with /api/customer/test/ex
    @GET
    @Path("/test/ex")
    @Produces(MediaType.APPLICATION_JSON)
    public String testExceptionDTO() {
        try {
            throw new NumberFormatException("Number must be an integer");
        } catch (NumberFormatException e) {
            ExceptionDTO exDTO = new ExceptionDTO(e, 406, true);
            return gson.toJson(exDTO);
        }
    }
    
    // Test using both the specific CustomerNotFoundExceptionHandler and the generic ExceptionMapper that will catch all the rest. 
    // Test with /api/customer/test/exmap/3 or api/customer/test/exmap/10 to see either the general server exception the specific CustomerNotFoundException.
    @GET
    @Path("/test/exmap/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String testExceptionMapper(@PathParam("id")int id) throws CustomerNotFoundException, Exception {
        Customer cus = cf.getCustomerById(id);
        if(cus == null)
            throw new CustomerNotFoundException("No customer for you I'm sorry");
        throw new Exception("Some server side error happend bla bla bla");
    }
    
    // Method to test use PUT from script.js. Test with PUT: /api/customer/1 DATA: {"name": "Svend Auken","age": 82}
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer( String content, @PathParam("id") int id) throws CustomerNotFoundException {
        Customer newCustomer = gson.fromJson(content, Customer.class);
        Customer savedCus = cf.getCustomerById(id);
        if(savedCus == null)
            throw new CustomerNotFoundException("no customer with id: "+id);
        if(newCustomer.getName()!=null)
            savedCus.setName(newCustomer.getName());
        if(newCustomer.getAge()!=0)
            savedCus.setAge(newCustomer.getAge());
        return Response.ok().entity(gson.toJson(savedCus)).build();
    }
    
    // Method to test use of DELETE form script.js. 
    // Test with DELETE: /api/customer/1 
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id")int id) throws CustomerNotFoundException {
//        Customer cust = customers.get(id);
        Customer c = cf.deleteCustomer(id);
        if(c== null)
            throw new CustomerNotFoundException("no customer with id: "+id+" to delete");
        return Response.ok().entity(gson.toJson(c)).build();
    }
}

*/

