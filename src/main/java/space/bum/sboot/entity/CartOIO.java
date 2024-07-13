package space.bum.sboot.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class CartOIO {
  @Id
  @GeneratedValue
  private Long cart_id;
  
  @OneToMany
  @JoinColumn(name = "cart_id") // we need to duplicate the physical information
  private Set<ItemOIO> items;
}
