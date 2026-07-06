package by.alekhna.entity;

import java.util.Arrays;

public class CustomArray {
    private int[] intArray;
    
    public CustomArray(int[] arrayInt){
        this.intArray = arrayInt.clone();
    }

    public int[] getIntArray() {
        return intArray;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) { //equals link to objects
            return true;
        }
        if (!(object instanceof CustomArray)) {
            return false;
        }
        CustomArray that = (CustomArray) object;
        if (intArray.length != that.intArray.length) {
            return false;
        }
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != that.intArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.intArray.hashCode();
    }
}
