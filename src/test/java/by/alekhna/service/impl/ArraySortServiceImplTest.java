package by.alekhna.service.impl;

import by.alekhna.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortServiceImplTest {

    private final ArraySortServiceImpl service = new ArraySortServiceImpl();

    @Test
    void quickSortTest() {
        CustomArray array = new CustomArray(new int[]{5, 3, 8, 1, 9, 2});
        service.quickSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, array.getIntArray());
    }

    @Test
    void shakeSortTest() {
        CustomArray array = new CustomArray(new int[]{5, 3, 8, 1, 9, 2});
        service.shakeSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, array.getIntArray());
    }
}