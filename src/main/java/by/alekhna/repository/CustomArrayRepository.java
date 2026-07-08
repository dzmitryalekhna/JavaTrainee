package by.alekhna.repository;

import by.alekhna.entity.CustomArray;
import by.alekhna.specification.CustomArraySpecification;
import java.util.List;

public interface CustomArrayRepository {
    List findBy(CustomArraySpecification specification);
}
