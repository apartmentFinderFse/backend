package application.controller;


import application.model.PropertyData;
import application.repository.PropertyRepository;
import application.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyController.class);
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyService propertyService;

    @GetMapping("properties")
    public ResponseEntity<List<PropertyData>> findAllProperties(){
        LOGGER.info("Fetching properties");
        return new ResponseEntity<>(propertyService.findAllProperties(), HttpStatus.OK);

    }

    @GetMapping("property/{propertyId}")
    public ResponseEntity<Optional<PropertyData>> findPropertyById(@PathVariable String propertyId){
        LOGGER.info("Fetching property with ID {}", propertyId);
        return new ResponseEntity<>(propertyService.findPropertyById(propertyId), HttpStatus.OK);
    }
}
