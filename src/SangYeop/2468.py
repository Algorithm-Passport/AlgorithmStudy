from collections import deque

n = int(input())
board = []
visited = [[0] * n for _ in range(n)]
for _ in range(n):
  board.append(list(map(int,input().split())))


dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y,h):
  visited[x][y]=1
  if board[x][y] > h:
    q = deque()
    q.append((x,y))
  else:
    return False
  while q:
    x,y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if 0 <= nx and nx < n and 0 <= ny and ny < n and visited[nx][ny]==0 and board[nx][ny] > h:
        q.append((nx,ny))
        visited[nx][ny] = 1
  return True


arr = []
cnt = 0
haspr=True
for h in range(100):
  visited = [[0] * n for _ in range(n)]
  cnt = 0
  for i in range(n):
    for j in range(n):
      if visited[i][j]==0:
        if bfs(i,j,h)==True:
          cnt+=1
  arr.append(cnt)
  
print(max(arr))
