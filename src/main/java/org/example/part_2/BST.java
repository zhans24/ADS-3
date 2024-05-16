package org.example.part_2;

import lombok.Getter;

import java.util.Iterator;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node{
        @Getter
        private K key;
        @Getter
        private V value;
        private Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node put(Node curr,K key,V value){
        if (curr==null)
            return new Node(key,value);
        else {
            if (curr.key.compareTo(key)<0){
                curr.right=put(curr.right, key, value);
            }else{
                curr.left=put(curr.left,key,value);
            }
            return curr;
        }
    }


    public void put(K key,V value){
        root=put(root,key,value);
    }

    public V get(K key) {
        Node curr=root;

        while (curr!=null){
            if (curr.key==key)
                return curr.value;
            else if (key.compareTo(curr.key)>0)
                curr=curr.right;
            else
                curr=curr.left;
        }

        return null;
    }

    private Node remove(Node curr,K key){
        if (curr==null)
            return null;

        if (key.compareTo(curr.key)>0)
            curr.right=remove(curr.right, key);

        else if (key.compareTo(curr.key)<0)
            curr.left=remove(curr.left, key);

        else {
            if (curr.left==null)
                return curr.right;
            else if (curr.right==null)
                return curr.left;
            else {
                Node newNode=getMaxNode(curr.left);

                curr.value=newNode.value;
                curr.key=newNode.key;
                curr.left=remove(curr.left, newNode.key);
            }
        }
        return curr;
    }

    private Node getMaxNode(Node curr) {
        return curr.right==null ? curr : getMaxNode(curr.right);
    }

    public void remove(K key){
        root=remove(root, key);
    }

    public Iterable<K> iterator(){
        return new Iterable<K>() {
            @Override
            public Iterator<K> iterator() {

            }
        };
    }


    private int size(Node curr){
        if (curr==null)
            return 0;
        else
            return 1+size(curr.left)+size(curr.right);
    }

    public int size(){
        return size(root);
    }

    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                '}';
    }
}