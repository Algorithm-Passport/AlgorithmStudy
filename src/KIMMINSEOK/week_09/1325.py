import sys
from collections import deque

sy = sys.stdin.readline
N,M = [int(i) for i in sy().split()] # data
data = [[] for _ in range(N+1)] # data (Nodes)

for i in range(M):
    s,t     = [int(i) for i in sy().split()]
    data[t].append(s)


def bfs(start):
    stack = 0

    de = deque()
    de.append(start)
    visited = [0 for _ in range(N+1)]
    visited[start] = 1

    while de:
        current = de.popleft()
        stack += 1
        for w in data[current]:
            if not visited[w]:
                visited[w] = 1
                de.append(w)
    return stack

m      = 0
result = []

for i in range(1,N+1):
    if data[i]:
        tmp = bfs(i)
        if m <= tmp:
            if m < tmp:
                result = []
            m = tmp
            result.append(i)
print(*result)        

    
