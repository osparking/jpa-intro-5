package space.bum.sboot.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import space.bum.sboot.sort.SoapOrder;

@Repository
public class SoapOrderRepository {
  @Autowired
  private EntityManager em;

  public List<SoapOrder> getSortedSoapOrders() {

    String jql = "Select so from SoapOrder as so order by so.orderId";
    Query sortedSoapQuery = em.createQuery(jql, SoapOrder.class);
    List<SoapOrder> results = sortedSoapQuery.getResultList();
    return results;
  }
}
