package org.example.part_1;

import java.util.Objects;

public class MyTestingClass {
    int id;
    String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result=id;
        result= 31*result + (name == null ? 0 : name.hashCode());
        return result;
    }
}
