package space.bum.sboot.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.bum.sboot.repo.SoapOrderRepository;

@RestController
@RequestMapping("/sortby")
public class SoapOrderController {
  
  @Autowired
  private SoapOrderRepository soRepo;
  
  @GetMapping("/id")
  public List<SoapOrder > findOrderedSoapOrders() {
    return soRepo.getSortedSoapOrders();
  }
}
