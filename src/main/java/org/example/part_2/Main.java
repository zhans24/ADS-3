package org.example.part_2;

import org.example.part_1.MyHashtable;
import org.example.part_1.MyTestingClass;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args)  {

        BST<Integer,String> tree=new BST<>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        tree.inorder();

    }



}

