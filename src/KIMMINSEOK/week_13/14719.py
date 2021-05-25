import sys
from collections import deque

input = sys.stdin.readline

H,W   = [int(i) for i in input().split()]
data  = [int(i) for i in input().split()]

stack     = 0
answer = 0

maxheight = max(data)
max_idx   = data.index(maxheight) 

# 최대의 왼쪽
tmpmax = 0
for k in range(0,max_idx):
    current = data[k]
    if tmpmax > current:
        stack += (tmpmax - current)
    else:
        tmpmax = current

answer += stack

# 최대의 오른쪽
stack = 0
tmpmax = 0

for k in range(W-1, max_idx, -1):
    current = data[k]
    if tmpmax > current:
        stack += (tmpmax - current)
    else:
        tmpmax = current
        
answer += stack
print(answer)
    
        
