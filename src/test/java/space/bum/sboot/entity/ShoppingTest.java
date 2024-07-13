package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class ShoppingTest {
  @Autowired
  private Session session;
  
  private long cartId = 0;
  private Item item = null;
  
  @BeforeEach
  void makeSomeTestData() {
    Cart costcoCart = new Cart();
    session.persist(costcoCart);
    cartId = costcoCart.getCart_id();
    
    Item eggBox = new Item();
    item = eggBox;
    eggBox.setCart(costcoCart);
    session.persist(eggBox);
    
    Set<Item> items = new HashSet<>();
    items.add(eggBox);
    costcoCart.setItems(items);    
  }

  @Test
  @Transactional  
  void whenItem2PutIntoCart1_thenItResultInconsistency() {
    Cart cart1 = new Cart();
    Cart cart2 = new Cart();

    Item item1 = new Item(cart1);
    Item item2 = new Item(cart2); 
    Set<Item> itemsSet = new HashSet<Item>();
    itemsSet.add(item1);
    itemsSet.add(item2); // item2 는 cart2 에 있는 줄 아는데
    cart1.setItems(itemsSet); // cart1 으로 들어가고 있다.
  }
  
  @Test
  @Transactional
  void whenCartOfOneItemSavedAndRead_thenOneItemFoundInIt_then_Ok() {    
    var cartRead = session.find(Cart.class, cartId);
    var itemsRead = cartRead.getItems();
    assertEquals(1, itemsRead.size()); 
    assertTrue(itemsRead.contains(item));
  }
}
