package org.example.validator.impl;

import org.example.validator.NumberLineValidator;

public class NumberLineValidatorImpl implements NumberLineValidator {

    @Override
    public Boolean isContainNumber(String line) {
        return (line != null && line.matches(NUMBER_REGEX));
    }
}
