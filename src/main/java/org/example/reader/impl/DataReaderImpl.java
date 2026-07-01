package org.example.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.reader.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReaderImpl implements DataReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile (String filePath){
        List<String> lines = null;
        Path path = Paths.get(filePath);
        try {
            lines = Files.readAllLines(path);
            logger.info("File {} was read successfully", filePath);
        } catch (IOException e) {
            logger.error("Failed to read file {}", e.getMessage());
        }
        return lines;
    }
}
