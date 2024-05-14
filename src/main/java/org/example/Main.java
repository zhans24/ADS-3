package org.example;

public class Main {
    public static void main(String[] args)  {
        MyHashtable<Integer,String> arr=new MyHashtable<>();
        arr.put(1, "a");
        arr.put(2, "b");
        arr.put(3, "c");
        arr.put(4, "d");
        arr.put(5, "e");

        System.out.println(arr);
        System.out.println();
        System.out.println(arr.contains("a"));
        System.out.println(arr.size());


    }

}

