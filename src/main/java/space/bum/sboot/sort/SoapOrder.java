package space.bum.sboot.sort;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOAP_ORDER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoapOrder {
  @Id
  @GeneratedValue
  private Long orderId;
  @CreationTimestamp
  @ColumnDefault("CURRENT_TIMESTAMP")
  private LocalDateTime orderTime;
  private int soapCount;
  
  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  @JsonBackReference
  private Customer customer;

}
