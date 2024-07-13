package space.bum.sboot.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEMS")
@NoArgsConstructor
@Data
public class Item {
  
  @Id
  @GeneratedValue
  private Long item_id;
  
  @ManyToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    return Objects.equals(item_id, other.item_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item_id);
  }
}
