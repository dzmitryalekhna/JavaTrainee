package by.alekhna.validator;

public interface NumberLineValidator {
    String NUMBER_REGEX = "^\\s*[-+]?\\d+([;,]*\\s*[-+]?\\d+)*\\s*$";
    Boolean isContainNumber(String line);
}
