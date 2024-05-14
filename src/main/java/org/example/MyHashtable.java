package org.example;

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
            return "HashNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
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
}
