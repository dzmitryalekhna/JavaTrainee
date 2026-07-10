package by.alekhna.specification.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import by.alekhna.service.ArrayValueService;
import by.alekhna.service.impl.ArrayValueServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class BySummSpecification implements CustomArraySpecification {
    static Logger logger = LogManager.getLogger();
    private final int sumValue;
    private final ArrayValueService arrayValueService;

    public BySummSpecification(int sumValue) {
        logger.info("Search by summ : {}", sumValue);
        this.sumValue = sumValue;
        this.arrayValueService = new ArrayValueServiceImpl();
    }

    @Override
    public boolean specified(CustomArray customArray) {
        OptionalInt sum = arrayValueService.sum(customArray);
        return sum.isPresent() && sum.getAsInt() == sumValue;
    }
}