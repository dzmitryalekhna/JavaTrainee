package by.alekhna.validator.impl;

import by.alekhna.validator.NumberLineValidator;

public class NumberLineValidatorImpl implements NumberLineValidator {

    @Override
    public Boolean isContainNumber(String line) {
        return (line != null && line.matches(NUMBER_REGEX));
    }
}
