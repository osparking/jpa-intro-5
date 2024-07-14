package space.bum.sboot.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import space.bum.sboot.config.Direction;
import space.bum.sboot.enums.NullOrder;
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

  public List<SoapOrder> getOrderSortByCustomer(NullOrder null_order) {
    String jql = "Select so from SoapOrder as so order by so.customer";
    StringBuffer jsql = new StringBuffer();

    jsql.append(jql);
    if (null_order == NullOrder.FIRST) {
      jsql.append(" NULLS FIRST");
    } else if (null_order == NullOrder.LAST) {
      jsql.append(" NULLS LAST");
    }

    Query sortedSoapQuery = em.createQuery(jsql.toString(), SoapOrder.class);
    List<SoapOrder> results = sortedSoapQuery.getResultList();

    return results;
  }
}
