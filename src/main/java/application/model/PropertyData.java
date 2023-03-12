package application.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "propertyData")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyData {
    @Id
    private ObjectId id;
    private String propertyId;
    private String propertyType;
    private String listingStatus;
    private String beds;
    private Object address;
    private Object details;
    private int photoCount;
    private List<Object> photos;

}
