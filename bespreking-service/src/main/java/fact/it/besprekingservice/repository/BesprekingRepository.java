package fact.it.besprekingservice.repository;

import fact.it.besprekingservice.model.Bespreking;
import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.accessibility.AccessibleIcon;
import java.util.List;

@Repository
@Transactional
public interface BesprekingRepository extends JpaRepository<Bespreking, Long> {
    List<Bespreking> findById(Long id);    
}
