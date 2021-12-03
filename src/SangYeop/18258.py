from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
q = deque([])

for i in range(N):
    op = input().split()
    if op[0] == "push":
        q.appendleft(int(op[1]))
    elif op[0] == "front":
        if q:
            print(q[-1])
        else:
            print(-1)
    elif op[0] == "back":
        if q:
            print(q[0])
        else:
            print(-1)
    elif op[0] == "size":
        print(len(q))
    elif op[0] == "empty":
        if not q:
            print(1)
        else:
            print(0)
    else:
        if not q:
            print(-1)
        else:
            print(q.pop())