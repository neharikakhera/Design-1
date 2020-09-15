//Time complexity: best case O(1), word case O(n) n: size of the bucket(linkdelist) at the particular index
//Space complexity: size of the array O(n), in this case: O(10000)
// I have solved it on leetcode
class MyHashMap {
    // array can help us to perform get, push operation in O(1) time but for removal operation in O(1), we use array of linkedlist
    ListNode[] nodes = new ListNode[10000]; // array of linkedlist
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // find the array index, where key can be present
        int i = index(key);
        //check if any node exists at that index
        if(nodes[i] == null)// new node at the index
             nodes[i] = new ListNode(-1, -1);
        //traverse all the nodes in the linkedlist at that index
        //find the previous node of the node that can contain KEY "key"
        ListNode prev = findNode(key, nodes[i]);
        //if previous node.next -> null => <key, value> pair doesn't exist
        //add <key, value> pair
        if(prev.next == null)
            prev.next = new ListNode(key, value);
        // update <key, value> pair with the given value if the key already exists
        prev.next.val = value;


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // find the array index, where key can be present
        int i = index(key);
        // if no node at that index, return -1
        if(nodes[i] ==  null) return -1;
        // find previous node of node where key can be present
        ListNode prev = findNode(key, nodes[i]);
        //if previous.next == null => key not present, return -1
        if(prev.next == null) return -1;
        // return the value at previous.next
        else return prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         // find the array index, where key can be present
        int i = index(key);
         // if no node at that index, return;
        if(nodes[i] == null) return;
         // find previous node of node where key can be present
        ListNode prev = findNode(key, nodes[i]);
        // //if previous.next == null => key not present, return -1
        if(prev.next == null) return;
        // remove previous.next => node with KEY = "key"
        prev.next = prev.next.next;
    }

    public int index(int key){
        // using hashcode function, we return the index of array where key could be present
        return Integer.hashCode(key) % nodes.length;
    }

    public ListNode findNode(int key, ListNode bucket){
       //this function returns the previous node of the node where key could be present
        //It will search the linkedlist (bucket) passed into the function signature
        ListNode node = bucket;
        ListNode prev = null;
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

class ListNode{
    int key, val;
    ListNode next;
    ListNode(int key, int val){
        this.val = val;
        this.key = key;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
