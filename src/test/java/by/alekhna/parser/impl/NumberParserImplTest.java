package by.alekhna.parser.impl;

import by.alekhna.entity.CustomArray;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberParserImplTest {

    private final NumberParserImpl parser = new NumberParserImpl();

    @Test
    void parseNumberLineTest() {
        List<String> lines = List.of("1 2 3", "4,5,6", "7;8;9");
        List<CustomArray> result = parser.parseNumberLine(lines);

        assertEquals(3, result.size());
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0).getIntArray());
        assertArrayEquals(new int[]{4, 5, 6}, result.get(1).getIntArray());
        assertArrayEquals(new int[]{7, 8, 9}, result.get(2).getIntArray());
    }

    @Test
    void parseNumberLineInvalidLinesTest() {
        List<String> lines = List.of("1 2 3", "abc", "", "4 5 6");
        List<CustomArray> result = parser.parseNumberLine(lines);

        assertEquals(2, result.size());
        assertArrayEquals(new int[]{1, 2, 3}, result.get(0).getIntArray());
        assertArrayEquals(new int[]{4, 5, 6}, result.get(1).getIntArray());
    }

    @Test
    void parseNumberLineNoValidTest() {
        List<String> lines = List.of("abc", "", "def");
        List<CustomArray> result = parser.parseNumberLine(lines);

        assertTrue(result.isEmpty());
    }
}