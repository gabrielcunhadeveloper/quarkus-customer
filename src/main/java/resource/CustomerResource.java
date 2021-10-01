package resource;

import domain.Customer;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/customers")
public class CustomerResource {


    @GET
    public List<Customer> findAll() {
        return Customer.listAll();
    }

    @GET
    @Path("/{id}")
    public Customer findById(@PathParam("id") Long id) {
        return Customer.findById(id);
    }

    @POST
    @Transactional
    public Customer create(Customer customer) {
        customer.persist();
        return customer;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void update(@PathParam("id") Long id, Customer customer) {
        Customer.update(id, customer);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        Customer.delete(id);
    }


}
