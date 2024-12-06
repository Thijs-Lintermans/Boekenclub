package fact.it.recensieservice.repository;
import fact.it.recensieservice.model.Recensie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import jdk.jfr.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.accessibility.AccessibleIcon;
import java.util.List;

@Repository
@Transactional
public interface RecensieRepository extends JpaRepository<Recensie, Long> {
    List<Recensie> findById(Long id);
}