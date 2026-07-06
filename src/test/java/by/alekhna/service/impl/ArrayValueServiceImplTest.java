package by.alekhna.service.impl;

import by.alekhna.entity.CustomArray;
import by.alekhna.service.ArrayValueService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.OptionalDouble;
import java.util.OptionalInt;


class ArrayValueServiceImplTest {
    ArrayValueService service;

    @BeforeEach
    void setUp() {
        service = new ArrayValueServiceImpl();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }
    
    @Test
    void sumTest() {
        CustomArray array = new CustomArray(new int[]{1, 2, 3, 4, 5});
        OptionalInt result = service.sum(array);
        Assertions.assertEquals(15, result.getAsInt());
    }

    @Test
    void averageTest() {
        CustomArray array = new CustomArray(new int[]{2, 4, 6, 8});
        OptionalDouble result = service.average(array);
        Assertions.assertEquals(5.0, result.getAsDouble(), 0.0001);
    }

    @Test
    void minTest() {
        CustomArray array = new CustomArray(new int[]{3, 7, 1, 9, 4});
        OptionalInt result = service.min(array);
        Assertions.assertEquals(1, result.getAsInt());
    }

    @Test
    void maxTest() {
        CustomArray array = new CustomArray(new int[]{3, 7, 1, 9, 4});
        OptionalInt result = service.max(array);
        Assertions.assertEquals(9, result.getAsInt());
    }
}