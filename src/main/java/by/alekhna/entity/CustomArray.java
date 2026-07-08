package by.alekhna.entity;

import java.util.UUID;

public class CustomArray {
    private final UUID id;
    private int[] intArray;

    public CustomArray(int[] arrayInt){
        this.id = UUID.randomUUID();
        this.intArray = arrayInt.clone();
    }

    public UUID getId() {
        return id;
    }

    public int[] getIntArray() {
        return intArray;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
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
