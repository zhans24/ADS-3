package org.example.part_2;


import java.util.TreeMap;

public class TestBST {
    public static void main(String[] args)  {
        BST<Integer,String> bst=new BST<>();
        bst.put(20, "a21");
        bst.put(10, "b");
        bst.put(30, "c");
        bst.put(40, "aas");
        bst.put(5, "ads");
        bst.put(23, "ads");
        System.out.println("BEFORE:");
        System.out.println(bst);
        System.out.println(bst.size());
        System.out.println();
        bst.remove(20);
        System.out.println("AFTER:");
        System.out.println(bst);
        System.out.println(bst.size());





    }



}

