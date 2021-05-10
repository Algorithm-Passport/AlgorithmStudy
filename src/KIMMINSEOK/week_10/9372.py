import sys

T = int(sys.stdin.readline())

def DFS(start):
    global data
    global cnt
    current        = data[start]
    visited[start] = True

    for w in current:
        if not visited[w]:
            DFS(w)
            cnt += 1

for i in range(T):
    N,M     = [int(i) for i in sys.stdin.readline().split()]
    data    = [[] for _ in range(N+1)]
    cnt     = 0
    visited = [False for _ in range(N+1)]
    
    for k in range(M):
        s,e = [int(i) for i in sys.stdin.readline().split()]
        data[s].append(e)
        data[e].append(s)

    DFS(1)
    print(cnt)
