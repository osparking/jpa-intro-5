package space.bum.sboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ItemOIO {
  public ItemOIO(CartOIO cart1) {
    this.cart = cart1;
  }

  @Id
  @GeneratedValue
  private Long itemId;
  
  @ManyToOne
  @JoinColumn(name = "cart_id", insertable = false, updatable = false)
  private CartOIO cart;
}
