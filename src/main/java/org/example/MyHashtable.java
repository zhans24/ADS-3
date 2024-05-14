package org.example;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

public class MyHashtable<K,V>{
    private  HashNode<K, V>[] chain;
    private int size;
    private int DEFAULT=11;

    public MyHashtable(){
        this.chain=new HashNode[DEFAULT]; //bucket default size is 5
    }

    public MyHashtable(int size){
        this.DEFAULT=size;
        this.chain=new HashNode[size];
    }

    private int hash(K key){
        return Math.abs(key.hashCode())%DEFAULT;
    }// to create index

    private static class HashNode<K,V>{
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
            chain[hash(key)]= new HashNode<>(key, value);
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

    public V get(K key){
        HashNode<K,V> curr=chain[hash(key)];
        while (curr!=null){
            if (curr.key==key)
                return curr.value;
            curr=curr.next;
        }
        return null;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (int i = 0; i < DEFAULT; i++) {
            if (chain[i]!=null) {
                sb.append(chain[i]);
                sb.append(", ");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(", "));

        return sb.append("}").toString();
    }

}
