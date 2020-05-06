/*
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2. Note: You may assume the string contain only
 * lowercase letters.
 */

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (count.containsKey(ch)) {
                int val = count.get(ch);
                count.put(ch, val + 1);
            } else {
                count.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}