package application.service;


import application.model.PropertyData;
import application.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<PropertyData> findAllProperties(){
        return propertyRepository.findAll();
    }

    public Optional<PropertyData> findPropertyById(String propertyId){
        return propertyRepository.findPropertyDataByPropertyId(propertyId);
    }
}
