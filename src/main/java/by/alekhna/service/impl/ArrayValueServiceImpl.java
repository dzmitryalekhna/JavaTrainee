package by.alekhna.service.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.service.ArrayValueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayValueServiceImpl implements ArrayValueService {
    static Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt sum(CustomArray customArray) {
        int sum = Arrays.stream(customArray.getIntArray()).sum();
        logger.info("Sum of array elements  = {}", sum);
        return OptionalInt.of(sum);
    }
    
    @Override
    public OptionalDouble average(CustomArray customArray) {
        OptionalDouble average = Arrays.stream(customArray.getIntArray()).average();
        logger.info("Average value of array = {}", average.getAsDouble());
        return average;
    }
    
    @Override
    public OptionalInt min(CustomArray customArray) {
        OptionalInt min = Arrays.stream(customArray.getIntArray()).min();
        logger.info("Min of array elements  = {}", min.getAsInt());
        return Arrays.stream(customArray.getIntArray()).min();
    }

    @Override
    public OptionalInt max(CustomArray customArray) {
        OptionalInt max = Arrays.stream(customArray.getIntArray()).max();
        logger.info("Max of array elements  = {}", max.getAsInt());
        return Arrays.stream(customArray.getIntArray()).max();
    }
}
