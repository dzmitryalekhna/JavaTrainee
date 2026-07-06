package by.alekhna;
import by.alekhna.entity.CustomArray;
import by.alekhna.exception.CustomArrayException;
import by.alekhna.parser.NumberParser;
import by.alekhna.parser.impl.NumberParserImpl;
import by.alekhna.reader.DataReader;
import by.alekhna.reader.impl.DataReaderImpl;
import by.alekhna.service.ArraySortService;
import by.alekhna.service.ArrayValueService;
import by.alekhna.service.impl.ArraySortServiceImpl;
import by.alekhna.service.impl.ArrayValueServiceImpl;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws CustomArrayException {
        //Read line from file
        DataReader reader = new DataReaderImpl();
        List<String> linesFromFile = reader.readFile("data/data.txt");
        
        //Validate and Parse lines
        NumberParser parser = new NumberParserImpl();
        List<CustomArray> listOfNumberLines = parser.parseNumberLine(linesFromFile);
        
        //Find min, max, sum values
        ArrayValueService arrayValueService = new ArrayValueServiceImpl();
        CustomArray customArray = listOfNumberLines.get(0);
        arrayValueService.sum(customArray);
        arrayValueService.min(customArray);
        arrayValueService.max(customArray);
        arrayValueService.average(customArray);
    
        //Perform sort
        ArraySortService arraySortService = new ArraySortServiceImpl();
        arraySortService.quickSort(customArray);
        arraySortService.quickSort(listOfNumberLines.get(1));
    }
}
