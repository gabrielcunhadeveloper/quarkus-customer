package domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.ws.rs.NotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Customer extends PanacheEntity {

    public String name;

    public String cpf;

    @CreationTimestamp
    public LocalDateTime createdAt;

    @UpdateTimestamp
    public LocalDateTime updatedAt;

    public static void update(final Long id, final Customer customer) {
        var customerToUpdate = findById(id);
        customerToUpdate.name = customer.name;
        customerToUpdate.cpf = customer.cpf;

        Customer.persist(customerToUpdate);
    }

    public static Customer findById(Long id) {
        Optional<Customer> customerOptional = findByIdOptional(id);
        customerOptional.orElseThrow(NotFoundException::new);
        return customerOptional.get();
    }


    public static boolean delete(final Long id) {
        findById(id);
        return Customer.deleteById(id);
    }



}
