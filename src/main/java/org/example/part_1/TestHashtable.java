package org.example.part_1;

import java.util.Hashtable;
import java.util.Random;

public class TestHashtable {
    public static void main(String[] args) {
        MyHashtable<Integer,String> a=new MyHashtable<>();
        for (int i = 1; i < 20; i++) {
            a.put(i, "z"+i);
        }
        System.out.println(a);

    }
}

class Animal{
    String Family;
    String Class;

    public Animal(String Family, String Class) {
        this.Family = Family;
        this.Class = Class;
    }
}
