package org.example.part_2;

public class TestBST {
    public static void main(String[] args)  {

        BST<Integer,String> tree=new BST<>();
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");
        tree.put(0, "fd");
        Iterable<Integer> keys=tree.iterator();
        for (var key:keys) {
            System.out.println(key);
        }

    }



}

