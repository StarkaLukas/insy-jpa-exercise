package at.htl.api;

import at.htl.model.customer.CustomerDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.customer.CustomerService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCustomer() {
        List<Customer> customers = customerService.getAllCustomers();

        return Response.ok(customers).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") Long id) {
        Customer foundCustomer = customerService.getCustomerById(id);
        boolean customerWasFound = foundCustomer != null;

        return (customerWasFound ? Response.ok(foundCustomer) : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDTO newCustomer) {
        boolean result = customerService.addCustomer(newCustomer);
        return (result ? Response.ok(newCustomer) : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
