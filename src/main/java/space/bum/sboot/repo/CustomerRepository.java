package space.bum.sboot.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import space.bum.sboot.sort.Customer;

@Repository
public class CustomerRepository {
  @Autowired
  private EntityManager em;
   
  public List<Customer> getCustomers() {
    String jql = "Select c from Customer as c order by c.custName";
    Query customerQuery = em.createQuery(jql);
    List<Customer> customers = customerQuery.getResultList();
    return customers;
  }
}
