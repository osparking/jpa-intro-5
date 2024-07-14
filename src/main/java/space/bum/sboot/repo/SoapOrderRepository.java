package space.bum.sboot.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import space.bum.sboot.config.Direction;
import space.bum.sboot.sort.SoapOrder;

@Repository
public class SoapOrderRepository {
  @Autowired
  private EntityManager em;

  public List<SoapOrder> getSortedSoapOrders(Direction direction) {

    String jql = "Select so from SoapOrder as so order by so.orderId";
    StringBuffer jsql = new StringBuffer();

    jsql.append(jql);
    if (direction == Direction.DESC) {
      jsql.append(" desc");
    }

    Query sortedSoapQuery = em.createQuery(jsql.toString(), SoapOrder.class);
    List<SoapOrder> results = sortedSoapQuery.getResultList();

    return results;
  }

  public List<SoapOrder> getOrderSortByCount(Direction direction) {
    String jql = "Select so from SoapOrder as so "
        + "order by so.soapCount, so.orderId";
    StringBuffer jsql = new StringBuffer();

    jsql.append(jql);
    if (direction == Direction.DESC) {
      jsql.append(" desc");
    }

    Query sortedSoapQuery = em.createQuery(jsql.toString(), SoapOrder.class);
    List<SoapOrder> results = sortedSoapQuery.getResultList();

    return results;
  }
}
