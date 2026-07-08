package by.alekhna.comparator;

import by.alekhna.entity.CustomArray;
import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return customArray1.getId().compareTo(customArray2.getId());
    }
}