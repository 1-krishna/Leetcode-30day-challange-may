/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */


class Solution {
    
    public String removeLeadingZero(String num){
        int index = 0;
        for(int i=0;i<num.length();i++){
            if(num.charAt(i) == '0')
                index++;
            else
                return num.substring(index);
        }
        
        if(num.substring(index).equals(""))
            return "0";
        
        return num.substring(index);
    }
    
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<Character>();
        String result = "";
        for(int i=0;i<num.length();i++){
            char cur = num.charAt(i);
            if(k > 0){
                if(st.size() > 0)
                    if(st.peek() < cur)
                        st.push(cur);
                    else
                        while(st.size()>=0 && k >= 0){
                            if(st.size() == 0 || k==0){
                                st.push(cur);
                                break;
                            }
                            if(st.peek() > cur){
                                k--;
                                st.pop();
                            }else{
                                st.push(cur);
                                break;
                            }
                        }
                else
                    st.push(cur);
            }else{
                st.push(cur);
            }
        }
        while(k > 0){
            st.pop();
            k--;
        }
        while(st.size() > 0){
            result = st.pop() + result;
        }
        
        return removeLeadingZero(result);
        
    }
}