package org.example;

import org.example.part_1.MyHashtable;
import org.example.part_1.MyTestingClass;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args)  {

        MyHashtable<Integer, String> hashtable = new MyHashtable<>();
        hashtable.put(1, "a");
        hashtable.put(2, "b");
        hashtable.put(3, "c");
        hashtable.put(4, "d");
        System.out.println(hashtable);
        System.out.println(hashtable.keySet());

    }



}

