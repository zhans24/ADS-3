package org.example.part_1;

import java.util.Objects;

public class MyTestingClass {
    int id;
    String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Overrides the equals method to compare this object with another object for equality
     * @param o The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    /**
     * Overrides the hashCode method to create own hash code for this object
     *
     * @return The hash code for this object
     */
    @Override
    public int hashCode() {
        int result=id;
        result= 31*result + (name == null ? 0 : name.hashCode());
        return result;
    }
}
