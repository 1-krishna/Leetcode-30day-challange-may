/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i=0;i<p.length();i++){
            char curChar = p.charAt(i);
            if(map.containsKey(curChar)){
                map.put(curChar, map.get(curChar) + 1);
            }else{
                map.put(curChar, 1);
            }
        }
        int sIndex = 0, lIndex = 0;
        int pLength = p.length();
        List<Integer> list = new LinkedList<Integer>();
        while(lIndex < s.length()){
            char curChar = s.charAt(lIndex);
            if(map.containsKey(curChar) && map.get(curChar) > 0){
                map.put(curChar, map.get(curChar) - 1);
                lIndex++;
                if(lIndex - sIndex == pLength){
                    list.add(sIndex);
                }
            }else if(sIndex == lIndex){
                lIndex++;
                sIndex++;
            }else{
                map.put(s.charAt(sIndex), map.get(s.charAt(sIndex)) + 1);
                sIndex++;
            }
        }
        return list;
    }
}