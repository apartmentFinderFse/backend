package application.repository;

import application.model.PropertyData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyRepository extends MongoRepository<PropertyData, Long> {

    Optional<PropertyData> findPropertyDataByPropertyId(String propertyId);
}
