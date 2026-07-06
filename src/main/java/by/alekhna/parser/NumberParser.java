package by.alekhna.parser;

import by.alekhna.entity.CustomArray;
import java.util.List;

public interface NumberParser {
    String SEPARATOR_REGEX = "[,;\\s]+";
    List<CustomArray> parseNumberLine(List<String> numberLines);
}
