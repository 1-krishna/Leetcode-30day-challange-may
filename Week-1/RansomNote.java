/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

class Solution {
    
    public int[] lowerCaseAlphaCount(String input){
        int arr[] = new int[26];
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            arr[(int)(c)-97]+=1;
        }
        return arr;
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int arr[] = lowerCaseAlphaCount(magazine);
        
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            arr[(int)(c)-97]-=1;
            if(arr[(int)(c)-97] == -1){
                return false;
            }
        }
        return true;
    }
}