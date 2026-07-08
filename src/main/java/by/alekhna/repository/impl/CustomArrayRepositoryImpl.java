package by.alekhna.repository.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.repository.CustomArrayRepository;
import by.alekhna.specification.CustomArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    static Logger logger = LogManager.getLogger();
    private final List<CustomArray> customArrays;
    private static CustomArrayRepositoryImpl instance;

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    public CustomArrayRepositoryImpl() {
        this.customArrays = new ArrayList<>();
    }

    @Override
    public List<CustomArray> findBy(CustomArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray array : customArrays) {
            if (specification.specified(array)) {
                logger.info("Found array : {}", array.getIntArray());
                result.add(array);
            }
        }
        return result;
    }

    @Override
    public void add(CustomArray customArray) {
        customArrays.add(customArray);
    }

    @Override
    public void remove(CustomArray customArray) {
        customArrays.remove(customArray);
    }
}