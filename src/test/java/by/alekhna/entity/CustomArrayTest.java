package by.alekhna.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayTest {

    @Test
    void getIntArrayTest() {
        int[] original = {1, 2, 3};
        CustomArray array = new CustomArray(original);
        original[0] = 99;

        assertArrayEquals(new int[]{1, 2, 3}, array.getIntArray());
    }

    @Test
    void equalsTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});
        CustomArray b = new CustomArray(new int[]{1, 2, 3});

        assertEquals(a, b);
    }

    @Test
    void equalsNegativeTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});
        CustomArray b = new CustomArray(new int[]{4, 5, 6});

        assertNotEquals(a, b);
    }

    @Test
    void equalsLengthNegativeTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});
        CustomArray b = new CustomArray(new int[]{1, 2});

        assertNotEquals(a, b);
    }

    @Test
    void equalsSameObjectTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});

        assertEquals(a, a);
    }

    @Test
    void equalsNullTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});

        assertNotEquals(null, a);
    }

    @Test
    void hashCodeTest() {
        CustomArray a = new CustomArray(new int[]{1, 2, 3});

        assertEquals(a.hashCode(), a.hashCode());
    }
}