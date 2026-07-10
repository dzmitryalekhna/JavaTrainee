package by.alekhna.comparator;

import by.alekhna.entity.CustomArray;
import java.util.Comparator;

public enum CustomArrayComparator implements Comparator<CustomArray> {

    BY_ID((customArray1, customArray2) -> customArray1.getId().compareTo(customArray2.getId())),

    BY_SIZE((customArray1, customArray2) -> Integer.compare(customArray1.getIntArray().length, customArray2.getIntArray().length));

    private final Comparator<CustomArray> comparator;

    CustomArrayComparator(Comparator<CustomArray> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return comparator.compare(customArray1, customArray2);
    }
}