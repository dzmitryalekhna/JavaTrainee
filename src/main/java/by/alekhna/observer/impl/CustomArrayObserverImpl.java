package by.alekhna.observer.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.entity.CustomArrayStatistic;
import by.alekhna.observer.CustomArrayObserver;
import by.alekhna.service.ArrayValueService;
import by.alekhna.service.impl.ArrayValueServiceImpl;
import by.alekhna.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    static Logger logger = LogManager.getLogger();

    @Override
    public void handleEvent(CustomArray customArray) {
        ArrayValueService service = new ArrayValueServiceImpl();
        int sum = service.sum(customArray).getAsInt();
        int min = service.min(customArray).getAsInt();
        int max = service.max(customArray).getAsInt();
        double average = service.average(customArray).getAsDouble();
        CustomArrayStatistic statistic = new CustomArrayStatistic(sum, min, max, average);
        Warehouse warehouse = Warehouse.getInstance();
        UUID arrayId = customArray.getId();
        warehouse.put(arrayId, statistic);
        logger.info("Added parameters into warehouse, array ID = {}", arrayId);
    }
}