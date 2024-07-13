package space.bum.sboot.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CART")
@Data
@NoArgsConstructor
public class Cart {
  
  @Id
  @GeneratedValue
  private Long cart_id;
  
  @OneToMany(mappedBy="cart")
  private Set<Item> items;
  
}
