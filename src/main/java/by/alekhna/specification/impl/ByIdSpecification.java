package by.alekhna.specification.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class ByIdSpecification implements CustomArraySpecification {
    static Logger logger = LogManager.getLogger();
    
    private final UUID id;

    public ByIdSpecification(UUID id) {
        this.id = id;
        logger.info("Search by ID : {}", id);
    }

    @Override
    public boolean specified(CustomArray customArray) {
        return customArray.getId().equals(id);
    }
}
