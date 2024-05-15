package org.example.part_1;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class MyHashtable<K,V>{
    private   HashNode<K, V>[] chain;
    private int size;
    private int DEFAULT=11;

    public MyHashtable(){
        this.chain=new HashNode[DEFAULT];
    }

    public MyHashtable(int size){
        this.DEFAULT=size;
        this.chain=new HashNode[size];
    }

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
            curr.next=new HashNode<>(key,value);;
        }



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

    public int size(){
        return this.size;
    }

    public int bucketCapacity(){return DEFAULT;}

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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < DEFAULT; i++) {
            if (chain[i] != null) {
                sb.append(chain[i]);
            }
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
