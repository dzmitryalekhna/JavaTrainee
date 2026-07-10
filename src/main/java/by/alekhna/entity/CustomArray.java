package by.alekhna.entity;

import by.alekhna.observer.CustomArrayObserver;
import by.alekhna.observer.impl.CustomArrayObserverImpl;
import java.util.UUID;

public class CustomArray {
    private final UUID id;
    private int[] intArray;

    public CustomArray(int[] arrayInt){
        this.id = UUID.randomUUID();
        this.intArray = arrayInt.clone();
        notifyObservers();
    }

    public UUID getId() {
        return id;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
        notifyObservers();
    }

    public void setElementAt(int index, int value) {
        this.intArray[index] = value;
        notifyObservers();
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

    public void notifyObservers() {
        CustomArrayObserver customArrayObserver = new CustomArrayObserverImpl();
        customArrayObserver.handleEvent(this);
    }
}
