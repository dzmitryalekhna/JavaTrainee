package org.example.parser;

import java.util.List;

public interface NumberParser {
    String SEPARATOR_REGEX = "[,;\\s]+";
    List<int[]> parseNumberLine(List<String> numberLines);
}
