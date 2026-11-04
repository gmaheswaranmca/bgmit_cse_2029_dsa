class Solution:
    def isValid(self, s: str) -> bool:
        stk = []     
        for i in range(len(s)):
            if s[i] == '(' or s[i] == '[' or s[i] == '{':
                stk.append(s[i])
            else:
                if (len(stk) == 0 or
                   (stk[-1] == '(' and s[i] != ')') or
                   (stk[-1] == '[' and s[i] != ']') or
                   (stk[-1] == '{' and s[i] != '}')):
                    return False
                stk.pop()
        
        return len(stk) == 0