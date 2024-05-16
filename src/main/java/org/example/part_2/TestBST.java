package org.example.part_2;


public class TestBST {
    public static void main(String[] args)  {
        BST<Integer,String> bst=new BST<>();
        bst.put(20, "a21");
        bst.put(10, "b");
        bst.put(30, "c");
        bst.put(40, "aas");
        bst.put(5, "ads");
        bst.put(23, "ads");

        var tree=bst.iterator();

        for (var element:tree) {  // Output elements by foreach loop using the iterator() method
            System.out.println("Key:"+element.getKey()+" Value:"+element.getValue());
        }


    }



}

