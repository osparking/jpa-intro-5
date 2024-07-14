package space.bum.sboot.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.bum.sboot.config.Direction;
import space.bum.sboot.enums.NullOrder;
import space.bum.sboot.repo.SoapOrderRepository;

@RestController
@RequestMapping("/sortby")
public class SoapOrderController {

  @Autowired
  private SoapOrderRepository soRepo;

  @GetMapping(value = { "/id", "/id/", "/id/{direction}" })
  public List<SoapOrder> findOrderedSoapOrders(
      @PathVariable(required = false) String direction) {
    if ("desc".equalsIgnoreCase(direction)) {
      return soRepo.getSortedSoapOrders(Direction.DESC);
    } else {
      return soRepo.getSortedSoapOrders(Direction.ASC);
    }

  }

  @GetMapping(value = { "/count", "/count/{direction}" })
  public List<SoapOrder> findOrderSortByCount(
      @PathVariable(required = false) String direction) {
    if ("desc".equalsIgnoreCase(direction)) {
      return soRepo.getOrderSortByCount(Direction.DESC);
    } else {
      return soRepo.getOrderSortByCount(Direction.ASC);
    }
  }

  @GetMapping(value = { "/customer", "/customer/{null_order}" })
  public List<SoapOrder> findOrderSortByCustomer(
      @PathVariable(required = false) String null_order) {
    var nullOrder = NullOrder.valueOf(null_order.toUpperCase());
    return soRepo.getOrderSortByCustomer(nullOrder);
  }
}
