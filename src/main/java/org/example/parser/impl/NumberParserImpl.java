package org.example.parser.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.parser.NumberParser;
import org.example.validator.NumberLineValidator;
import org.example.validator.impl.NumberLineValidatorImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumberParserImpl implements NumberParser {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<int[]> parseNumberLine(List<String> numberLines) {
        NumberLineValidator validator = new NumberLineValidatorImpl();
        
        List<int[]> result = new ArrayList<>();
        for (String line : numberLines) {
            if (line.isBlank() || !validator.isContainNumber(line)) {
                logger.warn("Incorrect data - {}", line);
                continue;
            }
            String[] numbersString = line.strip().split(SEPARATOR_REGEX);
            int[] numbersInt = Arrays.stream(numbersString)
                    .mapToInt(Integer::parseInt)
                    .toArray();            
            result.add(numbersInt);
        }
        return result;
    }
}
