package by.alekhna.warehouse;

import by.alekhna.entity.CustomArrayStatistic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private final HashMap<UUID, CustomArrayStatistic> parameters = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public CustomArrayStatistic put(UUID arrayId, CustomArrayStatistic statistic) {
        return parameters.put(arrayId, statistic);
    }

    public void remove(UUID arrayId) {
        parameters.remove(arrayId);
    }

    public Optional<CustomArrayStatistic> getParameters(UUID arrayId) {
        Optional<CustomArrayStatistic> optionalParameters = Optional.ofNullable(parameters.get(arrayId));
        logger.info("Parameters of array with id = {} - {}", arrayId, optionalParameters.orElse(null));

        return optionalParameters;
    }
}
