package by.alekhna.specification.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ByValueSpecificaion implements CustomArraySpecification {
    static Logger logger = LogManager.getLogger();
    private final int element;

    public ByValueSpecificaion(int element) {
        logger.info("Search by element value : {}", element);
        this.element = element;
    }

    @Override
    public boolean specified(CustomArray customArray) {
        for (int value : customArray.getIntArray()) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }
}