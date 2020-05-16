/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

class Trie {
    static class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean isEndOfWord;
        public TrieNode(){

        }
        public TrieNode(boolean isEndOfWord){
            this.isEndOfWord = isEndOfWord;
        }
    }
    /** Initialize your data structure here. */
    TrieNode head;
    public Trie() {
        head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            if(temp.children[(int)(word.charAt(i) - 'a')] != null && i == word.length()-1)
                temp.children[(int)(word.charAt(i) - 'a')].isEndOfWord = true;
            else if(temp.children[(int)(word.charAt(i) - 'a')] != null)
                temp = temp.children[(int)(word.charAt(i) - 'a')];
            else if(i != word.length()-1){
                temp.children[(int)(word.charAt(i) - 'a')] = new TrieNode();
                temp = temp.children[(int)(word.charAt(i) - 'a')];
            }
            else{
                temp.children[(int)(word.charAt(i) - 'a')] = new TrieNode(true);
                temp = temp.children[(int)(word.charAt(i) - 'a')];
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            if(temp.children[(int)(word.charAt(i) - 'a')] == null)
                return false;
            else
                temp = temp.children[(int)(word.charAt(i) - 'a')];
        }
        return temp.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = head;
        for(int i=0;i<prefix.length();i++){
            if(temp.children[(int)(prefix.charAt(i) - 'a')] == null)
                return false;
            else
                temp = temp.children[(int)(prefix.charAt(i) - 'a')];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */