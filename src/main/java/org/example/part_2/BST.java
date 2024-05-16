package org.example.part_2;

import lombok.Getter;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    /**
     * Node class representing a node in the BST
     */

    public class Node{
        @Getter
        private K key;
        @Getter
        private V value;
        private Node left,right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    /**
     * Inserts a key-value pair into the BST
     *
     * @param key   The key to insert
     * @param value The value associated with the key
     */

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

    //This method is so that the user can use
    public void put(K key,V value){
        root=put(root,key,value);
    }

    /**
     * Retrieves the value associated with a key from the BST
     *
     * @param key The key to search
     * @return The value associated with the key, or null if key is not found
     */
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


    /**
     * Removes a key-value pair from the BST.
     *
     * @param key The key to remove
     * @return The node associated with the key
     */

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

    /**
     * Helper method to get the node with the maximum key from a given subtree.
     *
     * @param curr The root of the subtree
     * @return The maximum node
     */

    private Node getMaxNode(Node curr) {
        return curr.right==null ? curr : getMaxNode(curr.right);
    }

    //This method is so that the user can use
    public void remove(K key){
        root=remove(root, key);
    }

    /**
     * Returns an Iterable for the BST that provides an Iterator to iterate over its elements
     *
     * @return The Iterable object for the BST
     */

    public Iterable<Node> iterator() {
        Stack<Node> stack = new Stack<>();
        return new Iterable<Node>() {
            @Override
            public Iterator<Node> iterator() {
                return new Iterator<>() {
                    {
                        pushLeft(root);
                    }

                    private void pushLeft(Node node) {
                        while (node != null) {
                            stack.push(node);
                            node = node.left;
                        }
                    }

                    @Override
                    public boolean hasNext() {
                        return !stack.isEmpty();
                    }

                    @Override
                    public Node next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }

                        Node node = stack.pop();
                        pushLeft(node.right);
                        return node;
                    }
                };
            }
        };
    }


    /**
     * Recursively calculates  the size (number of nodes) of the BST.
     *
     * @param curr The current node being considered
     * @return The size of the BST
     */
    private int size(Node curr){
        if (curr==null)
            return 0;
        else
            return 1+size(curr.left)+size(curr.right);
    }

    // This method is so that the user can use
    public int size(){
        return size(root);
    }

}