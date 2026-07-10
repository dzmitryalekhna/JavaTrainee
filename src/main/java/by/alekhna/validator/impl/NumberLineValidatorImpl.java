package by.alekhna.validator.impl;

import by.alekhna.validator.NumberLineValidator;

public class NumberLineValidatorImpl implements NumberLineValidator {

    @Override
    public boolean isContainNumber(String line) {
        return (line != null && line.matches(NUMBER_REGEX));
    }
}
