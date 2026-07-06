package by.alekhna.reader.impl;

import by.alekhna.exception.CustomArrayException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataReaderImplTest {

    private final DataReaderImpl reader = new DataReaderImpl();

    @Test
    void readFileTest(@TempDir Path tempDir) throws IOException, CustomArrayException {
        Path file = tempDir.resolve("test.txt");
        Files.writeString(file, "line1\nline2\nline3");

        List<String> result = reader.readFile(file.toString());

        assertEquals(List.of("line1", "line2", "line3"), result);
    }

    @Test
    void readFileExceptionTest() {
        assertThrows(CustomArrayException.class, () -> reader.readFile("nonexistent.txt"));
    }
}