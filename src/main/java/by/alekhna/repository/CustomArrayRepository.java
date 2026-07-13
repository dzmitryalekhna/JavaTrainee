package by.alekhna.repository;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepository  {
    static Logger logger = LogManager.getLogger();
    private final List<CustomArray> customArrays;
    private static CustomArrayRepository instance;

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public CustomArrayRepository() {
        this.customArrays = new ArrayList<>();
    }

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

    public boolean add(CustomArray customArray) {
        if (customArrays.contains(customArray)) {
            return false;
        }
        customArrays.add(customArray);
        return true;
    }

    public boolean remove(CustomArray customArray) {
        return customArrays.remove(customArray);
    }
}