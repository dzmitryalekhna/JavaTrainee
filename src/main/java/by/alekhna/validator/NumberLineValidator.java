package by.alekhna.validator;

public interface NumberLineValidator {
    boolean isContainNumber(String line);
    String NUMBER_REGEX = "^\\s*[-+]?\\d+([;,]*\\s*[-+]?\\d+)*\\s*$";
}
