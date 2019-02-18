class Trie {
    TrieNode root;
    class TrieNode {
        public char val;
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;       
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (char c: word.toCharArray()) {
            if (p.children[c-'a'] == null) {
                p.children[c-'a'] = new TrieNode();
            }
            p = p.children[c-'a'];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (char c: word.toCharArray()) {
            if (p.children[c-'a'] == null) {
                return false;
            } else {
                p = p.children[c-'a'];
            }
        }
        return p.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c: prefix.toCharArray()) {
            if (p.children[c-'a'] == null) {
                return false;
            } else {
                p = p.children[c-'a'];
            }
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
