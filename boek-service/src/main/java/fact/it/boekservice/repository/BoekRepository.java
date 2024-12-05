package fact.it.boekservice.repository;

import fact.it.boekservice.model.Boek;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface BoekRepository extends MongoRepository<Boek, String> {
    List<Boek> findByTitel(List<String> titel);
}
