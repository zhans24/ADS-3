package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Hashtable;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        MyHashtable<Integer,String> arr=new MyHashtable<>();
        arr.put(1, "a");
        arr.put(1, "ass");
        arr.put(1, "s");
        arr.put(1, "c");
        arr.put(1, "b");
        System.out.println(arr);
    }

}

