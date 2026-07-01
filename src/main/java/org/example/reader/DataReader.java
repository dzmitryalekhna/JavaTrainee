package org.example.reader;

import java.io.IOException;
import java.util.List;

public interface DataReader {
    List<String> readFile(String path) throws IOException;
}
