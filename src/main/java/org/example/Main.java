package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.parser.NumberParser;
import org.example.parser.impl.NumberParserImpl;
import org.example.reader.DataReader;
import org.example.reader.impl.DataReaderImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();

    static void main() throws IOException {
        //Read line from file
        DataReader reader = new DataReaderImpl();
        List<String> linesFromFile = reader.readFile("data/data.txt");
        
        //Validate and Parse lines  
        NumberParser parser = new NumberParserImpl();
        parser.parseNumberLine(linesFromFile);
        
        
        logger.info("File {} was read successfully", "data");
        for(String line: linesFromFile){
            System.out.println(line);
           logger.debug(line);
        }
    }
}
