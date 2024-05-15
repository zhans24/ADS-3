package org.example.part_1;

import java.util.Random;

public class TestHashtable {
    public static void main(String[] args) {
        MyHashtable<MyTestingClass,Animal> hashtable=new MyHashtable<>();
        MyTestingClass testKey;
        Animal value;
        for (int i = 0; i < 10000; i++) {
            testKey=new MyTestingClass(i,"name"+(char) new Random().nextInt(94)); //convert to ASCII
            value=new Animal("Cats"+i,"Mammials");
            hashtable.put(testKey,value);
        }
        int[] elementSize = new int[hashtable.bucketCapacity()];
        for(MyTestingClass key : hashtable.keySet()) {
            int index = key.hashCode() % hashtable.bucketCapacity();
            elementSize[index]++;
        }


        for(int i = 1; i < elementSize.length+1; i++){
            System.out.println("Bucket " + i + ":"   + elementSize[i-1] + "elements");
        }

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
