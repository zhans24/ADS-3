package org.example.part_1;

import java.util.Arrays;
import java.util.Random;

public class TestHashtable {
    public static void main(String[] args) {
        MyHashtable<MyTestingClass,Animal> hashtable=new MyHashtable<>();
        MyTestingClass testKey;
        Animal value;

        // Loop to insert key-value pairs into the hashtable with 10000 iterations
        for (int i = 0; i < 10_000; i++) {
            testKey=new MyTestingClass(i,"name"+(char) new Random().nextInt(94)); //convert to ASCII
            value=new Animal("Cats"+i,"Mammials");
            hashtable.put(testKey,value);
        }


        // Initializing an array to store the size of elements in each bucket
        int[] elementSize = new int[hashtable.bucketCapacity()];

        // Loop through the keys in the hashtable and calculate the index for each key
        for(MyTestingClass key : hashtable.keySet()) {
            int index = key.hashCode() % hashtable.bucketCapacity();
            elementSize[index]++;
        }

        //Loop to print number of elements
        for(int i = 1; i < elementSize.length+1; i++){
            System.out.println(i + "="   + elementSize[i-1]);
        }

        //Checking for correct numbers of elements ,answer should be equal to 10000
        System.out.println(Arrays.stream(elementSize).sum());

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
