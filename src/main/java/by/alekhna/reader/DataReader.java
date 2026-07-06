package by.alekhna.reader;

import by.alekhna.exception.CustomArrayException;

import java.util.List;

public interface DataReader {
    List<String> readFile(String path) throws CustomArrayException;
}
