package org.example;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

public class MyHashtable<K,V>{
    private HashNode<K,V> chain[];
    private int size;
    private int DEFAULT=5;

    public MyHashtable(){
        this.chain=new HashNode[DEFAULT]; //bucket default size is 5
    }

    public MyHashtable(int size){
        this.DEFAULT=size;
        this.chain=new HashNode[size];
    }

    private int hash(K key){
        return Math.abs(key.hashCode())%DEFAULT;
    }

    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;

        public HashNode(K key,V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return key+":"+value;
        }
    }

    public void put(K key,V value){
        HashNode<K,V> curr=chain[hash(key)];

        if (curr==null)
            chain[hash(key)]=new HashNode<>(key, value);

        else{
            while (curr.next!=null){
                if (curr.key==key){
                    curr.value=value;
                    return;
                }

                curr=curr.next;
            }

            curr.next=curr;
        }
        size++;
    }

    public V remove(K key){
        return null;
    }

    public V getKey(K key){
        return null;
    }

    public K get(V value){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(chain[i]);
            if (i!=size-1)
                sb.append(", ");
        }
        return sb.append("}").toString();
    }


}
