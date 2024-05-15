# <b>MyHashTable</b>

This project implements a custom hash table with chaining for handling collisions. The `MyHashTable` class provides basic operations like `put`, `get`, `remove`, `contains`, and `getKey` for key-value pairs.

# How to Run
-Clone the repository from GitHub using the following command:
>git clone https://github.com/zhans24/ADS-3 

-Compile the TestHashtable.java file using a Java compiler:
>javac MyHashTable.java

-Run the compiled Java program:
>  java TestHashtable

-The program will create an instance of MyHashTable and perform operations on it.
#

# Calculating Elements in Each Bucket

After running the program, the hash table will store elements in various buckets based on the hash code of the keys. To calculate the number of elements in each bucket, the program iterates through the chain array and counts the elements in each bucket.


# Custom Hashing

The MyTestingClass defines a custom hashCode method to ensure uniform distribution of elements in the hash table. You can tune this method for better performance.

# Additional Notes

The project demonstrates how chaining can be used to handle collisions in a hash table.

