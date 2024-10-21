package fact.it.lidservice.repository;

import fact.it.lidservice.model.Lid;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LidRepository extends MongoRepository<Lid, String> {
    List<Lid> findBySkuCodeIn(List<String> skuCode);
}