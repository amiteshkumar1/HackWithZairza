/* Description of the Java Solution

This Java solution checks whether a string containing only brackets ('(', ')', '{', '}', '[', ']') is valid by ensuring:

Every opening bracket has a matching closing bracket of the same type.

Brackets are closed in the correct order.

Approach::

The solution uses a stack-based approach implemented with Deque<Character> (via ArrayDeque), which is more efficient than using Java’s legacy Stack class.

 Key Idea::

Instead of storing the opening brackets ('(', '{', '[') in the stack, the code pushes the expected closing bracket (')', '}', ']'). 
This simplifies the logic when a closing bracket is encountered: we can just compare it with the top of the stack.

Step-by-Step Explanation::

Initialize a stack using Deque<Character> stack = new ArrayDeque<>().

Iterate over each character ch in the input string:

If ch is an opening bracket::

Push its corresponding closing bracket to the stack.

If ch is a closing bracket::

Check if the stack is empty or if the top of the stack doesn't match ch.

If so, the string is invalid → return false.

Final check::

After the loop, return true only if the stack is empty (all brackets matched).

Example::

Input: "([{}])"
Processing:

'(' → push ')'

'[' → push ']'

'{' → push '}'

'}' matches top → pop

']' matches top → pop

')' matches top → pop
Stack is empty → return true

⏱ Time & Space Complexity:

Time Complexity: O(n) — where n is the length of the input string.

Space Complexity: O(n) — in the worst case, all characters are opening brackets and pushed onto the stack.

Advantages of This Approach:

Clean and concise logic by pushing expected closing brackets.

Uses ArrayDeque for optimal stack performance in Java.

Avoids unnecessary comparisons or map lookups during closing bracket checks.*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': 
                    stack.push(')');
                    break;
                case '{': 
                    stack.push('}');
                    break;
                case '[': 
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
