package org.example.part_1;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class MyHashtable<K,V>{
    private   HashNode<K, V>[] chain;
    private int size;
    private int DEFAULT=11;

    /**
     * Default constructor for MyHashtable
     * Initializes the Hashtable with the default size
     */
    public MyHashtable(){
        this.chain=new HashNode[DEFAULT];
    }

    /**
     * Constructor for MyHashtable with custom size
     * Initializes the Hashtable with the specified size
     */
    public MyHashtable(int size){
        this.DEFAULT=size;
        this.chain=new HashNode[size];
    }

    /**
     *This method calculates the hash index for a given key in the Hashtable
     *
     *@param key The key for which the hash index is to be calculated
     *@return The hash index for the given key
     */
    private int hash(K key){
        return Math.abs(key.hashCode())%DEFAULT;
    }// to create index

    public static class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key,V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            HashNode<K,V> temp = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (temp != null) {
                sb.append(temp.key + " : " + temp.value);
                if (temp.next!=null)
                    sb.append(", ");
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
    /**
     * This method puts a key-value pair into the Hashtable
     *
     * @param key The key to be inserted
     * @param value The value associated with the key
     */
    public void put(K key,V value){
        HashNode<K,V> curr=chain[hash(key)];

        if (curr==null)
            chain[hash(key)] = new HashNode<>(key, value);
        else {
            while (curr.next!=null){
                if (curr.key==key) {
                    curr.value = value;
                    return;
                }
                curr=curr.next;
            }

            if (curr.key.equals(key)){
                curr.value=value;
                return;
            }
            curr.next=new HashNode<>(key,value);

        }
    }

    /**
     * This method removes a key-value pair from the Hashtable based on the key provided
     *
     * @param key The key of the pair to be removed
     * @return The value associated with the removed key, or null if the key is not found
     */
    public V remove(K key){
        HashNode<K,V> curr=chain[hash(key)];
        HashNode<K,V> prev=null;

        while (curr!=null){
            if (curr.key==key){
                if (prev==null)
                    chain[hash(key)]=curr.next;
                else
                    prev.next=curr.next;
                size--;
                return curr.value;
            }
            prev=curr;
            curr=curr.next;
        }
        return null;
    }

    /**
     * This method retrieves the value associated with a given key in the Hashtable
     *
     * @param key The key to retrieve the value
     * @return The value associated with the given key, or null if the key is not found
     */
    public V get(K key){
        HashNode<K,V> curr=chain[hash(key)];
        while (curr!=null){
            if (curr.key==key)
                return curr.value;
            curr=curr.next;
        }
        return null;
    }

    /**
     * This method retrieves the key associated with a given value in the Hashtable
     *
     * @param value The value to retrieve the key
     * @return The key associated with the given value, or null if the value is not found
     * */
    public K getKey(V value){
        for (HashNode<K,V> node:chain) {
            HashNode<K,V> curr=node;
            while (curr!=null){
                if (curr.value.equals(value))
                    return curr.key;
                curr=curr.next;
            }
        }
        return null;
    }

    /**
     * This method checks if a given value exists in the Hashtable
     *
     * @param value The value to check for existence
     * @return true if the value is found, false otherwise
     */
    public boolean contains(V value){
        for (HashNode<K,V> node:chain) {
            HashNode<K,V> curr=node;
            while (curr!=null){
                if (curr.value.equals(value))
                    return true;
                curr=curr.next;
            }
        }
        return false;
    }

    /**
     * This method returns the count of elements
     *
     * @return The number of key-value pairs in the Hashtable
     * */
    public int size(){
        return this.size;
    }

    /**
     * This method returns the capacity of the bucket in the Hashtable
     * @return The capacity of the bucket
     */
    public int bucketCapacity(){return DEFAULT;}

    /**
     * This method returns a set of all keys in the Hashtable
     * @return A set containing all keys in the Hashtable
     */
    public Set<K> keySet(){
        Set<K> keySet=new HashSet<>();
        for (int i = 0; i < DEFAULT; i++) {
            HashNode<K,V> curr=chain[i];
            while (curr!=null){
                keySet.add(curr.key);
                curr=curr.next;
            }
        }
        return keySet;
    }

    /**
     * toString method to output
     * @return representation of the Hashtable
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < DEFAULT; i++) {
            if (chain[i] != null) {
                sb.append(chain[i]);
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
