package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
class ShoppingTest {
  @Autowired
  private Session session;

  @Test
  @Transactional
  void whenCartOfOneItemSavedAndRead_thenOneItemFoundInIt_then_Ok() {
    Cart costcoCart = new Cart();
    session.persist(costcoCart);
    
    Item eggBox = new Item();
    eggBox.setCart(costcoCart);
    session.persist(eggBox);
    
    Set<Item> items = new HashSet<>();
    items.add(eggBox);
    costcoCart.setItems(items);
    
    var cartRead = session.find(Cart.class, costcoCart.getCart_id());
    var itemsRead = cartRead.getItems();
    assertEquals(1, itemsRead.size()); 
    assertTrue(itemsRead.contains(eggBox));
  }
}
