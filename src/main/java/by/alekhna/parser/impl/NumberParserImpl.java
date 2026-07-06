package by.alekhna.parser.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.parser.NumberParser;
import by.alekhna.validator.NumberLineValidator;
import by.alekhna.validator.impl.NumberLineValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumberParserImpl implements NumberParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<CustomArray> parseNumberLine(List<String> numberLines) {
        NumberLineValidator validator = new NumberLineValidatorImpl();
        
        List<CustomArray> result = new ArrayList<>();
        for (String line : numberLines) {
            if (line.isBlank() || !validator.isContainNumber(line)) {
                logger.warn("Incorrect data - {}", line);
                continue;
            }
            String[] numbersString = line.strip().split(SEPARATOR_REGEX);
            CustomArray numbersInt = new CustomArray(Arrays.stream(numbersString).mapToInt(Integer::parseInt).toArray());
            result.add(numbersInt);
        }
        return result;
    }
}
