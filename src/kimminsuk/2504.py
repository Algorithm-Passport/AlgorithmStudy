import sys

s = sys.stdin.readline().strip()

stack_A = []
stack_B = []
result  = 0
tmp     = 1
e = None
for i in s:
    if i == "(":
        stack_A.append(i)
        tmp *= 2
    elif i == "[":
        stack_B.append(i)
        tmp *= 3
    elif i == ")":
        if stack_A:
            if e == '(':
                result += tmp
            tmp //= 2
            stack_A.pop()
        else:
            result = 0
            break
    elif i == "]":
        if stack_B:
            if e == "[":
                result += tmp
            tmp //= 3
            stack_B.pop()
        else:
            result = 0
            break
    e = i

if stack_A or stack_B:
    print(0)
else:
    print(result)
        
            
