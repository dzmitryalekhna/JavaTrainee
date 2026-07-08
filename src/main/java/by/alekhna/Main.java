package by.alekhna;
import by.alekhna.entity.CustomArray;
import by.alekhna.exception.CustomArrayException;
import by.alekhna.parser.NumberParser;
import by.alekhna.parser.impl.NumberParserImpl;
import by.alekhna.reader.DataReader;
import by.alekhna.reader.impl.DataReaderImpl;
import by.alekhna.repository.CustomArrayRepository;
import by.alekhna.repository.impl.CustomArrayRepositoryImpl;
import by.alekhna.service.ArraySortService;
import by.alekhna.service.ArrayValueService;
import by.alekhna.service.impl.ArraySortServiceImpl;
import by.alekhna.service.impl.ArrayValueServiceImpl;
import by.alekhna.specification.CustomArraySpecification;
import by.alekhna.specification.impl.ByAvgSpecification;
import by.alekhna.specification.impl.ByIdSpecification;
import by.alekhna.specification.impl.BySummSpecification;
import by.alekhna.specification.impl.ByValueSpecificaion;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.UUID;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws CustomArrayException {
// TASK 1
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
        
//TASK 2
        //Add all arrays to repository
        CustomArrayRepository customArrayRepository = CustomArrayRepositoryImpl.getInstance();
        for (CustomArray arrayItem : listOfNumberLines) {
            customArrayRepository.add(arrayItem);
        }

        //Find array by ID using findBy with specification
        CustomArray firstArray = listOfNumberLines.get(0);
        UUID requestId = firstArray.getId();
        CustomArraySpecification idSpec = new ByIdSpecification(requestId);
        customArrayRepository.findBy(idSpec);

        //Find array by element using findBy with specification
        CustomArraySpecification valueSpec = new ByValueSpecificaion(1972);
        customArrayRepository.findBy(valueSpec);

        //Find array by summ value using findBy with specification
        CustomArraySpecification summSpec = new BySummSpecification(-30098);
        customArrayRepository.findBy(summSpec);

        //Find array by average value using findBy with specification
        CustomArraySpecification avgSpec = new ByAvgSpecification(130.33333333333334);
        customArrayRepository.findBy(avgSpec);
    }
}
