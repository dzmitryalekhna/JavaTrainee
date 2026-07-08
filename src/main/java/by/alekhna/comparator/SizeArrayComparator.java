package by.alekhna.comparator;

import by.alekhna.entity.CustomArray;
import java.util.Comparator;

public class SizeArrayComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return Integer.compare(customArray1.getIntArray().length, customArray2.getIntArray().length);
    }
}