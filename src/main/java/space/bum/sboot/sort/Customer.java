package space.bum.sboot.sort;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
  @Id
  @GeneratedValue
  private Long id;

  private String custName;

  @OneToMany(mappedBy = "customer")
  @OrderBy("soapCount DESC")
  @JsonManagedReference
  private List<SoapOrder> soapOrders;

}
