package by.alekhna.service;

import by.alekhna.entity.CustomArray;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayValueService {
    OptionalInt sum(CustomArray customArray);
    OptionalInt min(CustomArray customArray);
    OptionalInt max(CustomArray customArray);
    OptionalDouble average(CustomArray customArray);
}
