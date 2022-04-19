/*
20.Valid Parentheses
-----------------------------
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

class Solution {
    public boolean match(char a, char b){
        if(a=='(' & b ==')'){
            return true;
        }
        if(a=='{' & b =='}'){
            return true;
        }
        if(a=='[' & b ==']'){
            return true;
        }
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length() % 2 != 0){
            return false;
        }
        for( int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else{
                if (st.empty()){
                    return false;
                }else{
                    if(match(st.peek(), s.charAt(i))){
                        st.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(st.empty()){
            return true;
        }else{
            return false;
        }
    }
}
