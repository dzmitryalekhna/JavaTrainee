package by.alekhna.repository;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import java.util.List;

public interface CustomArrayRepository {
    List<CustomArray> findBy(CustomArraySpecification specification);
    void add(CustomArray customArray);
    void remove(CustomArray customArray);
}
