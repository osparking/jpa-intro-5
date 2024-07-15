package space.bum.sboot.batch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class SchoolTest {

  @Autowired
  private EntityManager entityManager;
  
  @Transactional
  @Test
  public void whenNotConfigured_ThenSendsInsertsSeparately() {
    for (int i = 1; i <= 10; i++) {
      entityManager.persist(createSchool(i+1));
    }
    entityManager.flush();
  }

  private School createSchool(int i) {
    StringBuffer nameBfr = new StringBuffer("제 ");

    nameBfr.append(i);
    nameBfr.append("학교");
    
    return new School(i, nameBfr.toString(), null);
  }
}
