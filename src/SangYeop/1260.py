from collections import deque

n, m, v = map(int, input().split())
board =  [[]*(n+1) for _ in range(n+1)]

for _ in range(m):
  x, y = map(int, input().split())
  board[x].append(y)
  board[y].append(x)

for i in range(1,n+1):
  board[i].sort()

visited = [False]*(n+1)

def dfs(n):
  print(n, end=' ')
  visited[n] = True
  for i in board[n]:
    if not visited[i]:
      dfs(i)

def bfs(n):
  visited[n] = True
  q = deque([n])
  while q:
    v = q.popleft()
    print(v, end = ' ')
    for i in board[v]:
      if not visited[i]:
        q.append(i)
        visited[i] = True

dfs(v)
visited = [False]*(n+1)
print()
bfs(v)