package by.alekhna.specification.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;

public class IdEqualsSpecification implements CustomArraySpecification {
    @Override
    public boolean specified(CustomArray customArray) {
        return false;
    }
}
