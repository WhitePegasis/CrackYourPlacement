//https://leetcode.com/problems/lru-cache/
package stack_and_queues;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // Node class to represent each entry in the doubly linked list.
    class Node {
        Node prev, next; // Pointers to the previous and next nodes.
        int key, value; // The key-value pair stored in the node.
        
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // Head and tail nodes of the doubly linked list.
    Node head;
    Node tail;
    
    // HashMap to store the keys and corresponding nodes for quick access.
    Map<Integer, Node> mp;
    
    // Maximum capacity of the LRU Cache.
    int capacity;
    
    // Constructor to initialize the LRU Cache with a given capacity.
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        head = new Node(0, 0); // Dummy head node.
        tail = new Node(0, 0); // Dummy tail node.
        
        this.capacity = capacity;

        // Initially, the head and tail are connected directly.
        head.next = tail;
        tail.prev = head;
    }
    
    // Method to get the value of a key from the cache.
    public int get(int key) {
        // Check if the key exists in the cache.
        if (mp.containsKey(key)) {
            Node node = mp.get(key); // Retrieve the corresponding node.
            
            // Move the accessed node to the front (most recently used position).
            remove(node);
            insert(node);
            
            return node.value; // Return the value of the node.
        } else {
            return -1; // Key not found, return -1.
        }
    }
    
    // Method to put a key-value pair into the cache.
    public void put(int key, int value) {
        // If the key already exists, remove the old node.
        if (mp.containsKey(key)) {
            remove(mp.get(key));
        }

        // If the cache is at capacity, remove the least recently used node.
        if (mp.size() == capacity) {
            remove(tail.prev);
        }

        // Insert the new node as the most recently used.
        insert(new Node(key, value));
    }

    // Private method to remove a node from the doubly linked list and map.
    private void remove(Node node) {
        mp.remove(node.key); // Remove from the map.
        
        // Re-link the previous and next nodes to bypass the removed node.
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Private method to insert a node at the front of the doubly linked list.
    private void insert(Node node) {
        mp.put(node.key, node); // Add the node to the map.

        // Insert the node right after the head (most recently used position).
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

