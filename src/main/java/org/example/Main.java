package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Hashtable;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        MyHashtable<Integer,String> arr=new MyHashtable<>();
        arr.put(1, "a");
        arr.put(2, "b");
        arr.put(3, "c");
        arr.put(4, "d");
        arr.put(5, "e");
        System.out.println(arr);
        System.out.println(arr.get(3));
        System.out.println(arr.getKey("a"));
    }

}

