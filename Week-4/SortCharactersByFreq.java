/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int max = 0;
        char keyCh = 0;
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<map.size();i++){
            max = 0;
            for(char ch:map.keySet()){
                if(map.get(ch) > max){
                    keyCh = ch;
                    max = map.get(ch);
                }
            }
            if(max != 0){
                for(int j=0;j<max;j++){
                    ans.append(keyCh);
                }
                
                map.put(keyCh, 0);
            }
        }
        
        return ans.toString();
    }
}