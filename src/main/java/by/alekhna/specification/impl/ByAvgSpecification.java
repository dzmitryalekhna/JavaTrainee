package by.alekhna.specification.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import by.alekhna.service.ArrayValueService;
import by.alekhna.service.impl.ArrayValueServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class ByAvgSpecification implements CustomArraySpecification {
    static Logger logger = LogManager.getLogger();
    private final double averageValue;
    private final ArrayValueService arrayValueService;

    public ByAvgSpecification(Double averageValue) {
        logger.info("Search by average : {}", averageValue);
        this.averageValue = averageValue;
        this.arrayValueService = new ArrayValueServiceImpl();
    }

    @Override
    public boolean specified(CustomArray customArray) {
        OptionalDouble avg = arrayValueService.average(customArray);
        return avg.isPresent() && Double.compare(avg.getAsDouble(), averageValue) == 0;
    }
}