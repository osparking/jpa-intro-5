package space.bum.sboot.batch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  
  private String name;
  
  @ManyToOne
  private School school;

}
